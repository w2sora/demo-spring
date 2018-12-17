package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * 配置Spring Security
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Autowired
    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
        //         .withUser("weiwei").password(
        //         new BCryptPasswordEncoder().encode("123456")).roles("USER").and()
        //         .withUser("longchan").password(
        //         new BCryptPasswordEncoder().encode("123456")).roles("USER", "ADMIN");

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, true from test where username = ?")
                .authoritiesByUsernameQuery("select username, 'ROLE_USER' from test where username = ?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/mybatis/user/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/mybatis/user").authenticated()
                .anyRequest().permitAll();
        // 自定义登录页
        http.formLogin().loginPage("/login");
        // 启用HTTP Basic认证
        http.httpBasic();
        // 启用RememberMe功能
        http.rememberMe()
                .tokenValiditySeconds(2419200) // token有效时间
                .key("weiwei"); // token的私钥名
    }
}
