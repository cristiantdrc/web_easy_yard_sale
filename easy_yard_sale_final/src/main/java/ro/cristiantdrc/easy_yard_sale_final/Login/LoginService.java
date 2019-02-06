package ro.cristiantdrc.easy_yard_sale_final.Login;

import ro.cristiantdrc.easy_yard_sale_final.Users.User;
import ro.cristiantdrc.easy_yard_sale_final.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoggedUser loggedUser;


    public User getByUsername(String username) {
        return  userRepository.findByUsername(username);
    }

    public boolean loginUser(String username, String password){
        User user = userRepository.findByUsername(username);
        if (user==null){
            return false;
        }
        if (user.getPassword().equals(password)){
            loggedUser.setUserLoggedId(user.getId());
            return true;
        } else {
            return false;
        }
    }

    public boolean isUserLoggedIn() {
        return loggedUser.getUserLoggedId()>0;
    }

}

