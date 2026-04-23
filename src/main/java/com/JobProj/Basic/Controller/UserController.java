package com.JobProj.Basic.Controller;


import com.JobProj.Basic.Service.UserService;
import com.JobProj.Basic.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    // 📝 REGISTER PAGE
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // 💾 SAVE USER
    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        service.registerUser(user);
        return "redirect:/login";
    }

    // 🔐 LOGIN PAGE
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // ✅ LOGIN LOGIC (using service)
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        // 🔍 call service
        User user = service.validateUser(username, password);

        if (user != null) {

            // ✅ store session
            session.setAttribute("loggedUser", user);
            session.setAttribute("role", user.getRole());

            // 🔀 redirect based on role
//            if ("ADMIN".equals(user.getRole())) {
//                return "redirect:/";
//            } else {
//                return "redirect:/viewJobs";
//            }
            return "home";
        }

        // ❌ login failed
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    // 🚪 LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
