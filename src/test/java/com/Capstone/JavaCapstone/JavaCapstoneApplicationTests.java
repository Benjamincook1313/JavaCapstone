package com.Capstone.JavaCapstone;

import com.Capstone.JavaCapstone.entity.Lists;
import com.Capstone.JavaCapstone.entity.Users;
import com.Capstone.JavaCapstone.repo.ListsRepo;
import com.Capstone.JavaCapstone.repo.UsersRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaCapstoneApplicationTests {

	@Autowired
	UsersRepo usersRepo;

	@Autowired
	ListsRepo listsRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateUser() {

		Users user1 = new Users();
		user1.setFirstName("Benjamin");
		user1.setLastName("Cook");
		user1.setEmail("benji1313@gmail.com");
		user1.setPassword("password");

		Users user2 = new Users();
		user2.setFirstName("Lilly");
		user2.setLastName("Bee");
		user2.setEmail("lilly13@gmail.com");
		user2.setPassword("password2");

		usersRepo.save(user1);
		usersRepo.save(user2);

		Lists list1 = new Lists();
		list1.setTitle("Snowboard");
		list1.setUser(user1);

		Lists list2 = new Lists();
		list2.setTitle("Surf/Beach");
		list2.setUser(user1);

		Lists list3 = new Lists();
		list3.setTitle("Fly-fish");
		list3.setUser(user1);

		Lists list4 = new Lists();
		list4.setTitle("Costco");
		list4.setUser(user2);

		Lists list5 = new Lists();
		list5.setTitle("Sprouts");
		list5.setUser(user2);

		Lists list6 = new Lists();
		list6.setTitle("Christmas");
		list6.setUser(user2);

		listsRepo.save(list1);
		listsRepo.save(list2);
		listsRepo.save(list3);
		listsRepo.save(list4);
		listsRepo.save(list5);
		listsRepo.save(list6);
	}
}
