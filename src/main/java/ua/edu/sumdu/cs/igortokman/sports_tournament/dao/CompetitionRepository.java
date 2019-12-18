package ua.edu.sumdu.cs.igortokman.sports_tournament.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Competition;

import java.util.List;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Long> {
    List<Competition> findByTitle(String title);
}
