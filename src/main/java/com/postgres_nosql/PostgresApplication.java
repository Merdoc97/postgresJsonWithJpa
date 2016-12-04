package com.postgres_nosql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * example how to use Jpa with postgres jsonb type instead Mongo or any another NoSQL engines
 * documentation
 * @see <a href="https://www.postgresql.org/docs/9.4/static/datatype-json.html"></a>
 * @see <a href="https://www.postgresql.org/docs/9.4/static/functions-json.html"></a>
 */
@SpringBootApplication
public class PostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresApplication.class, args);
	}
}
