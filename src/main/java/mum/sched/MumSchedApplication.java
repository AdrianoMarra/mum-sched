package mum.sched;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("mum.sched")
public class MumSchedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MumSchedApplication.class, args);
	}

}
