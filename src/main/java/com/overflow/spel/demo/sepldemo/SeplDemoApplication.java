package com.overflow.spel.demo.sepldemo;

import com.overflow.spel.demo.sepldemo.domain.MyAuthority;
import com.overflow.spel.demo.sepldemo.domain.MyUser;
import com.overflow.spel.demo.sepldemo.domain.Store;
import com.overflow.spel.demo.sepldemo.repository.MyAuthorityRepository;
import com.overflow.spel.demo.sepldemo.repository.MyUserRepository;
import com.overflow.spel.demo.sepldemo.repository.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SeplDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeplDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(MyAuthorityRepository myAuthorityRepository, MyUserRepository myUserRepository, StoreRepository storeRepository){
		return (args) -> {

			MyAuthority myAuthority = new MyAuthority();
			MyUser myUser = new MyUser();
			Store store = new Store();

			myAuthority.setName("ADMIN");


			myUser.setEnabled(true);
			myUser.setUsername("fdiaz");
			myUser.setPassword("123");
			myUser.setMyAuthorities(Arrays.asList(myAuthority));

			myUser = myUserRepository.save(myUser);

			store.setName("myStore");
			store.setMyUser(myUser);
			storeRepository.save(store);

			myUser = new MyUser();
			store = new Store();
			myAuthority = new MyAuthority();


			store.setName("myStoreSecond");

			myAuthority.setName("USER");

			myUser.setEnabled(true);
			myUser.setUsername("user2");
			myUser.setPassword("456");
			myUser.setMyAuthorities(Arrays.asList(myAuthority));

			myUser = myUserRepository.save(myUser);

			store.setMyUser(myUser);
			storeRepository.save(store);


		};
	}
}
