package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "result")
public class Result {

    @Transient
    private static int counter = 1;

    @Id
    private long id = counter++;

    @Field("is_dead_heat")
    private boolean isDeadHeat;

    @DBRef
    private Team winner;

    public String toString() {
        return "Result{" +
                "id=" + id +
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