package es.us.pfc.permuta.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import es.us.pfc.permuta.security.LoginService;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = LoginService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/").permitAll()             
//             .authorizeRequests()
//                .antMatchers("/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
        .and()
        	.formLogin().loginPage("/login")
            .usernameParameter("nombre_usuario").passwordParameter("clave")
        .and()
        	.logout().logoutSuccessUrl("/home")          
            .permitAll();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("usuario").password("usuario").roles("USER");
//    }
}