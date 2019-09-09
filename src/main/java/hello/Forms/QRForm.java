
package hello.Forms;

import javax.validation.constraints.NotBlank;

public class QRForm {
       private static final String NOT_BLANK_MESSAGE = "Field can't be blank";

    @NotBlank(message = QRForm.NOT_BLANK_MESSAGE)
    private String name;

    @NotBlank(message = QRForm.NOT_BLANK_MESSAGE)
    private String description;
    
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
