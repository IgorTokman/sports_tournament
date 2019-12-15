package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private long id;

    @Column(name = "title")
    private String title;

    // A list of results in which the team was the winner
    @OneToMany(mappedBy = "winner", cascade=CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Result> winners;

    // A list of results in which the team was the loser
    @OneToMany(mappedBy = "defeated", cascade=CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Result> defeateds;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY, mappedBy = "teams")
    private Set<Match> matches;

    public Team(String title) {
        this.title = title;
    }

    public Team() {
    }

    public List<Result> getWinners() {
        return winners;
    }

    public void setWinners(List<Result> winners) {
        this.winners = winners;
    }

    public List<Result> getDefeateds() {
        return defeateds;
    }

    public void setDefeateds(List<Result> defeateds) {
        this.defeateds = defeateds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (id != team.id) return false;
        if (title != null ? !title.equals(team.title) : team.title != null) return false;
        if (winners != null ? !winners.equals(team.winners) : team.winners != null) return false;
        if (defeateds != null ? !defeateds.equals(team.defeateds) : team.defeateds != null) return false;
        return !(matches != null ? !matches.equals(team.matches) : team.matches != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (winners != null ? winners.hashCode() : 0);
        result = 31 * result + (defeateds != null ? defeateds.hashCode() : 0);
        result = 31 * result + (matches != null ? matches.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}