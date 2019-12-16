package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_id")
    private long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Result result;

    @Column(name = "is_completed")
    private boolean isCompleted;

    // TODO: review the need to use match/result relationships/entities.
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "match_team",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<Team> teams = new LinkedHashSet<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "round_id")
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

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
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