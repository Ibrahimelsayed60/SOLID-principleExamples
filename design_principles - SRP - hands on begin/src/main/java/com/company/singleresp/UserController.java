package main.java.com.company.singleresp;

import java.io.IOException;
//import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.*;
//import User; 
//Handles incoming JSON requests that work on User resource/entity
public class UserController {
	//Store used by controller
    private main.java.com.company.singleresp.Store store = new main.java.com.company.singleresp.Store();
    
    private UserPersistenceService service = new UserPersistenceService();
    
    //Create a new user
    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        User user = mapper.readValue(userJson, User.class);

        UserValidator validator = new UserValidator();
        boolean valid = validator.validateUser(user);
        
        if(!valid) {
            return "ERROR";
        }

//        store.store(user);
        service.saveUser(user);
        
        return "SUCCESS";
    } 

    

}