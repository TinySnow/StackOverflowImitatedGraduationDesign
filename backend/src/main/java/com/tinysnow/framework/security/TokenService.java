package com.tinysnow.framework.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import com.tinysnow.common.constant.Constants;
import com.tinysnow.common.utils.strings.StringUtil;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
@ConfigurationProperties(prefix = "token")
@Data
public class TokenService {
    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

    // 令牌自定义标识
    private String header;

    // 令牌秘钥
    private String secret;

    // 令牌有效期（默认30分钟）
    private long expire;

    // 令牌签发者
    private String issuer;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    /**
     * 生成token签名
     * 
     * @param subject
     * @return
     */
    public String createToken(String subject) {
        Date now = new Date();
        // 过期时间
        Date expireDate = new Date(now.getTime() + expire * 1000);

        // 创建Signature SecretKey
        final SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        // header参数
        final Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");

        // 生成token
        String token = Jwts.builder()
                .setHeader(headerMap)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .setIssuer(issuer)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        logger.info("JWT[" + token + "]");
        return token;
    }

    /**
     * 解析token
     *
     * @param token token
     * @return
     */
    public Claims parseToken(String token) {

        Claims claims = null;
        try {
            // 创建Signature SecretKey
            final SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

            claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            logger.info("Parse JWT token success");
        } catch (JwtException e) {
            logger.info("Parse JWT errror " + e.getMessage());
            return null;
        }
        return claims;
    }

    /**
     * 判断token是否过期
     *
     * @param expiration
     * @return
     */
    public boolean isExpired(Date expiration) {
        return expiration.before(new Date());
    }

    // /**
    // * 获取用户身份信息
    // *
    // * @return 用户信息
    // */
    // public LoginUser getLoginUser(HttpServletRequest request) {
    // // 获取请求携带的令牌
    // String token = getToken(request);
    // if (StringUtil.isNotEmpty(token)) {
    // try {
    // Claims claims = parseToken(token);
    // // 解析对应的权限以及用户信息
    // String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
    // String userKey = getTokenKey(uuid);
    // LoginUser user = redisCache.getCacheObject(userKey);
    // return user;
    // } catch (Exception e) {
    // }
    // }
    // return null;
    // }

    // /**
    // * 设置用户身份信息
    // */
    // public void setLoginUser(LoginUser loginUser) {
    // if (StringUtil.isNotNull(loginUser) &&
    // StringUtil.isNotEmpty(loginUser.getToken())) {
    // refreshToken(loginUser);
    // }
    // }

    // /**
    // * 删除用户身份信息
    // */
    // public void delLoginUser(String token) {
    // if (StringUtil.isNotEmpty(token)) {
    // String userKey = getTokenKey(token);
    // redisCache.deleteObject(userKey);
    // }
    // }

    // /**
    // * 创建令牌
    // *
    // * @param loginUser 用户信息
    // * @return 令牌
    // */
    // public String createToken(LoginUser loginUser) {
    // String token = IdUtils.fastUUID();
    // loginUser.setToken(token);
    // setUserAgent(loginUser);
    // refreshToken(loginUser);

    // Map<String, Object> claims = new HashMap<>();
    // claims.put(Constants.LOGIN_USER_KEY, token);
    // return createToken(claims);
    // }

    // /**
    // * 验证令牌有效期，相差不足20分钟，自动刷新缓存
    // *
    // * @param token 令牌
    // * @return 令牌
    // */
    // public void verifyToken(LoginUser loginUser) {
    // long expire = loginUser.getexpire();
    // long currentTime = System.currentTimeMillis();
    // if (expire - currentTime <= MILLIS_MINUTE_TEN) {
    // refreshToken(loginUser);
    // }
    // }

    // /**
    // * 刷新令牌有效期
    // *
    // * @param loginUser 登录信息
    // */
    // public void refreshToken(LoginUser loginUser) {
    // loginUser.setLoginTime(System.currentTimeMillis());
    // loginUser.setexpire(loginUser.getLoginTime() + expire * MILLIS_MINUTE);
    // // 根据uuid将loginUser缓存
    // String userKey = getTokenKey(loginUser.getToken());
    // redisCache.setCacheObject(userKey, loginUser, expire, TimeUnit.MINUTES);
    // }

    // /**
    // * 设置用户代理信息
    // *
    // * @param loginUser 登录信息
    // */
    // public void setUserAgent(LoginUser loginUser) {
    // UserAgent userAgent =
    // UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
    // String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
    // loginUser.setIpaddr(ip);
    // loginUser.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
    // loginUser.setBrowser(userAgent.getBrowser().getName());
    // loginUser.setOs(userAgent.getOperatingSystem().getName());
    // }

    // /**
    // * 从数据声明生成令牌
    // *
    // * @param claims 数据声明
    // * @return 令牌
    // */
    // private String createToken(Map<String, Object> claims) {
    // String token = Jwts.builder()
    // .setClaims(claims)
    // .signWith(SignatureAlgorithm.HS512, secret).compact();
    // return token;
    // }

    // /**
    // * 从令牌中获取数据声明
    // *
    // * @param token 令牌
    // * @return 数据声明
    // */
    // private Claims parseToken(String token) {
    // return Jwts.parser()
    // .setSigningKey(secret)
    // .parseClaimsJws(token)
    // .getBody();
    // }

    // /**
    // * 从令牌中获取用户名
    // *
    // * @param token 令牌
    // * @return 用户名
    // */
    // public String getUsernameFromToken(String token) {
    // Claims claims = parseToken(token);
    // return claims.getSubject();
    // }

    // /**
    // * 获取请求token
    // *
    // * @param request
    // * @return token
    // */
    // private String getToken(HttpServletRequest request) {
    // String token = request.getHeader(header);
    // if (StringUtil.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX))
    // {
    // token = token.replace(Constants.TOKEN_PREFIX, "");
    // }
    // return token;
    // }

    // private String getTokenKey(String uuid) {
    // return CacheConstants.LOGIN_TOKEN_KEY + uuid;
    // }
}