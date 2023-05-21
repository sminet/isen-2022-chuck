package fr.yncrea.cin3.chuck.controller;

import fr.yncrea.cin3.chuck.model.dto.ChuckFactsResponse;
import fr.yncrea.cin3.chuck.service.ChuckFactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
    @Autowired
    private ChuckFactsService service;

    @GetMapping({"", "/", "/{id}"})
    public String index(@PathVariable(required = false) String id, Model model) {
        ChuckFactsResponse joke = null;
        if (id == null) {
            joke = service.getRandomJoke();
        } else {
            joke = service.getJokeById(id);
        }

        model.addAttribute("joke", joke);

        return "index";
    }
}
