package com.Capstone.JavaCapstone;

import com.Capstone.JavaCapstone.entity.Lists;
import com.Capstone.JavaCapstone.repo.ListsRepo;
import com.Capstone.JavaCapstone.entity.Users;
import com.Capstone.JavaCapstone.repo.UsersRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class LoadData implements CommandLineRunner{

//  private final Logger log = new LoggerFactory.getLogger(LoadData.class);

    private final UsersRepo usersRepo;
//    private final ListsRepo listsRepo;

    @Autowired
    public LoadData(UsersRepo usersRepo){
      this.usersRepo = usersRepo;
    }

//    @Autowired
//    public LoadData(ListsRepo listsRepo){
//      this.listsRepo = listsRepo;
//    }

    @Override
    public void run(String... args) throws Exception {
      // Add users
      usersRepo.save(new Users("Benjamin", "Cook", "benji1313@gmail.com", "password"));
      usersRepo.save(new Users("Lilly", "Cook", "lilly13@gmail.com", "password2"));

//      listsRepo.save(new Lists("Snowboard", 1L));
//      listsRepo.save(new Lists("Surf", 1L));
//      listsRepo.save(new Lists("Fly Fish", 1L));
//      listsRepo.save(new Lists("Van Life", 1L));
//
//      listsRepo.save(new Lists("Smiths", 2L));
//      listsRepo.save(new Lists("Costco", 2L));
//      listsRepo.save(new Lists("Winco", 2L));
//      listsRepo.save(new Lists("Sprouts", 2L));
    }
}


