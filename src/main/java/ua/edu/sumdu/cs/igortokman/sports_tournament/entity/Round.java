package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

@Document(collection = "round")
public class Round {

    @Transient
    private static int counter = 1;

    @Id
    private long id = counter++;

    @DBRef
    private List<Match> matches = new ArrayList<>();

    @Field("date")
    private Date date;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public boolean addMatch(Match match) {
        return matches.add(match);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Round{" +
                "id=" + id +
                ", matches=" + matches +
                ", date=" + date +
                '}';
    }

    public boolean containsMatch(Match match) {
        for (Match item : matches) {
            if (item.equals(match)) {
                return true;
            }
        }

        return false;
    }
}