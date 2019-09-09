
package hello.Controllers;

import hello.Forms.CreateClassForm;
import hello.Forms.ProfessorForm;
import hello.Services.ProfessorService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorService service;
    
    //@Autowired 
    //private HttpSession httpSession;
    
    @PostMapping("/register")
	public String createProf(@Valid @ModelAttribute ProfessorForm profForm) {
                String accToken;
                accToken = service.registerProfessor(profForm.getName(), 
                        profForm.getPassword());
                //httpSession.setAttribute("token", accToken);
		
		return "redirect:/createclass";
	}
        
    @GetMapping("register")
        String index() {
            return "/register";
        }
}
