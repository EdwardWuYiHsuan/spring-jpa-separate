package spring.jpa.separate.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Order(1)
@Configuration
@EntityScan("spring.jpa.model.${spring.jpa.database}.entity")
@ComponentScan(basePackages = {"spring.jpa.model.${spring.jpa.database}.dao.impl"})
@EnableJpaRepositories(basePackages = "spring.jpa.model.${spring.jpa.database}.repository")
public class AcsDbConfig {
	
}
