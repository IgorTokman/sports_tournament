package ua.edu.sumdu.cs.igortokman.sports_tournament.service;

import org.springframework.beans.factory.annotation.Autowired;
import ua.edu.sumdu.cs.igortokman.sports_tournament.dao.CompetitionRepository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Competition;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Match;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Round;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Team;

import java.util.*;

public class CompetitionService {

    private static final Team FAKE_TEAM = new Team("Fake team");
    private static final int MATCHES_PER_TEAM = 2;

    @Autowired
    private CompetitionRepository competitionRepository;

    public List<Round> add(Competition competition) {

        List<Team> teams = new ArrayList<>();
        long numberOfParticipants = competition.getNumberOfParticipants();

        for (long i = 0; i < numberOfParticipants; i++) {
            Team team = new Team();
            team.setTitle("Team #" + (i + 1));
            teams.add(team);
        }

        // The number of players is odd, it is required to add a fake team.
        // For the real opposing team in the match, this will mean a break(rest)
        if (numberOfParticipants % 2 != 0) {
            teams.add(FAKE_TEAM);
        }

        List<Match> matches = new ArrayList<>();
        for (Team team1 : teams) {
            for (Team team2 : teams) {
                if(team1 != team2) {
                    Match match = new Match();
                    match.addTeam(team1);
                    match.addTeam(team2);
                    matches.add(match);
                }
            }
        }

        List<Round> rounds = new ArrayList<>();
        int numberOfRounds = teams.size() * MATCHES_PER_TEAM - 1;
        for (int i = 1; i < numberOfRounds; i++) {
            Round round = new Round();

            Iterator<Match> iterator = matches.iterator();
            while (iterator.hasNext()) {
                if (round.addMatch(iterator.next())) {
                    iterator.remove();
                }
            }

            rounds.add(round);
        }

//        competitionRepository.save(competition);
        return rounds;
    }

    public static void main(String[] args) {
        CompetitionService competitionService = new CompetitionService();
        Competition competition = new Competition();
        competition.setNumberOfParticipants(3);
        competition.setTitle("FIRST COMPETITION");
        List<Round> rounds = competitionService.add(competition);
        System.out.println(rounds);

    }
}