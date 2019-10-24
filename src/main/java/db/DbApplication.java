package db;

import db.entity.Command;
import db.entity.Type;
import db.service.CommandService;
import db.service.TypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbApplication implements CommandLineRunner {

	private CommandService commandService;
	private TypeService typeService;

	public DbApplication(CommandService commandService, TypeService typeService) {
		this.commandService = commandService;
		this.typeService = typeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}

	@Override
	public void run(String... args) {

		typeService.save(new Type("SSH"));
		typeService.save(new Type("JNK"));
		typeService.save(new Type("GIT"));

		commandService.save(new Command("pwl", "pwl", 1));
		commandService.save(new Command("start", "Do start", 2));
		commandService.save(new Command("lastCommit", "Return last commit of GIT", 3));
	}
}
