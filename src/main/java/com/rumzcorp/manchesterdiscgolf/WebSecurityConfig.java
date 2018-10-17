package com.rumzcorp.manchesterdiscgolf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by richard.rumsey on 15/02/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	
	private static String REALM="MDG_REALM";
	
    @Override
    protected void configure(HttpSecurity http)
            throws Exception
    {
        http.authorizeRequests()
				.antMatchers("/hello").permitAll()
				.antMatchers("/meetup").permitAll()
				.antMatchers("/news/get").permitAll()
                .and()
                .httpBasic().realmName(REALM);
		http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("mdg").password("ManchesterD1scG0lf").roles("USER", "ADMIN");
    }
}
