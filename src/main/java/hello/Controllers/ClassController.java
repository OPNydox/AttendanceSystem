
package hello.Controllers;

import hello.Forms.CreateClassForm;
import hello.Services.ClassService;
import hello.Utilities.ClassView;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
class ClassController {
    @Autowired
    private ClassService service;
    

    @GetMapping("/createclass")
    String createClass(Model model) {
        model.addAttribute("classForm", new CreateClassForm());
        return "class_create";
    }
    
    @GetMapping("/viewclasses")
    String getAllClasses(Model model) {
        Set<ClassView> input = service.getClasses();
        
        model.addAttribute("classes", input);
        return "viewClasses";
    }
    
    @PostMapping("/createclass")
	public String createClassPost(@Valid @ModelAttribute CreateClassForm classForm) {
                service.createService(classForm.getName(), classForm.getDescription());
		
		return "redirect:/signin";
	}
        
        @PostMapping("/getclass")
	public String getClasses() {
                
		
		return "redirect:/signin";
	}
}
