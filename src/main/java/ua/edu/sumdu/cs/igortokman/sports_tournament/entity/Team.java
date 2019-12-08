package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "winner", cascade=CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Result> winners;

    @OneToMany(mappedBy = "defeated", cascade=CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Result> defeateds;

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
}