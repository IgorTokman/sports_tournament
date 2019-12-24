package ua.edu.sumdu.cs.igortokman.sports_tournament;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class SportsTournamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsTournamentApplication.class, args);
	}

}
