package com.Capstone.JavaCapstone;

import com.Capstone.JavaCapstone.entities.Item;
import com.Capstone.JavaCapstone.entities.ListTypes;
import com.Capstone.JavaCapstone.entities.Lists;
import com.Capstone.JavaCapstone.entities.User;
import com.Capstone.JavaCapstone.repositories.ListRepo;
import com.Capstone.JavaCapstone.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaCapstoneApplicationTests {

	@Autowired
  UserRepo userRepo;

	@Autowired
	ListRepo listRepo;

	@Test
	void contextLoads() {
	}

	User user1 = new User();
	User user2 = new User();

	Lists list1 = new Lists();
	Lists list2 = new Lists();
	Lists list3 = new Lists();
	Lists list4 = new Lists();
	Lists list5 = new Lists();


	@Test
	public void CreateUser() {

		user1.setFirstName("Benjamin");
		user1.setLastName("Cook");
		user1.setEmail("benji1313@gmail.com");
		user1.setPassword("password");

		user2.setFirstName("Lilly");
		user2.setLastName("Bee");
		user2.setEmail("lilly13@gmail.com");
		user2.setPassword("password2");

		userRepo.save(user1);
		userRepo.save(user2);
	}

	@Test
	public void createLists() {
		list1.setTitle("Snowboard");
		list1.setType(ListTypes.valueOf("ITEM"));
		list1.setOwner(user1);

		list2.setTitle("Surf/Beach");
		list2.setType(ListTypes.valueOf("ITEM"));
		list2.setOwner(user1);

		list3.setTitle("Fly-Fish");
		list3.setType(ListTypes.valueOf("ITEM"));
		list3.setOwner(user1);

		list4.setTitle("Costco");
		list4.setType(ListTypes.valueOf("SHOP"));
		list4.setOwner(user2);

		list5.setTitle("Sprouts");
		list5.setType(ListTypes.valueOf("SHOP"));
		list5.setOwner(user2);

		listRepo.save(list1);
		listRepo.save(list2);
		listRepo.save(list3);
		listRepo.save(list4);
		listRepo.save(list5);
	}

	@Test
	public void addListItems(){
		Item item1 = new Item();
		item1.setList(list1);
		item1.setName("snowboard");

		Item item2 = new Item();
		item2.setName("goggles");
		item2.setList(list1);

		Item item3 = new Item();
		item3.setName("helmet");
		item3.setList(list1);

		Item item4 = new Item();
		item4.setName("surfboard");
		item4.setList(list2);
		Item item5 = new Item();
		item5.setName("rod");
		item5.setList(list3);
		Item item6 = new Item();
		item6.setName("protein shakes");
		item6.setList(list4);
	}

}
