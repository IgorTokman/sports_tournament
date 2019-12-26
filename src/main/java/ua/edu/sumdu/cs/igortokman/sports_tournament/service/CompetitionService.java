package ua.edu.sumdu.cs.igortokman.sports_tournament.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.cs.igortokman.sports_tournament.dao.CompetitionRepository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.dao.MatchRepository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.dao.RoundRepository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.dao.TeamRepository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.*;

import java.util.*;

@Service
public class CompetitionService {

    private static final Team FAKE_TEAM = new Team("FAKE TEAM");
    private static final int MATCHES_PER_TEAM = 2;

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private RoundRepository roundRepository;

    public List<Competition> getCompetitionsByCompetitionTitle(String title) {

        return competitionRepository.findByTitle(title);
    }

    public List<Competition> getAllCompetitions() {

        return competitionRepository.findAll();
    }

    public Competition getCompetitionById(Long id) {

        return competitionRepository.findOne(id);
    }

    public List<Match> getMatchesByCompetitionId(Long id, boolean isCompleted) {

        Competition competition = competitionRepository.findOne(id);

        if (competition == null) {
            return new ArrayList<>();
        }

        List<Match> result = new ArrayList<>();
        for (Round round : competition.getRounds()) {
            for (Match match : round.getMatches()) {
                if (match.isCompleted() == isCompleted) {
                    result.add(match);
                }
            }
        }

        return result;
    }

    public List<Round> getRoundsByCompetitionId(long id) {
        Competition competition = competitionRepository.findOne(id);
        if (competition == null) {
            return new ArrayList<>();
        }

        return competition.getRounds();
    }

    public long add(Competition competition) {
//        // TODO: break the process of creating a schedule into relevant stages
        List<Team> teams = new ArrayList<>();
        long numberOfParticipants = competition.getNumberOfParticipants();

        for (long i = 0; i < numberOfParticipants; i++) {
            Team team = new Team();
            team.setTitle("Team #" + (i + 1));
            teams.add(team);
            teamRepository.save(team);
        }

        // The number of players is odd, it is required to add a fake team.
        // For the real opposing team in the match, this will mean a break(rest)
        if (numberOfParticipants % 2 != 0) {
            teams.add(FAKE_TEAM);
            teamRepository.save(FAKE_TEAM);
        }

        List<Match> matches = new ArrayList<>();
        for (Team team1 : teams) {
            for (Team team2 : teams) {
                if(team1 != team2) {
                    Match match = new Match();
                    match.addTeam(team1);
                    match.addTeam(team2);
                    matchRepository.save(match);
                    matches.add(match);
                }
            }
        }

        List<Round> rounds = new ArrayList<>();
        int numberOfRounds = teams.size() * MATCHES_PER_TEAM - 1;

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        for (int i = 1; i < numberOfRounds; i++) {
            Round round = new Round();
            c.add(Calendar.DATE, 1);
            round.setDate(c.getTime());

            Iterator<Match> iterator = matches.iterator();
            while (iterator.hasNext()) {
                Match next = iterator.next();
                if (!round.containsMatch(next)) {
                    round.addMatch(next);
                    iterator.remove();
                }
            }

            roundRepository.save(round);
            rounds.add(round);
        }
        competition.setRounds(rounds);
        competitionRepository.save(competition);

        return competition.getId();
    }
}