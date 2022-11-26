package com.Capstone.JavaCapstone;

import com.Capstone.JavaCapstone.entity.User;
import com.Capstone.JavaCapstone.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//@Component
public class LoadData implements CommandLineRunner{

//  private final Logger log = new LoggerFactory.getLogger(LoadData.class);

    private final UserRepo userRepo;
//    private final ListsRepo listsRepo;

    @Autowired
    public LoadData(UserRepo userRepo){
      this.userRepo = userRepo;
    }

//    @Autowired
//    public LoadData(ListsRepo listsRepo){
//      this.listsRepo = listsRepo;
//    }

    @Override
    public void run(String... args) throws Exception {
      // Add users
      userRepo.save(new User("Benjamin", "Cook", "benji1313@gmail.com", "password"));
      userRepo.save(new User("Lilly", "Cook", "lilly13@gmail.com", "password2"));

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


