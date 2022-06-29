package com.Validation.RestNationalId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class RestNationalIdApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestNationalIdApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		try {
			String sql = "INSERT INTO nationalid (id, gender, birthDate) VALUES (?,?,?)";
			int result = jdbcTemplate.update(sql, args);

			if (result > 0) {
				System.out.println("A new row has been inserted");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}*/
}
