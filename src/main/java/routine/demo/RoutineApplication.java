package routine.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import routine.demo.model.Color;
import routine.demo.model.Day;
import routine.demo.model.Tag;
import routine.demo.repository.ColorRepository;
import routine.demo.repository.DayRepository;
import routine.demo.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
public class RoutineApplication implements CommandLineRunner {

	@Autowired
	private ColorRepository colorRepository;
	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private DayRepository dayRepository;

	public static void main(String[] args) {
		SpringApplication.run(RoutineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
