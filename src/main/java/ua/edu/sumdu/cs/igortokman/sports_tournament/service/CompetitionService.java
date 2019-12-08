package ua.edu.sumdu.cs.igortokman.sports_tournament.service;

import org.springframework.beans.factory.annotation.Autowired;
import ua.edu.sumdu.cs.igortokman.sports_tournament.dao.CompetitionRepository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Competition;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Round;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    public List<Round> add(Competition competition) {

        for (long i = 0; i < competition.getNumberOfParticipants(); i++) {
            Team team = new Team();
            team.setTitle("Team " + i + 1);
        }
        competitionRepository.save(competition);
        return new ArrayList<>();
    }
}