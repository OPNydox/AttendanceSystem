
package hello.Services;

import hello.ServerCommunication.ClassCommunicator;
import hello.Utilities.ClassView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    public void createService (String name, String description) {
        ClassCommunicator.createClass(name, description);
    }
    
    public Set<ClassView> getClasses (){
        JSONArray input = ClassCommunicator.getClasses("e7e30f92-d69b-4952-b45c-a03cd24abeac");
        Set<ClassView> result = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            ClassView currentClass = new ClassView();
            currentClass.setName(input.getJSONObject(i).getString("name"));
            currentClass.setDescription(input.getJSONObject(i).getString("description"));
            currentClass.setId(Integer.toString(input.getJSONObject(i).getInt("id")));
            
            result.add(currentClass);
        }
        
        return result;
    }
}
