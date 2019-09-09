
package hello.Controllers;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
class HomeController {
    @GetMapping("/")
    String index(Principal principal) {
        return "/home";
    }
}
