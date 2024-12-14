package com.seuprojeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "home"; // Renderiza a página inicial (home.html)
    }

    @PostMapping("/start")
    public String startGame(@RequestParam String nickname, Model model) {
        // Adiciona o nickname ao modelo para ser usado no jogo
        model.addAttribute("nickname", nickname);

        // Redireciona para o controlador do jogo
        return "redirect:/game?nickname=" + nickname;
    }
}
