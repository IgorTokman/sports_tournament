package ua.edu.sumdu.cs.igortokman.sports_tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Competition;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Round;
import ua.edu.sumdu.cs.igortokman.sports_tournament.service.CompetitionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="api/tournament")
public class TournamentAPIController {

    @Autowired
    CompetitionService competitionService;

    @RequestMapping(value = "/competition", method = RequestMethod.POST)
    public ResponseEntity<Object> addCompetition(@RequestBody Competition competition) {

        List<Round> rounds = competitionService.add(competition);

        return new ResponseEntity<>(rounds, HttpStatus.CREATED);
    }
}