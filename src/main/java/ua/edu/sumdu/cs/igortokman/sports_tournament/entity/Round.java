package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "round")
public class Round {
    @Id
    private long id;

    private List<Match> matches = new ArrayList<>();
    private Date date;
    private Competition competition;

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

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