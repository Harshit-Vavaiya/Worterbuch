package com.deutsche.Worterbuch.controller;

import com.deutsche.Worterbuch.model.Wort;
import com.deutsche.Worterbuch.service.WortService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WortController {
    private WortService wortService;

    public WortController(WortService wortService) {
        this.wortService = wortService;
    }

    @GetMapping("/")
    public String getRoot(Model model){
        Wort[] worts = wortService.getWorts();
        model.addAttribute("worts",worts);
        return "root";
    }

    @PostMapping("/add")
    public String addWord(Model model,Wort word){
        if(wortService.addFood(word) < 1){
            model.addAttribute("errorMessage",String.format("Could not add %s",word.getWord()));
        }

        model.addAttribute("successMessage",String.format("%s Added",word.getWord()));

        model.addAttribute("word",word);

        return "add";
    }

    @GetMapping("/add")
    public String getAdd(Model model, Wort word){
        model.addAttribute("word",word);
        return "add";
    }
}
