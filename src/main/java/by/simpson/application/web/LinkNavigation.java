package by.simpson.application.web;

import by.simpson.application.entity.Role;
import by.simpson.application.service.UserService;
import com.google.gson.Gson;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkNavigation
{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage() {
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView indexPage() {
        if (isAdmin()) {
            return new ModelAndView("redirect:/admin");
        } else if (isUser()) {
            return new ModelAndView("redirect:/user/events");
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
/*
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        if (isAdmin()) {
            return new ModelAndView("redirect:/admin");
        } else if (isUser()) {
            return new ModelAndView("redirect:/user");
        }
        
        return new ModelAndView("registration");
    }
    */
	@RequestMapping(value = "/ajax",method = RequestMethod.GET)
	public @ResponseBody
	String add(HttpServletRequest request, HttpServletResponse response)	throws Exception {
        JOptionPane.showMessageDialog(null, "\nfrom controller\n");
            String base = request.getParameter("base");
            Role role = new Role(base);
            role.setId(99);
            role.setUser(null);
		Gson gson = new Gson();
		String json = gson.toJson(role);
		
		return json;
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
