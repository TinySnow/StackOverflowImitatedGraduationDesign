package com.tinysnow.framework.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinysnow.common.constant.ServiceConstants;
import com.tinysnow.framework.security.util.LoginUser;
import com.tinysnow.system.model.User;
import com.tinysnow.system.service.UserService;

@Component
public class LoginService {

    @Autowired
    private TokenService tokenService;

    // @Resource
    // private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    /**
     * 登录验证
     * 
     * @param email 邮箱
     * @param password 密码
     * @return 结果
     */
    public String login(String email, String password) {
        User user = new User();
        user.setEmail(email);
        User findOne = userService.findOne(user);
        if (findOne == null) {
            return null;
        }
        if (!findOne.getPassword().equals(password)) {
            return ServiceConstants.PASSWORD_INCORRECT;
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(findOne);
        return tokenService.createToken(loginUser);
        // boolean captchaEnabled = configService.selectCaptchaEnabled();
        // // 验证码开关
        // if (captchaEnabled) {
        // validateCaptcha(username, code, uuid);
        // }
        // // 用户验证
        // Authentication authentication = null;
        // try {
        // UsernamePasswordAuthenticationToken authenticationToken = new
        // UsernamePasswordAuthenticationToken(username,
        // password);
        // AuthenticationContextHolder.setContext(authenticationToken);
        // // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
        // authentication = authenticationManager.authenticate(authenticationToken);
        // } catch (Exception e) {
        // if (e instanceof BadCredentialsException) {
        // AsyncManager.me().execute(AsyncFactory.recordLogininfor(username,
        // Constants.LOGIN_FAIL,
        // MessageUtils.message("user.password.not.match")));
        // throw new UserPasswordNotMatchException();
        // } else {
        // AsyncManager.me()
        // .execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
        // e.getMessage()));
        // throw new ServiceException(e.getMessage());
        // }
        // } finally {
        // AuthenticationContextHolder.clearContext();
        // }
        // AsyncManager.me().execute(AsyncFactory.recordLogininfor(username,
        // Constants.LOGIN_SUCCESS,
        // MessageUtils.message("user.login.success")));
        // LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // recordLoginInfo(loginUser.getUserId());
        // // 生成token
        // return tokenService.createToken(loginUser);
    }

    // /**
    // * 校验验证码
    // *
    // * @param username 用户名
    // * @param code 验证码
    // * @param uuid 唯一标识
    // * @return 结果
    // */
    // public void validateCaptcha(String username, String code, String uuid) {
    // String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid,
    // "");
    // String captcha = redisCache.getCacheObject(verifyKey);
    // redisCache.deleteObject(verifyKey);
    // if (captcha == null) {
    // AsyncManager.me().execute(AsyncFactory.recordLogininfor(username,
    // Constants.LOGIN_FAIL,
    // MessageUtils.message("user.jcaptcha.expire")));
    // throw new CaptchaExpireException();
    // }
    // if (!code.equalsIgnoreCase(captcha)) {
    // AsyncManager.me().execute(AsyncFactory.recordLogininfor(username,
    // Constants.LOGIN_FAIL,
    // MessageUtils.message("user.jcaptcha.error")));
    // throw new CaptchaException();
    // }
    // }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId) {
        User sysUser = new User();
        sysUser.setId(userId);
        // sysUser.setLoginDate(DateUtil.getNowDate());
        // userService.updateUserProfile(sysUser);
    }
}
