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
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Round;
import ua.edu.sumdu.cs.igortokman.sports_tournament.service.CompetitionService;
import ua.edu.sumdu.cs.igortokman.sports_tournament.service.MatchService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class TournamentRestController {

    @Autowired
    CompetitionService competitionService;

    @Autowired
    MatchService matchService;

    private static final String COMPLETED_STATUS = "completed";

    @GetMapping(path = "/competition/{id}", produces = "application/json")
    @ResponseBody
    public Competition getCompetitionByCompetitionId(@PathVariable Long id) {

        return competitionService.getCompetitionById(id);
    }

    @GetMapping(path = "/competitions", produces = "application/json")
    @ResponseBody
    public List<Competition> getCompetitions() {

        return competitionService.getAllCompetitions();
    }

    @GetMapping(path = "/competition/{id}/rounds.json", produces = "application/json")
    @ResponseBody
    public List<Round> getScheduleByCompetitionId(@PathVariable Long id) {

        return competitionService.getRoundsByCompetitionId(id);
    }

    @GetMapping(path = "/competition/{title}/rounds", produces = "application/json")
    @ResponseBody
    public List<Competition> getScheduleByCompetitionTitle(@PathVariable String title) {

        return competitionService.getCompetitionsByCompetitionTitle(title);
    }

    @GetMapping(path = "/competition/{id}/matches/{status}", produces = "application/json")
    @ResponseBody
    public List<Match> getMatchesByStatus(@PathVariable Long id, @PathVariable(required = false) String status) {

        return competitionService.getMatchesByCompetitionId(id,
                ((null != status) && status.equalsIgnoreCase(COMPLETED_STATUS)));
    }

    @PostMapping("/match")
    public Match updateMatch(@RequestBody String result) {

        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map<String, Object> data = springParser.parseMap(result);

        return matchService.updateMatchResult(((Integer) data.get("match")).longValue(),
                ((Integer) data.get("winner")).longValue(), (Boolean) data.get("is_dead_heat"));
    }
}

