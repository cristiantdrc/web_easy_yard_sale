package ro.cristiantdrc.easy_yard_sale_final.Items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.cristiantdrc.easy_yard_sale_final.Login.LoggedUser;
import ro.cristiantdrc.easy_yard_sale_final.Users.UserRepository;


@Controller
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private LoggedUser loggedUser;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/wanttobuy")
//    @RequestParam("quantityInStock") Integer quantity
    public ModelAndView selectItem(@RequestParam("itemId") Integer itemId) {
        ModelAndView modelAndView = new ModelAndView("buy_success");
        modelAndView.addObject("itemId", itemId);
        return modelAndView;
    }

    @RequestMapping(value = "/shop")
    public ModelAndView viewAllItems() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items", itemRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/addItemRequest", method = RequestMethod.POST)
    public ModelAndView addedItem (Item addedItem){
        addedItem.setUserId(loggedUser.getUserLoggedId());
        itemRepository.save(addedItem);
        return new ModelAndView("redirect:/shop");
    }
    @RequestMapping("/add_item")
    public ModelAndView addItemView (@RequestParam(value = "itemId",required = false) Integer itemId,
                                     @RequestParam(value = "userId", required = false) Integer userId) {
        Item checkItem;
        if(itemId !=null) {
            checkItem = itemRepository.findById(itemId).get();
        } else {
            checkItem = new Item();
        }
        ModelAndView userModelAndView = new ModelAndView("add_item");
        userModelAndView.addObject("item", checkItem);
        return userModelAndView;
    }
}
