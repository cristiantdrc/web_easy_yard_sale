package ro.cristiantdrc.easy_yard_sale_final.ShoppingChart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.cristiantdrc.easy_yard_sale_final.Items.Item;
import ro.cristiantdrc.easy_yard_sale_final.Items.ItemRepository;
import ro.cristiantdrc.easy_yard_sale_final.Login.LoggedUser;
import ro.cristiantdrc.easy_yard_sale_final.Users.UserRepository;

@Controller
public class BoughtController {
    @Autowired
    private BoughtRepository boughtRepository;
    @Autowired
    private LoggedUser loggedUser;

    @RequestMapping (value = "/buy")
    public ModelAndView buyItem (BoughtItem boughtItem){
        boughtItem.setUserId(loggedUser.getUserLoggedId());
        boughtRepository.save(boughtItem);
        ModelAndView modelAndView = new ModelAndView("redirect:/shoppingCart.html");
        return modelAndView;
    }




}
