package com.vishnu;

		import org.mybatis.spring.annotation.MapperScan;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.context.annotation.Bean;
		import org.springframework.web.filter.CharacterEncodingFilter;

		import javax.servlet.Filter;


@SpringBootApplication
@MapperScan("com.vishnu.dao")
public class StartUp {

	@Bean
	Filter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
	}
}
