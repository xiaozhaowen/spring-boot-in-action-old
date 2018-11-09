package com.xiaozhao.config;

import com.xiaozhao.shiro.ShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;

/**
 * Shiro的配置类，在SSM组合下，需要配置在spring.xml文件中，但是在SpringBoot下使用代码来进行配置
 * 主要配置如下内容：
 * 1）ShiroFilterFactoryBean：过滤器链
 * 2）SecurityManager：Shiro的核心
 * 3）ShiroRealm：自定义realm
 * 4）SessionManager：Session管理
 * 5）RedisCacheManager：用户角色，权限的缓存管理
 *
 * @author xiaozhao
 * @date 2018/11/7下午2:41
 */
@Configuration
public class ShiroConfig {

    /**
     * 配置过滤器链，过滤器配置要求是有顺序的，并且是短路优先原则，即前面的匹配到之后，就不再执行后面的过滤器了
     * 1）注入SecurityManager
     * 2）配置过滤器规则
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        LinkedHashMap<String, String> filterChainMap = new LinkedHashMap<>(12);
        // 静态资源不予拦截
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/js/**", "anon");
        filterChainMap.put("/fonts/**", "anon");
        filterChainMap.put("/img/**", "anon");
        // 退出
        filterChainMap.put("/logout", "anon");
        // 退出
        filterChainMap.put("/", "anon");
        // 除了以上url外，其他的都需要认证通过才可以访问，否则转向login
        filterChainMap.put("/**", "authc");

        // TODO 未能拦截到403
//        filterChainMap.put("/user/delete", "perms[user:delete]");

        // 设置登录url
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置未授权url
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        // 登录成功后的跳转
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 设置拦截规则
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }


    // ----------------------------------------开启注解 BEGIN--------------------------------------------


    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 启用角色，权限注解，例如：@RequiresPermissions，@RequiresRoles
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
    //----------------------------------------开启注解 END--------------------------------------------

    /**
     * 配置SecurityManager，核心
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    /**
     * 自定义Realm，获取用户的安全数据。机制就是把前端传递的用户名和密码和数据库中的信息比对，验证登录是否合法，并且得到登录用户的角色信息，权限信息
     * 1）登录验证
     * 2）角色，权限校验
     *
     * @return
     */
    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    /**
     * Shiro生命周期处理器
     *
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


}
