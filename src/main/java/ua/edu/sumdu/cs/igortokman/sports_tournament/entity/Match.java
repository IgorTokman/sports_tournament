package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "match")
public class Match {

    @Id
    private long id;

    private Result result;
    private boolean isCompleted;

    // TODO: review the need to use match/result relationships/entities
    private List<Team> teams = new ArrayList<>();

    private Round round;

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        return !(teams != null ? Collections.disjoint(teams, match.getTeams()) : match.teams != null);

    }

    @Override
    public int hashCode() {
        return teams != null ? teams.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", isCompleted=" + isCompleted +
                ", teams=" + teams +
                '}';
    }
}