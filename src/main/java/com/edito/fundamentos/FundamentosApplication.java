package com.edito.fundamentos;

import com.edito.fundamentos.bean.*;
import com.edito.fundamentos.component.ComponentDependency;
import com.edito.fundamentos.entity.User;
import com.edito.fundamentos.pojo.UserPojo;
import com.edito.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	public FundamentosApplication(UserRepository userRepository) {
		this.userRepository = userRepository;

	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}
	@Override
	public void run(String... args) {
		saveUsersInDataBase();
		getInformationJpqlFromUser();
		System.out.println(userRepository.findByUserEmail("luchito@domain.com"));

		//List<User> listToShow = userRepository.findAll();
		//listToShow.forEach(System.out::println);
	}

	private void getInformationJpqlFromUser(){
		LOGGER.info("Usuario encontrado" + "..." +
				userRepository.findByUserEmail("john@domain.com")
						.orElseThrow(() -> new RuntimeException("No se encontro el usuario"))
				);

		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream().forEach(user -> LOGGER.info("Usuario con métod sort "+ user));
	}

	private void saveUsersInDataBase() {
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("user0", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("user1", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("user2", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));

		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9);
		list.forEach(userRepository::save);

	}

}
