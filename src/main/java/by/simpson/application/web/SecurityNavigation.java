package by.simpson.application.web;

import java.util.Collection;
import javax.swing.JOptionPane;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityNavigation
{

    @RequestMapping(value = "/error-login", method = RequestMethod.GET)
    public ModelAndView invalidLogin() {
        ModelAndView modelAndView = new ModelAndView("guest");
        modelAndView.addObject("error", true);
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView successLogin() {
        if (isGuest()) {
            return new ModelAndView("redirect:/index");
        } else if (isUser()) {
            return new ModelAndView("/user/events");
        } else/* if(isAdmin())*/ {
            return new ModelAndView("redirect:/admin");
        }
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminLogin() {
        if (isGuest()) {
            return new ModelAndView("redirect:/index");
        } else if (isUser()) {
            return new ModelAndView("redirect:/user/events");
        } else/* if(isAdmin())*/ {
            return new ModelAndView("admin");
        }

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
}
