package ua.edu.sumdu.cs.igortokman.sports_tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Competition;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Round;
import ua.edu.sumdu.cs.igortokman.sports_tournament.service.CompetitionService;

import java.util.List;

@Controller
public class TournamentController {

    @Autowired
    CompetitionService competitionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCompetition(Model model) {
        model.addAttribute("competition", new Competition());
        return "index";
    }

    @RequestMapping(value = "/competition", method = RequestMethod.POST)
    public String createCompetition(@ModelAttribute Competition competition) {
        long id = competitionService.add(competition);

        return "redirect:/competition/" + id + "/rounds";
    }

    @RequestMapping(value="/competition/{id}/rounds", method=RequestMethod.GET)
    public String getRoundsByCompetitionId(@PathVariable Long id, Model model) {
        List<Round> rounds = competitionService.get(id);
        model.addAttribute("rounds", rounds);
        return "main";
    }
}