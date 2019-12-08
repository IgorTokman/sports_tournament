package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="competition")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "competition_id")
    private long id;

    @Column(name = "number_of_participants")
    private long numberOfParticipants;

    @OneToMany(mappedBy = "competition", cascade=CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval=true)
    private Set<Round> schedule;

    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Round> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Round> schedule) {
        this.schedule = schedule;
    }
}