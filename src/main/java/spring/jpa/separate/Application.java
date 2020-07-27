package spring.jpa.separate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import spring.jpa.separate.filter.ExcludeUnnecessDbFilter;

@SpringBootApplication
@ComponentScan(
		excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = ExcludeUnnecessDbFilter.class))
public class Application {

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

}
