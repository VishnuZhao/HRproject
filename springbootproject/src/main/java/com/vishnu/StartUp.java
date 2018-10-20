package com.vishnu;

		import com.vishnu.dao.UserDao;
		import com.vishnu.model.User;
		import com.vishnu.service.UserService;
		import com.vishnu.service.impl.UserServiceImpl;
		import org.mybatis.spring.annotation.MapperScan;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.vishnu.dao")
public class StartUp {

	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
	}
}
