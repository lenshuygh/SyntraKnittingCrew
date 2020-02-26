package be.lens.syntra.spring.knittingcrewhomepage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /*.antMatchers("/knittingcrew").hasRole("ADMIN")*/
                .antMatchers("/knittingcrew/editMember/**").hasRole("ADMIN")
                .antMatchers("/knittingcrew/addMember").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/knittingcrew/login")
                .permitAll()
                .and()
                .logout()
                .and()
                .csrf().disable();

        http.formLogin().defaultSuccessUrl("/knittingcrew/overview", true);
        http.logout().logoutSuccessUrl("/knittingcrew/");
    }
}
