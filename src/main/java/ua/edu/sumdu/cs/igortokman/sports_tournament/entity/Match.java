package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import javax.persistence.*;

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
}