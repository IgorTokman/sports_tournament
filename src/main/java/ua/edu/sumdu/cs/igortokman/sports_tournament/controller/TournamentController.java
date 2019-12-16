package ua.edu.sumdu.cs.igortokman.sports_tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Competition;
import ua.edu.sumdu.cs.igortokman.sports_tournament.service.CompetitionService;

import java.util.List;

@Controller
public class TournamentController {

    @Autowired
    CompetitionService competitionService;

    @GetMapping("/")
    public String getCompetitions(Model model) {
        model.addAttribute("competition", new Competition());
        return "index";
    }

    @PostMapping("/")
    public String createCompetition(@ModelAttribute Competition competition) {
        return "main";
    }
}