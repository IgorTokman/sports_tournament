package ua.edu.sumdu.cs.igortokman.sports_tournament.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.edu.sumdu.cs.igortokman.sports_tournament.entity.Match;

@Repository
public interface MatchRepository extends MongoRepository<Match, Long> {
}
