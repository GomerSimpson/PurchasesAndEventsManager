package by.simpson.application.web;

import by.simpson.application.entity.Event;
import by.simpson.application.entity.Purchase;
import by.simpson.application.entity.Role;
import by.simpson.application.entity.User;
import by.simpson.application.service.UserService;
import com.google.gson.Gson;
import java.security.Principal;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("redirect:/admin");
        if (Integer.parseInt(request.getParameter("id")) == 1) {
            mav.addObject("error", "Admin can't be deleted!!!");
            return mav;
        }

        userService.deleteUser(Integer.parseInt(request.getParameter("id")));
            mav.addObject("success", "User is deleted!!!");
            return mav;
    }

    @RequestMapping(value = "/deleteEvent", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView deleteEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        userService.deleteEvent(Integer.parseInt(request.getParameter("id")));
        return new ModelAndView("redirect:/user/events");
    }

    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public @ResponseBody
    String getEvents(Principal principal, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer day = Integer.parseInt(request.getParameter("day"));
        Integer month = Integer.parseInt(request.getParameter("month"));
        Integer year = Integer.parseInt(request.getParameter("year"));
        Gson gson = new Gson();

        Date date = new Date(year, month, day);
        //System.out.println(date + " from Controller");
        List<Event> list = userService.getUserEvents(principal.getName(), date);

        for (Event e : list) {
            e.setUser(null);
        }

        //  System.out.println(gson.toJson(list));
        // date.setTime(Date.parse(request.getParameter("day")));
        //   List<Event> list = userService.getUser(id_user).getEvents();
        // JOptionPane.showMessageDialog(null, list);
        return gson.toJson(list);
    }

    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    public @ResponseBody
    String getUserName(Principal principal, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //    System.out.println("getUserInfo from AjaxController.java " + principal.getName());
        return principal.getName();
    }

    @RequestMapping(value = "/setEvent", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView setEvent(Principal principal, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String month[] = {"", "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};
        int counter;

        for (counter = 1; counter < month.length; counter++) {
            if (month[counter].equals(request.getParameter("month"))) {
                break;
            }
        }
        //    System.out.println(Integer.parseInt(request.getParameter("year")) + " from controller");
        Date date = new Date(Integer.parseInt(request.getParameter("year")) - 1900, counter - 1, Integer.parseInt(request.getParameter("day")));
        userService.setEvent(principal.getName(), new Event(request.getParameter("event"), date));
        return new ModelAndView("redirect:/user/events");
    }

    @RequestMapping(value = "/getPurchases", method = RequestMethod.GET)
    public @ResponseBody
    String getPurchases(Principal principal, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer day = Integer.parseInt(request.getParameter("day"));
        Integer month = Integer.parseInt(request.getParameter("month"));
        Integer year = Integer.parseInt(request.getParameter("year"));
        Gson gson = new Gson();

        Date date = new Date(year, month, day);
        //System.out.println(date + " from Controller");
        List<Purchase> list = userService.getUserPurchases(principal.getName(), date);

        for (Purchase p : list) {
            p.setUser(null);
        }

        //  System.out.println(gson.toJson(list));
        // date.setTime(Date.parse(request.getParameter("day")));
        //   List<Event> list = userService.getUser(id_user).getEvents();
        // JOptionPane.showMessageDialog(null, list);
        return gson.toJson(list);
    }

    @RequestMapping(value = "/setPurchase", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView setPurchase(Principal principal, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String month[] = {"", "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};
        int counter;

        for (counter = 1; counter < month.length; counter++) {
            if (month[counter].equals(request.getParameter("month"))) {
                break;
            }
        }
        System.out.println(principal.getName() + " from controller");
        Date date = new Date(Integer.parseInt(request.getParameter("year")) - 1900, counter - 1, Integer.parseInt(request.getParameter("day")));
        userService.setPurchase(principal.getName(), new Purchase(request.getParameter("purchase"), date, Long.parseLong(request.getParameter("price"))));
        return new ModelAndView("redirect:/user/purchases");
    }

    @RequestMapping(value = "/deletePurchase", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView deletePurchase(HttpServletRequest request, HttpServletResponse response) throws Exception {

        userService.deletePurchase(Integer.parseInt(request.getParameter("id")));
        return new ModelAndView("redirect:/user/purchases");
    }


}
