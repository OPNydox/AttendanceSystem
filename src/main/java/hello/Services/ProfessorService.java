
package hello.Services;

import hello.ServerCommunication.ProfessorCommunicator;
import hello.Utilities.LocalRepo;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    
    public String registerProfessor(String username, String password) {
        String accToken = ProfessorCommunicator.registerProfessor(username, password);
        return accToken;
    }
}
