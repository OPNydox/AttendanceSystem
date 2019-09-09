
package hello.Forms;

import javax.validation.constraints.NotBlank;

public class ProfessorForm {
    private static final String NOT_BLANK_MESSAGE = "Field can't be blank";
    
    @NotBlank(message = ProfessorForm.NOT_BLANK_MESSAGE)
    private String name;

    @NotBlank(message = ProfessorForm.NOT_BLANK_MESSAGE)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
