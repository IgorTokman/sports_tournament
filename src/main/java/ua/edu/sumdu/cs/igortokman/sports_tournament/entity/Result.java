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

    @OneToOne(mappedBy = "result", cascade = CascadeType.ALL)
    @JsonBackReference
    private Match match;

    @Column(name = "is_dead_heat")
    private boolean isDeadHeat;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "winner_id", referencedColumnName = "team_id", insertable=false, updatable=false)
    @JsonBackReference
    private Team winner;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "defeated_id", referencedColumnName ="team_id", insertable=false, updatable=false)
    @JsonBackReference
    private Team defeated;

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", match=" + match +
                ", isDeadHeat=" + isDeadHeat +
                ", winner=" + winner +
                ", defeated=" + defeated +
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

    public Team getDefeated() {
        return defeated;
    }

    public void setDefeated(Team defeated) {
        this.defeated = defeated;
    }
}