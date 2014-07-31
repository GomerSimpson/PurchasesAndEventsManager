package by.simpson.application.web;

import by.simpson.application.service.UserService;
import java.util.Collection;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkNavigation
{

    @Autowired
    private UserService userService;
    /*
     private void init(){
     Role r = new Role("ROLE_ADMIN");
     Role r2 = new Role("ROLE_USER");
     Role r3 = new Role("ROLE_USER");
     Role r4 = new Role("ROLE_USER");
     Purchase p = new Purchase("bred", new Date(17, 3, 1993), 10L);
     Event e = new Event("Event", new Date(17, 3, 1993));
     User u = new User("f_name", "sec_name", "login", "pass", "e");
     u.setRole(r);
     u.setRole(r4);
     u.setEvent(e);
     u.setPurchase(p);

     Purchase p11 = new Purchase("bred", new Date(17, 3, 1993), 10L);
     Purchase p12 = new Purchase("butter", new Date(17, 3, 1994), 1L);
     Event e11 = new Event("Event2", new Date(17, 3, 1993));
     Event e12 = new Event("Event3", new Date(18, 4, 1995));
     User u2 = new User("simpson", "gomer", "vik", "qwert", "bar@qwe.ru");

     u2.setRole(r2);
     u2.setEvent(e11);
     u2.setEvent(e12);
     u2.setPurchase(p11);
     u2.setPurchase(p12);
		
     Purchase p21 = new Purchase("milk", new Date(17, 3, 1993), 10L);
     Purchase p22 = new Purchase("apple", new Date(17, 3, 1994), 1L);
     Purchase p23 = new Purchase("fish", new Date(17, 3, 1994), 1L);
     Event e21 = new Event("Event4", new Date(17, 3, 1993));
     Event e22 = new Event("Event5", new Date(18, 4, 1995));
     Event e23 = new Event("Event6", new Date(18, 4, 1935));
     User u3 = new User("simpson", "gomer", "vik", "qwert", "bar@qwe.ru");
     u3.setRole(r3);
     u3.setEvent(e21);
     u3.setEvent(e22);
     u3.setEvent(e23);
     u3.setPurchase(p21);
     u3.setPurchase(p22);
     u3.setPurchase(p23);
		
     userService.addUser(u);
     userService.addUser(u2);
     userService.addUser(u3);
     }	
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage() {
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView indexPage() {
        if (isAdmin()) {
            return new ModelAndView("redirect:/admin");
        } else if (isUser()) {
            return new ModelAndView("redirect:/user");
        }

        return new ModelAndView("guest");
    }

    @RequestMapping(value = "/user/events", method = RequestMethod.GET)
    public ModelAndView events() {
        if (isAdmin()) {
            return new ModelAndView("redirect:/admin");
        } else if(isGuest()) {
            return new ModelAndView("redirect:/index");
        }
        
       return new ModelAndView("/user/events");
    }

    @RequestMapping(value = "/user/purchases", method = RequestMethod.GET)
    public ModelAndView purchases() {
        if (isAdmin()) {
            return new ModelAndView("redirect:/admin");
        } else if(isGuest()) {
            return new ModelAndView("redirect:/index");
        }
        
       return new ModelAndView("/user/purchases");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        if (isAdmin()) {
            return new ModelAndView("redirect:/admin");
        } else if (isUser()) {
            return new ModelAndView("redirect:/user");
        }
        
        return new ModelAndView("registration");
    }

    private boolean isGuest() {
        return SecurityContextHolder.getContext().getAuthentication().getName().equals("guest");
    }

    private boolean isAdmin() {
        Collection<? extends GrantedAuthority> lol = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        for (GrantedAuthority ga : lol) {
            if (ga.getAuthority().equals("ROLE_ADMIN")) {
                return true;
            }
        }

        return false;
    }

    private boolean isUser() {
        Collection<? extends GrantedAuthority> lol = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        for (GrantedAuthority ga : lol) {
            if (ga.getAuthority().equals("ROLE_USER")) {
                return true;
            }
        }

        return false;
    }

    private String redirect() {
        if (isGuest()) {
            return "redirect:/index";
        } else if (isUser()) {
            return "redirect:/user";
        } else/* if(isAdmin())*/ {
            return "redirect:/admin";
        }
    }
}
