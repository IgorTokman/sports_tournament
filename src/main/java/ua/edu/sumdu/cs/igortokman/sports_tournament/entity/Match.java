package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

@Document(collection = "match")
public class Match {

    @Transient
    private static int counter = 1;

    @Id
    private long id = counter++;

    @Field("is_completed")
    private boolean isCompleted;

    // TODO: review the need to use match/result relationships/entities
    @DBRef
    private List<Team> teams = new ArrayList<>();

    @DBRef
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
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