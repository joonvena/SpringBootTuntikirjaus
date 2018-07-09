package fi.academy.Controller;


import fi.academy.model.Hours;
import fi.academy.model.HoursForm;
import fi.academy.model.User;
import fi.academy.repository.HoursRepository;
import fi.academy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HoursRepository hoursRepository;

    @RequestMapping("/home")
    public String index(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("showusers", users);


        List<Hours> hours = hoursRepository.findAll();
        model.addAttribute("showhours", hours);

        return "index";
    }

    @GetMapping("/hours")
    public String addHours(Model model) {
        HoursForm hoursForm = new HoursForm();
        model.addAttribute("hours", hoursForm);
        return "hours";
    }

    @PostMapping("/hours")
    public String saveHours(@ModelAttribute("hours") HoursForm hoursForm) {
        Integer kayttajaid = hoursForm.getKayttajaid();
        Date paivamaara = hoursForm.getPaivamaara();
        Integer minuutit = hoursForm.getMinuutit();
        String tehtavakuvaus = hoursForm.getTehtavakuvaus();
        boolean laskutettava = hoursForm.isLaskutettava();

        hoursRepository.save(new Hours(kayttajaid, laskutettava, minuutit, paivamaara, tehtavakuvaus));

        return "redirect:/home";
    }



    /*@GetMapping(path = "/add")
    public @ResponseBody String addHours(Model model, @RequestParam Integer id, @RequestParam Integer kayttajaid,
                                         @RequestParam boolean laskutettava, @RequestParam Integer minuutit,
                                         @RequestParam Date paivamaara, @RequestParam String tehtavakuvaus) {
        model.addAttribute("newhours", new Hours());
        n.setId(id);
        n.setKayttajaid(kayttajaid);
        n.setLaskutettava(laskutettava);
        n.setMinuutit(minuutit);
        n.setPaivamaara(paivamaara);
        n.setTehtavakuvaus(tehtavakuvaus);

        hoursRepository.save(n);
        return "Hours added";

    }*/

}
