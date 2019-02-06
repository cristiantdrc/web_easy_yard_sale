package ro.cristiantdrc.easy_yard_sale_final.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ro.cristiantdrc.easy_yard_sale_final.Items.ItemRepository;

import javax.jws.WebParam;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @RequestMapping("/adminAllUsersView")
    public ModelAndView showAllUsers (){
        ModelAndView allUsersModelAndView = new ModelAndView("adminAllUsersView");
        allUsersModelAndView.addObject("users", userRepository.findAll());
        return allUsersModelAndView;
    }

    @RequestMapping("/deleteUser")
    //requestparam - valoarea din url a parametrului : i.e: //http:localhost8080/deleteUser?id
    public ModelAndView deleteUser(@RequestParam("id") Integer userId){
        userRepository.deleteById(userId);
        return showAllUsers();
    }

    @RequestMapping(value = "/accountRequest", method = RequestMethod.POST)
    public ModelAndView editUser(User editedUser){
//        TO DO : logica de verificare daca userul deja exista (dupa nume )
            userRepository.save(editedUser);
            return new ModelAndView("redirect:/accountSuccess.html");

//            return new ModelAndView("redirect:/existing_user.html");
    }

    @RequestMapping("/adminUserView")
        public ModelAndView userView (@RequestParam(value = "id",required = false) Integer userId){
            User checkUser;
            if(userId !=null) {
                checkUser = userRepository.findById(userId).get();
            } else {
                checkUser = new User();
            }
            ModelAndView userModelAndView = new ModelAndView("adminUserView");
            userModelAndView.addObject("user", checkUser);
            return userModelAndView;
    }
}
