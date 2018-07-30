package kr.co.ldcc.lobdingmachine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
		        .antMatchers("/login").permitAll()
                .antMatchers("/user/**").permitAll()	
		        .antMatchers("/").authenticated()
        		.antMatchers("/main").authenticated()
        		.antMatchers("/manage/user").hasRole("ADMIN")
                .antMatchers("/test/all").permitAll()
                .antMatchers("/test/general").hasRole("GENERAL")
                .antMatchers("/test/admin").hasRole("ADMIN")
                .antMatchers("/**").authenticated();

        http.formLogin()
        		.loginPage("/user/login");
                //.loginProcessingUrl("/login");

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/user/login");

        http.csrf().disable();
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
    	return new BCryptPasswordEncoder();
    }
}
