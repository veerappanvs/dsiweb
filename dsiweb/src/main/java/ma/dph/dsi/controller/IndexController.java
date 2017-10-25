/**
 * 
 */
package ma.dph.dsi.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml.SAMLCredential;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author pmishra
 *
 */
@Controller
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	// @Autowired 
	// private HttpSession httpSession;

/*	@RequestMapping("/samlindex")
	public String samlIndex(Model model) {
		log.debug(" You are in index() page");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String userName = authentication.getName();
		SAMLCredential credential = (SAMLCredential) SecurityContextHolder.getContext().getAuthentication()
				.getCredentials();
		String userName = credential.getNameID().getValue();
		log.debug(" You are in index() page with UserName: " + userName);
		
//		samlUserDetailsServiceImpl.loadUserBySAML(credential);
		model.addAttribute("name", userName);
		model.addAttribute("samlCred",credential);
		model.addAttribute("samlAuth",authentication);
		return "samlindex";
	}
	
	@RequestMapping("/welcome")
	public String welcome(Model model){
		log.debug("Welcome page: Session Id " + httpSession.getId() + " Creation Time: " + httpSession.getCreationTime());
//		httpSession.invalidate();
//		SecurityContextHolder.clearContext();
		return "welcome";
	}*/
// Defaul logout is handled by Spring boot	
/*	@RequestMapping("/logout")
	public String logout(){
		return "login";
	}
	
	*/
	 
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model){
		//log.debug("Welcome page: Session Id " + httpSession.getId() + " Creation Time: " + httpSession.getCreationTime());
//		httpSession.invalidate();
//		SecurityContextHolder.clearContext();
		return "dashboard";
	}
	

}
