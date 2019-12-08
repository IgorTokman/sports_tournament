package ua.edu.sumdu.cs.igortokman.sports_tournament.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
}
