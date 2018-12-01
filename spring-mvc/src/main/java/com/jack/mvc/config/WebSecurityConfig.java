package com.jack.mvc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;

/**
 * @author jack
 * 安全配置
 */
@Configuration
//只需继承，无需@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserTokenService userTokenService;
//
//    @Autowired
//    private StringRedisTemplate redisTemplate;

    /**
     * 配置验证管理的Bean 用于开启密码类型的验证，给AuthorizationServerConfigurerAdapter使用
     *
     * @return AuthenticationManager AuthenticationManager
     * @throws Exception Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 配置所有请求都需要安全验证
     * @param http http
     * @throws Exception Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                //开始请求权限配置
                .authorizeRequests()
                //转发全部放通
                .anyRequest().permitAll();
    }

    /**
     * ResourceServerConfigurer
     */
//    @Bean
//    public ResourceServerConfigurer resourceServerConfigurer() {
//        return new ResourceServerConfigurerAdapter() {
//            @Override
//            public void configure(ResourceServerSecurityConfigurer resourceServerSecurityConfigurer) {
//                //配置资源id 不定义没有password grant_type
//                resourceServerSecurityConfigurer.resourceId("blah");
//            }
//        };
//    }


//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();   // 使用 BCrypt 加密
//    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder()); // 设置密码加密方式
//        return authenticationProvider;
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //指定从数据库加载用户信息
//        auth.authenticationProvider(authenticationProvider()).userDetailsService(userDetailsService());
//    }


    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                User user = userTokenService.findByUsername(username);
//                if (null != user) {
//                    Set<Permission> permissionSet = userTokenService.getAuthorities(user.getUserId());
//                    Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
//                    for (Permission permission : permissionSet) {
//                        grantedAuthoritySet.add(new PermissionAuthority(permission.getPermissionId(), user.getUserId(), permission.getRoleId(),
//                                permission.getUrl()));
//                    }
//                    IntegrationAuthentication integrationAuthentication = IntegrationAuthenticationContext.get();
//                    if (integrationAuthentication.getAuthType() != null && StringUtils.isNotBlank(integrationAuthentication.getAuthType())) {
//                        String password = integrationAuthentication.getPassword();
//                        user.setPassword(password);
//                        redisTemplate.delete(username);
//                    }
//
//                    return new org.springframework.security.core.userdetails.User(user.getUsername(),
//                            user.getPassword(), grantedAuthoritySet);
//                } else {
//                    throw new UsernameNotFoundException("用户" + username + "不存在或失效!");
//                }
                return new org.springframework.security.core.userdetails.User("","", new HashSet<>());
            }
        };

    }

}
