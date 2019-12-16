package ua.edu.sumdu.cs.igortokman.sports_tournament.entity;

import javax.persistence.*;

@Entity
@Table(name="result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @OneToOne(mappedBy = "result", cascade = CascadeType.ALL)
    private Match match;

    @Column(name = "is_dead_heat")
    private boolean isDeadHeat;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "winner_id", referencedColumnName = "team_id", insertable=false, updatable=false)
    private Team winner;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "defeated_id", referencedColumnName ="team_id", insertable=false, updatable=false)
    private Team defeated;
}