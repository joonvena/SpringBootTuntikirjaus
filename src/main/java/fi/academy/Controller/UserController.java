package fi.academy.Controller;


import fi.academy.model.Hours;
import fi.academy.model.HoursForm;
import fi.academy.model.User;
import fi.academy.repository.HoursRepository;
import fi.academy.repository.UserRepository;
import fi.academy.service.HoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.security.Principal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userRepository")
    UserRepository userRepository;

    @Autowired
    HoursRepository hoursRepository;

    @Autowired
    HoursService hoursService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String index(Model model) {
        List<Hours> hours = hoursRepository.findAll();
        model.addAttribute("showhours", hours);
        return "index";

    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


    @GetMapping(value = "/edit/{id}")
    public String editHours(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("hours", hoursRepository.findById(id));
        return "hours";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteHours(@PathVariable("id") Integer id) {
        ModelAndView mw = new ModelAndView("redirect:/home");
        hoursRepository.deleteById(id);
        return mw;
    }


    @GetMapping("/hours")
    public String addHours(Model model) {
        HoursForm hoursForm = new HoursForm();
        model.addAttribute("hours", hoursForm);
        return "hours";
    }


    @GetMapping("/registration")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        String name = user.getName();
        String lastname = user.getLastName();
        String email = user.getEmail();
        String password = user.getPassword();
        String encodePassword = passwordEncoder.encode(user.getPassword());
        userRepository.save(new User(email, lastname, name, encodePassword));
        return "redirect:/home";
    }


    @PostMapping("/hours")
    public String saveHours(@ModelAttribute("hours") HoursForm hoursForm, User user) {

        Integer id = hoursForm.getId();
        String kayttajaid = hoursForm.getKayttajaid();
        Date paivamaara = hoursForm.getPaivamaara();
        Integer minuutit = hoursForm.getMinuutit();
        String tehtavakuvaus = hoursForm.getTehtavakuvaus();
        boolean laskutettava = hoursForm.isLaskutettava();

        hoursRepository.save(new Hours(id, kayttajaid, laskutettava, minuutit, paivamaara, tehtavakuvaus));

        return "redirect:/home";
    }
}


