package ro.cristiantdrc.easy_yard_sale_final.Login;

import ro.cristiantdrc.easy_yard_sale_final.Users.User;
import ro.cristiantdrc.easy_yard_sale_final.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login_form")
public class LogInController {

    @Autowired
    private LoginService loginService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/login")
    public String loginControll(@RequestParam("username") String username,
                                @RequestParam("password") String password){
        boolean loginResult = loginService.loginUser(username, password);
        User user = loginService.getByUsername(username);
        if (loginResult && user.getType().equals("Buyer")){
            // controller ce afiseaza produsele din baza
            return "redirect:/shop";
        }
        if (loginResult && user.getType().equals("Seller")){
            //html cu formular de introducere produs nou
            return "redirect:/add_item";
        }
        if (loginResult && user.getType().equals("Admin")){
            return "redirect:/adminAllUsersView";
        }
        return "redirect:/login_form.html";
    }
}
