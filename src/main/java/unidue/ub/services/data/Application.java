package unidue.ub.services.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("unidue.ub.media.analysis")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
