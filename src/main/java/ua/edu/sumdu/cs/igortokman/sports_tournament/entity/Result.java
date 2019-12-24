package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "result")
public class Result {
    @Id
    private long id;

    private Match match;
    private boolean isDeadHeat;
    private Team winner;

    public String toString() {
        return "Result{" +
                "id=" + id +
                ", match=" + match +
                ", isDeadHeat=" + isDeadHeat +
                ", winner=" + winner +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public boolean isDeadHeat() {
        return isDeadHeat;
    }

    public void setIsDeadHeat(boolean isDeadHeat) {
        this.isDeadHeat = isDeadHeat;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}