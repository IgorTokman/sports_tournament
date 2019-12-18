package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "match_id")
    @JsonBackReference
    private Match match;

    @Column(name = "is_dead_heat")
    private boolean isDeadHeat;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team winner;

    @Override
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