package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAO;
import web.models.User;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final UserDAO userDAO;

    @Autowired
    public PeopleController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", userDAO.index());
        return "people/index";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPeople(@ModelAttribute("user") User user) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDAO.save(user);
        return "redirect:/people";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userDAO.show(id));
        return "people/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") int id, @ModelAttribute("user") User user) {
        userDAO.update(user.getId(), user);
        return "redirect:/people";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id, @ModelAttribute("user") User user) {
        userDAO.delete(id);
        return "redirect:/people";
    }
}
