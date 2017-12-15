package ma.dph.dsi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import ma.dph.dsi.util.DSIPropertyUtil;


@Controller 
@SpringBootApplication
public class DSIwebApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	static Logger log = Logger.getLogger(DSIwebApplication.class.getName());
	
	
	
	
	@Autowired
	DSIPropertyUtil prop;
	
	//TODO Remove hard codings. 
	//@Value("${dev}")
	//static String devServer;
	static String devServer="146.243.83.117";
	
	
	//@Value("${uat}")
	 //String uatServer;
	static String uatServer="146.243.82.240";
	
	//@Value("${prod}")
	 //String prodServer;
	static String prodServer="146.243.83.125";
	
	static String currentProfile;
	
    public static void main( String[] args ) throws UnknownHostException
    {
        System.out.println( "DSI Web application using Spring!" );
        //setProfileForDsi();
        
        SpringApplication application = new SpringApplication(DSIwebApplication.class);
    	
    	if(currentProfile != null) {
    		log.debug("Setting current profile as  : "+currentProfile);
    		//application.setAdditionalProfiles(currentProfile);
    		application.setAdditionalProfiles(currentProfile);
    	}
    	application.run(args);
    }
    
   /* @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	
    	 String devServer="146.243.83.117";
    	
    	
    	 String uatServer="146.243.82.240";
    	
    	 String prodServer="146.243.83.125";
    	
    	InetAddress ipAddr = null;
    	
    	
    	// Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
          new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext =
          new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(DispatcherConfig.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
          container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        
        
    	
		try {
			ipAddr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String ipAddress = ipAddr.getHostAddress();
    	
        log.debug("Running DSI WEB from : "+ipAddress+"Available environments "+" devServer : "+devServer+" uatServer : " +uatServer+ " prodServer: " + prodServer);
        log.debug("Properties ======> : "+prop);
        if(ipAddress.equals(devServer)) 
        {
        	log.debug("current profile is dev ");
        	currentProfile = "dev";
        }
        else if(ipAddress.equals(uatServer)) 
        {
        	log.debug("current profile is uat ");
        	currentProfile = "uat";
        }
        else if(ipAddress.equals(prodServer)) 
        {
        	log.debug("current profile is prod ");
        	currentProfile = "prod";
        }
        log.debug("Setting profile for web app : "+currentProfile+ "  on the machine "+ipAddress+" Available environments "+" devServer : "+devServer+" uatServer : " +uatServer+ " prodServer: " + prodServer);
        
        if (currentProfile != null)
        	servletContext.setInitParameter("spring.profiles.active", currentProfile);
    }
    */
    
    public static void setProfileForDsi() throws UnknownHostException {
    	
    	InetAddress ipAddr = InetAddress.getLocalHost();
    	String ipAddress = ipAddr.getHostAddress();
    	
        log.debug("setProfileForDsi Running DSI WEB from : "+ipAddress+"Available environments "+" devServer : "+devServer+" uatServer : " +uatServer+ " prodServer: " + prodServer);
        if(ipAddress.equals(devServer)) 
        {
        	log.debug("current profile is dev ");
        	currentProfile = "dev";
        }
        else if(ipAddress.equals(uatServer)) 
        {
        	log.debug("current profile is uat ");
        	currentProfile = "uat";
        }
        else if(ipAddress.equals(prodServer)) 
        {
        	log.debug("current profile is prod ");
        	currentProfile = "prod";
        }
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	
    	
    	InetAddress ipAddr=null;
		try {
			ipAddr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String ipAddress = ipAddr.getHostAddress();
    	
        log.debug("SpringApplicationBuilder Running DSI WEB from -- : "+ipAddress+"Available environments "+" devServer : "+devServer+" uatServer : " +uatServer+ " prodServer: " + prodServer);
     
    	 if(ipAddress.equals(devServer)) 
         {
         	log.debug("current profile is dev ");
         	currentProfile = "dev";
         }
         else if(ipAddress.equals(uatServer)) 
         {
         	log.debug("current profile is uat ");
         	currentProfile = "uat";
         }
         else if(ipAddress.equals(prodServer)) 
         {
         	log.debug("current profile is prod ");
         	currentProfile = "prod";
         }
    	 application.profiles(currentProfile);
        return application.sources(DSIwebApplication.class);
    }
     
    
    @GetMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
    	System.out.println("user ========>" + user.getName());
        return user;
    }
    
    @RequestMapping("/token")
	@ResponseBody
	public Map<String,String> token(HttpSession session) {
		return Collections.singletonMap("token", session.getId());
	}
    
    
    @RequestMapping("/dashboard")
	public String dashboard(Model model){
		//log.debug("Welcome page: Session Id " + httpSession.getId() + " Creation Time: " + httpSession.getCreationTime());
//		httpSession.invalidate();
//		SecurityContextHolder.clearContext();
		return "dashboard";
	}
    
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
		//log.debug("Welcome page: Session Id " + httpSession.getId() + " Creation Time: " + httpSession.getCreationTime());
//		httpSession.invalidate();
//		SecurityContextHolder.clearContext();
		System.out.println("login ==>");

		return "login";
	}
     
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		System.out.println("Access denied==>");
    	model.addAttribute("user", getPrincipal());
		
		return "accessDenied";
	}
    
    //@RequestMapping(value="/logout", method = RequestMethod.GET)
/*    @PostMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("logout ========>" );
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
        	System.out.println("logout ========>"+ auth );

           // new SecurityContextLogoutHandler().logout(request, response, auth);
          //  new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY).logout(request, response, null);
        }
    

        return "redirect:/dsiweb";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }*/
    
    
/*    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }*/
     
 /*   @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DsiwebApplication.class);
    }*/
    
/*    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(App.class); //.bannerMode(null);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);
    }*/
    
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
