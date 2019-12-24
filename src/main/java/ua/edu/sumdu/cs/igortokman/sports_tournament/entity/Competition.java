package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "competition")
public class Competition {
    @Id
    private long id;

    @Field("number_of_participants")
    private long numberOfParticipants = 1;

    @Field("title")
    private String title;

    @DBRef
    private List<Round> rounds;

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

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", numberOfParticipants=" + numberOfParticipants +
                ", title='" + title + '\'' +
                ", rounds=" + rounds +
                '}';
    }
}