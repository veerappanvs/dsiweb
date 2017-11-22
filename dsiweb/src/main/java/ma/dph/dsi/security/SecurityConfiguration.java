package ma.dph.dsi.security;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import ma.dph.dsi.security.CustomBasicAuthenticationEntryPoint;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	   static Logger log = Logger.getLogger(SecurityConfiguration.class.getName());

	//TODO Check the realm name   
	private static String REALM="DSI";
		
	 @Autowired
	 DataSource dataSource;


	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("bill").password("123456").roles("ADMIN");
		//auth.inMemoryAuthentication().withUser("tom").password("abc123").roles("USER");
		auth.jdbcAuthentication().dataSource(dataSource).
		  usersByUsernameQuery(
				   "select User_Id USERNAME,Token  PASSWORD, 'TRUE' ENABLED  from tbl_users where User_Id=?")
				  .authoritiesByUsernameQuery(
				   "select User_Id USERNAME, User_Role AUTHORITY from tbl_users where User_Id=?");
	}
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	 
/*	    http
	    .httpBasic().and()
	    .authorizeRequests()
	        .antMatchers("/index.html", "/home.html", "/login.html", "/app.html", "/", "/home", "/login", "/Access_Denied").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .formLogin()
            .loginPage("/login");*/
		
		  http.csrf().disable()
          .authorizeRequests()
          .antMatchers("/webjars/**").permitAll()		
          	.antMatchers("/static/**").permitAll()		
      	  	  .antMatchers("/resources/**").permitAll()	
              .anyRequest().authenticated()
              .and()
          .formLogin()
              .loginPage("/login")
              .defaultSuccessUrl("/dashboard")
              .permitAll()
		  .and()
          .logout()                                    
              .permitAll();
	}

/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	  http.csrf().disable()
	  	.authorizeRequests()
	  	//.antMatchers("/inv/**").hasRole("USER")//Value of the role in the db should mentioned as ROLE_USER
	  	//.antMatchers("/inv/**").hasRole("ADMIN")
		//.antMatchers("/dsiweb").permitAll()
	  	.anyRequest().permitAll()
		//.antMatchers("/dsiweb/**").hasRole("ADMIN")
		//.antMatchers("/dsiweb/**").hasRole("USER")
		//.antMatchers("/**").hasRole("ADMIN")
		.and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint()).and().logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());;
		 
		 http
         .httpBasic().and()
         .authorizeRequests()
             .antMatchers("/**").permitAll()
             .anyRequest().authenticated()
             .and()
         .csrf()
             .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	  
	    http.cors().and().authorizeRequests()
        .anyRequest().authenticated();
 	}*/
	
	@Bean
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
		return new CustomBasicAuthenticationEntryPoint();
	}
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
