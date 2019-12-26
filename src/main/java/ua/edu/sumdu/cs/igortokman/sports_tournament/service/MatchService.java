package ua.edu.sumdu.cs.igortokman.sports_tournament.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.cs.igortokman.sports_tournament.dao.CompetitionRepository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.dao.MatchRepository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.dao.ResultRepository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.dao.TeamRepository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.*;

import java.util.*;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Match updateMatchResult(Long matchId, Long winnerId, Boolean isDeadHeat) {
        Match match = matchRepository.findOne(matchId);

        Result result = new Result();
        result.setWinner(teamRepository.findOne(winnerId));
        result.setIsDeadHeat(isDeadHeat);
        resultRepository.save(result);

        match.setIsCompleted(true);
        match.setResult(result);
        matchRepository.save(match);

        return match;
    }
}