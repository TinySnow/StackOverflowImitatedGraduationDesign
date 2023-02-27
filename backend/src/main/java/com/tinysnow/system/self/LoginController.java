package com.tinysnow.system.self;

// import java.util.List;
// import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinysnow.common.constant.Constants;
import com.tinysnow.common.utils.others.SecurityUtil;
import com.tinysnow.common.utils.response.Response;
import com.tinysnow.framework.security.service.LoginService;
import com.tinysnow.framework.security.util.LoginBody;
import com.tinysnow.system.model.Users;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/body")
    public Response body(@RequestBody LoginBody loginBody) {
        Response response = Response.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getId());
        response.put(Constants.TOKEN, token);
        return response;
    }

    @PostMapping("/param")
    public Response param(@RequestParam LoginBody loginBody) {
        Response response = Response.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getId());
        response.put(Constants.TOKEN, token);
        return response;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("/getInfo")
    public Response getInfo() {
        Users user = SecurityUtil.getLoginUser().getUser();
        // // 角色集合
        // Set<String> roles = permissionService.getRolePermission(user);
        // // 权限集合
        // Set<String> permissions = permissionService.getMenuPermission(user);
        Response response = Response.success();
        response.put("user", user);
        // response.put("roles", roles);
        // response.put("permissions", permissions);
        return response;
    }

    // /**
    //  * 获取路由信息
    //  * 
    //  * @return 路由信息
    //  */
    // @GetMapping("getRouters")
    // public Response getRouters() {
    //     Long userId = SecurityUtil.getUserId();
    //     List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
    //     return Response.success(menuService.buildMenus(menus));
    // }
}
