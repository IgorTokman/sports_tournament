package ua.edu.sumdu.cs.igortokman.sports_tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Competition;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Match;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Result;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Round;
import ua.edu.sumdu.cs.igortokman.sports_tournament.service.CompetitionService;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class TournamentController {

    @Autowired
    CompetitionService competitionService;
    private static final String COMPLETED_STATUS = "completed";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCompetition(Model model) {
        model.addAttribute("competition", new Competition());

        return "index";
    }

    @RequestMapping(value = "/competition", method = RequestMethod.POST)
    public String createCompetition(@ModelAttribute Competition competition) {
        long id = competitionService.add(competition);

        return "redirect:/competition/" + id + "/rounds.html";
    }

    @RequestMapping(value = "/competition/{id}/rounds.html", method = RequestMethod.GET)
    public String getScheduleByCompetitionId(@PathVariable Long id, Model model) {
        List<Round> rounds = competitionService.getRoundsByCompetitionId(id);
        model.addAttribute("rounds", rounds);

        return "main";
    }
}

