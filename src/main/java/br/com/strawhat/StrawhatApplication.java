package br.com.strawhat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrawhatApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(StrawhatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
	
}
