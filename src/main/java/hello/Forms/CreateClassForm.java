
package hello.Forms;

import javax.validation.constraints.NotBlank;

public class CreateClassForm {
   private static final String NOT_BLANK_MESSAGE = "Field can't be blank";

    @NotBlank(message = CreateClassForm.NOT_BLANK_MESSAGE)
    private String name;

    @NotBlank(message = CreateClassForm.NOT_BLANK_MESSAGE)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
