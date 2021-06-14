//package com.plat.security;
//
//import com.plat.utils.MD5Util;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.security.Permission;
//import java.util.List;
//
///**
// * 权限配置类
// * Created by heyugang on 2021/3/11.
// */
//@Component
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private MyAuthenticationSuccessHandler successHandler;
//
//    @Autowired
//    private MyAuthenticationFailureHandler failureHandler;
//
////    @Autowired
////    private MyUserDetailService myUserDetailService;
////
////    @Autowired
////    private PermissionMapper permissionMapper;
//
//    //用户认证信息
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        //设置用户账号信息和权限
////        auth.inMemoryAuthentication().withUser("admin").password("123456").authorities("addOrder","showOrder","updateOrder","deleteOrder");
////        //添加userAdd账号
////        auth.inMemoryAuthentication().withUser("userAdd").password("123456").authorities("showOrder","addOrder");
//        auth.userDetailsService(myUserDetailService).passwordEncoder(new PasswordEncoder() {
//            //对表单密码进行加密
//            @Override
//            public String encode(CharSequence rawPassword) {
////                System.err.println("form ..."+rawPassword);
//                return MD5Util.encode((String)rawPassword);
//            }
//
//            //加密的密码与数据库密码进行比对
//            //rawPassword 表单密码     encodedPassword数据库密码
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                System.out.println("rawPassword:"+rawPassword+",encodedPassword:"+encodedPassword);
//                //返回true代表认证成功，false失败
//                return MD5Util.encode((String)rawPassword).equals(encodedPassword);
//            }
//        });
//    }
//
//    //配置httpSecurity拦截资源
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().formLogin();
////        如何进行权限控制 给每一个请求路径分配一个权限名称，然后账号只要关联该名称，就可以有访问权限
//        http.authorizeRequests()
//                //配置相关权限
//                .antMatchers("/showOrder").hasAnyAuthority("showOrder")
//                .antMatchers("/addOrder").hasAnyAuthority("addOrder")
//                .antMatchers("/updateOrder").hasAnyAuthority("updateOrder")
//                .antMatchers("/deleteOrder").hasAnyAuthority("deleteOrder")
//                //自定义登录界面，不拦截登录请求
//                .antMatchers("/login").permitAll()
//                .antMatchers("/**").fullyAuthenticated().and().formLogin().loginPage("/login")
//                .successHandler(successHandler)
//                .failureHandler(failureHandler)
//                .and().csrf().disable();
//    }
//
////    @Bean
////    public static NoOpPasswordEncoder passwordEncoder() {
////        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
////    }
//}
