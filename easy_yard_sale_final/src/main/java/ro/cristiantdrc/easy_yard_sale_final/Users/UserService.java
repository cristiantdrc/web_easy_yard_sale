package ro.cristiantdrc.easy_yard_sale_final.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ro.cristiantdrc.easy_yard_sale_final.Login.LogInController;
import ro.cristiantdrc.easy_yard_sale_final.Login.LoginService;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginService loginService;

    public String goToPage(@RequestParam("username") String username,
                           @RequestParam("password") String password){
        boolean loginResult = loginService.loginUser(username, password);
        User user = loginService.getByUsername(username);
        if (loginResult && user.getType().equals("Buyer")){
            return "redirect:/shop";
        }
        if (loginResult && user.getType().equals("Seller")){
            return "redirect:/add_item";
        }
        return "redirect:/login_form.html";
    }
}
