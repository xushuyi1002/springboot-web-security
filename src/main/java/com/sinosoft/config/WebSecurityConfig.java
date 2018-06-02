package com.sinosoft.config;

import com.sinosoft.security.CustomUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by xushuyi on 2018/4/3.
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SessionRegistry sessionRegistry;

    /**
     * 配置静态资源不需要经过认证
     *
     * @param web web安全认证
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    /**
     * 1、除了“/”,"/home"(首页),"/login"(登录),"/logout"(注销),之外，其他路径都需要认证
     * 2、指定“/login”该路径为登录页面，当未认证的用户尝试访问任何受保护的资源时，都会跳转到“/login”
     * 3、默认指定“/logout”为注销页面
     * 4、
     *
     * @param http http请求
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
                .and()
                .sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry);
    }

    /**
     * 对用户登录密码的盐加密验证及用户信息验证
     *
     * @param auth 登录用户
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("开始进行登录密码的盐加密验证及用户信息验证...");
        auth.userDetailsService(customUserService()).passwordEncoder(new MyPasswordEncoder());
    }

    /**
     * 将当前用户加入到 验证用户集中
     *
     * @return UserDetialService
     */
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    /**
     * 将用户的session进行注册
     *
     * @return 返回用户注册的session
     */
    @Bean
    public SessionRegistry getSessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }

}
