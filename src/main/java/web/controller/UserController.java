package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;

@Controller
@RequestMapping("/user")
public class UserController {

    private final web.dao.UserDaoImpl userDaoImpl;

    @Autowired
    public UserController(web.dao.UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("user", userDaoImpl.index());
        return "user/index";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userDaoImpl.show(id));
        return "user/show";
    }

    @GetMapping("/new")
    public String newPeople(@ModelAttribute("user") User user) {
        return "user/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDaoImpl.save(user);
        return "redirect:/user";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userDaoImpl.show(id));
        return "user/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") int id, @ModelAttribute("user") User user) {
        userDaoImpl.update(user.getId(), user);
        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id, @ModelAttribute("user") User user) {
        userDaoImpl.delete(id);
        return "redirect:/user";
    }
}
