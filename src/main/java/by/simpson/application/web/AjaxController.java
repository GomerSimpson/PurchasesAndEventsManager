package by.simpson.application.web;

import by.simpson.application.entity.Event;
import by.simpson.application.entity.Role;
import by.simpson.application.entity.User;
import by.simpson.application.service.UserService;
import com.google.gson.Gson;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AjaxController
{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/new_user", method = RequestMethod.POST)
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setRole(new Role("ROLE_USER"));
        System.out.println(request.getParameter("email"));
        if (userService.getUser(request.getParameter("login")) == null) {
            userService.addUser(user);

            return new ModelAndView("redirect:/index");
        }

        ModelAndView model = new ModelAndView("guest");
        model.addObject("wrongLogin", true);

        return model;
    }

    @RequestMapping(value = "/getListUsers", method = RequestMethod.GET)
    public @ResponseBody
    String getListUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> list = userService.getListUsers();

        for (User u : list) {
            u.setEvents(null);
            u.setPurchases(null);
            u.setRoles(null);
        }

        //JOptionPane.showMessageDialog(null, list.toString());
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
    
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public @ResponseBody
    String deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        

        JOptionPane.showMessageDialog(null, request.getParameter("id") + "deleteUser");

        return "{}";
    }
    
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public @ResponseBody
    String getEvents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id_user = Integer.parseUnsignedInt(request.getParameter("id"));
        Integer day = Integer.parseInt(request.getParameter("day"));
        Integer month = Integer.parseInt(request.getParameter("month"));
        Integer year = Integer.parseInt(request.getParameter(null));
        Gson gson = new Gson();
        System.out.println(request.getParameter("day"));
        Date date = new Date(10, 10, 10);
        date.setTime(Date.parse(request.getParameter("day")));
     //   List<Event> list = userService.getUser(id_user).getEvents();
       // JOptionPane.showMessageDialog(null, list);

        return "{}";
    }  
    
}
