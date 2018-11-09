package com.xiaozhao.shiro;

import com.xiaozhao.domain.Permission;
import com.xiaozhao.domain.Role;
import com.xiaozhao.domain.User;
import com.xiaozhao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义realm
 * 主要实现了登录验证，当前用户的角色，权限验证
 *
 * @author xiaozhao
 * @date 2018/11/7下午2:27
 */
public class ShiroRealm extends AuthorizingRealm {

    /**
     * 一个服务，可以从数据库查询用户信息，包含用户名和密码，查询用户所属的角色，用户所拥有的权限
     */
    @Autowired
    private UserService userService;


    /**
     * 验证当前登录用户的角色信息，权限信息
     * 把当前登录客户的角色信息集合，可操作权限集合从数据库中取出来，
     * 然后保存到SimpleAuthorizationInfo对象中，并返回给Shiro，这样Shiro中就存储了当前用户的角色和权限信息了
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String username = user.getUserName();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        System.out.println("角色校验，获取权限" + username);

        // 获取用户角色集
        List<Role> roleList = userService.findRolesByUsername(username);
        Set<String> roleSet = new HashSet<>(roleList.size());
        for (Role role : roleList) {
            roleSet.add(role.getName());
        }
        info.setRoles(roleSet);

        // 获取用户权限集
        List<Permission> permissionList = userService.findPermsByUsername(username);
        Set<String> permissionSet = new HashSet<>(permissionList.size());
        for (Permission permission : permissionList) {
            permissionSet.add(permission.getName());
        }
        info.setStringPermissions(permissionSet);
        return info;
    }


    /**
     * 登录验证
     * 根据客户端传递的登录信息，然后从数据库中取出对应的用户录，进行比对，看是否匹配
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        /**
         * 从AuthenticationToken中获取到前端传递的用户名和密码字段信息
         */
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.println("认证用户:" + username + "---" + password);

        /**
         * 从数据库中查询对应的用户记录
         */
        User user = this.userService.findByUserName(username);

        /**
         * 依次对没有查询到记录，密码错误，账号锁定等信息进行处理，然后抛出对应的异常
         */
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误");
        }
        if (user.getStatus().equals("0")) {
            throw new LockedAccountException("账号已被锁定，请联系管理员");
        }

        /**
         *
         */
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
