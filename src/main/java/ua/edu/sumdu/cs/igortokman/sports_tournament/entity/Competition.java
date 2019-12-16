package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="competition")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_id")
    private long id;

    @Column(name = "number_of_participants")
    private long numberOfParticipants = 1;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "competition", cascade=CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Round> schedule;

    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Round> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Round> schedule) {
        this.schedule = schedule;
    }
}