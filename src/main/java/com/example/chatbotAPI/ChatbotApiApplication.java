package com.example.chatbotAPI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class ChatbotApiApplication implements CommandLineRunner {
	DataSource dataSource;
	public ChatbotApiApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public static void main(String[] args) {

		SpringApplication.run(ChatbotApiApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		JdbcTemplate template = new JdbcTemplate(dataSource);
//		template.execute("SELECT * FROM Doctor");
	}
}
