package ra.demo_login_logout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.demo_login_logout.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class HomeController {
    @RequestMapping(value = {"/","/home"})
    public String home(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }

    @RequestMapping("/login")
    public String login(@Validated @ModelAttribute("user")User user, BindingResult result, @RequestParam(name = "savePass",required = false)String save, Model model, HttpSession session, HttpServletResponse response) throws IOException {
        if(result.hasErrors()){
            model.addAttribute("user",user);
            return "login";
        }else {
            if(!user.getUsername().equals("admin") || !user.getPassword().equals("1234")){
                if(!user.getUsername().equals("admin"))
                    result.addError(new FieldError(user.getUsername(),"username","Username khong dung"));
                if(!user.getPassword().equals("1234"))
                    result.addError(new FieldError(user.getPassword(),"password","Password khong dung"));
                model.addAttribute("user",user);
                return "login";
            }else if (user.getUsername().equals("admin") && user.getPassword().equals("1234")) {
                session.setAttribute("username", user.getUsername());
                session.setMaxInactiveInterval(8 * 60);

                Cookie cUsername, cPassword, cSave;
                if (save != null && save.equals("save")) {
                    cUsername = new Cookie("username", user.getUsername());
                    cPassword = new Cookie("password", user.getPassword());
                    cSave = new Cookie("save", "checked");
                } else {
                    cUsername = new Cookie("username", "");
                    cPassword = new Cookie("password", "");
                    cSave = new Cookie("save", "");
                }
                cUsername.setMaxAge(7 * 24 * 60 * 60);
                cPassword.setMaxAge(7 * 24 * 60 * 60);
                cSave.setMaxAge(7 * 24 * 60 * 60);

                response.addCookie(cUsername);
                response.addCookie(cPassword);
                response.addCookie(cSave);

                return "home";
            } else {
                model.addAttribute("loginErr", "Sai username hoac password");
                return "login";
            }
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
