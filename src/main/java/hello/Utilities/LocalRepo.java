
package hello.Utilities;

public class LocalRepo {

    private String accToken;
    
    private static LocalRepo repository;
    
    private LocalRepo() {
    }

    public String getAccToken() {
        return accToken;
    }

    public void setAccToken(String accToken) {
        this.accToken = accToken;
    }
    
    public static LocalRepo getInstance() {
        if (repository == null) {
            return new LocalRepo();
        }
        
        return repository;
    }
    
}
