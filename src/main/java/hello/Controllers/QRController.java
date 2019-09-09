
package hello.Controllers;

import hello.Forms.CreateClassForm;
import hello.Forms.QRForm;
import hello.Services.QRService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QRController {
    @Autowired
    private QRService qrService;
    
    @PostMapping("/getCode/{id}")
    public String getCode(@ModelAttribute QRForm qrForm, Model model,
            @PathVariable("id") String id) {
        String qrSrc = "";
        
        try {
            qrSrc = qrService.getQRCodeUrl(qrForm.getName(), qrForm.getDescription(),
                    id);
        } catch (IOException ex) {
            Logger.getLogger(QRController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model.addAttribute("codeurl", qrSrc);
        
        return "viewclasses";
    }
    
    @GetMapping("/createcode/{id}")
    public String createCode(@PathVariable("id") String id, Model model) {
       
        model.addAttribute("profid", id);
        model.addAttribute("qrForm", new QRForm());
        
        return "createcode";
    }
    
}
