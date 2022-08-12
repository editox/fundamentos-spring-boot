package com.edito.fundamentos;

import com.edito.fundamentos.bean.*;
import com.edito.fundamentos.component.ComponentDependency;
import com.edito.fundamentos.entity.User;
import com.edito.fundamentos.pojo.UserPojo;
import com.edito.fundamentos.repository.UserRepository;
import com.edito.fundamentos.service.UserService;
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
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	@Autowired
	private UserRepository userRepository;
	private UserService userService;

	public FundamentosApplication(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;

	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}
	@Override
	public void run(String... args) {
		saveUsersInDataBase();
		/*getInformationJpqlFromUser();
		saveWithErrorTransactional();*/

		//List<User> listToShow = userRepository.findAll();
		//listToShow.forEach(System.out::println);
	}

	private void getInformationJpqlFromUser(){
		/*
		LOGGER.info("Usuario encontrado" + "..." +
				userRepository.findByUserEmail("john@domain.com")
						.orElseThrow(() -> new RuntimeException("No se encontro el usuario"))
				);

		userRepository.findAndSort("user", Sort.by("id").descending())
				.forEach(user -> LOGGER.info("Usuario con método sort "+ user));

		userRepository.findByName("Karen")
				.forEach(user -> LOGGER.info("usuario con query method " + user));

		LOGGER.info("El usuario es: "
				+ userRepository.findByEmailAndName("marco@domain.com", "Marco")
				.orElseThrow(()-> new RuntimeException("No se encuentra ese usuario")));

		userRepository.findByNameLike("%use%").forEach(LOGGER::info);

		userRepository.findByNameOrEmail("Daniela", "john@domain.com").forEach(LOGGER::info);
		*/
		userRepository.findByBirthDateBetween(LocalDate.of(2021, 1, 1),
						LocalDate.of(2021, 3, 30))
				.forEach(user -> LOGGER.info("Lo encontramos: " + user));

		userRepository.findByNameLikeOrderByIdDesc("%us%")
				.forEach(user -> LOGGER.info("Lo encontramos! " + user));

		userRepository.findByNameContainingOrderByIdDesc("ar")
				.forEach(user -> LOGGER.info("Si lo contenia!! " + user));

		LOGGER.info("Named parameters:" + userRepository.getAllByBirthDateAndEmail(
				LocalDate.of(2021, 9, 8), "daniela@domain.com")
				.orElseThrow(()-> new RuntimeException("No se encontro el usuario")));

	}

	private void saveWithErrorTransactional(){
		User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
		User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
		User test3 = new User("TestTransactional3", "TestTransactional3@domain.com", LocalDate.now());
		User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());

		List<User> users = Arrays.asList(test1, test2, test3, test4);
		try {
			userService.saveTransactional(users);
		} catch (Exception e) {
			LOGGER.error("Esta es una exception -------------------------");
		}
		userService.getAllUsers().stream()
				.forEach(user -> LOGGER.info("Desde transaccional: " + user));
	}

	private void saveUsersInDataBase() {
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("user0", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Karen", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("user1", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("user2", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));

		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9);


		list.forEach(userRepository::save);

	}

}
