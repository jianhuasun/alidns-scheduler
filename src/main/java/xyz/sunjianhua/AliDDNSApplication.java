package xyz.sunjianhua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AliDDNSApplication {

	public static void main(String[] args) {
		SpringApplication.run(AliDDNSApplication.class, args);
	}
}
