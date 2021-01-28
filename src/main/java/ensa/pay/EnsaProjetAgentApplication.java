package ensa.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EnsaProjetAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnsaProjetAgentApplication.class, args);
	}

}
