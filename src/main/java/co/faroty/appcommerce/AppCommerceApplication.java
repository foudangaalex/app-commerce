package co.faroty.appcommerce;

import co.faroty.appcommerce.dtos.UserDTO;
import co.faroty.appcommerce.security.entity.Users;
import co.faroty.appcommerce.security.repo.RoleRepository;
import co.faroty.appcommerce.security.repo.UsersRepository;
import co.faroty.appcommerce.services.ProductService;
import co.faroty.appcommerce.security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class AppCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountService accountService){
		return args -> {

				UserDTO userDTO=new UserDTO();
				userDTO.setUserName("Fouda");
				userDTO.setImageUser("Im.png");
				userDTO.setEmail("Ngan@gmail.com");
				userDTO.setPassWord(passwordEncoder().encode("1234"));
				userDTO.setTel("2132566677");
				accountService.addUser(userDTO);
				accountService.addNewRole("ADMIN");
				accountService.addNewRole("USER");
				accountService.addRoleToUser("ADMIN","Fouda");


		};
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
   //@Bean
//	CommandLineRunner commandLineRunner(AccountService accountService, ProductService productService){
//		return args -> {
//			Stream.of("Fouda", "bobo", "Abomo").forEach(name -> {
//				UserDTO usersDTO = new UserDTO();
//				usersDTO.setUserId(UUID.randomUUID().toString());
//				usersDTO.setName(name);
//				usersDTO.setEmail(name + "@gmail.com");
//				usersDTO.setImageUser(name + ".png");
//				usersDTO.setPassWord("1234");
//				usersDTO.setTel("6789534");
//				accountService.addUser(usersDTO);
//
//			});
//			accountService.findAllUsers().forEach(uses->{
//
//				productService.saveProduct("coleur",2000,"image",false,uses.getUserId());
//			});
//		};
//	}

//    //@Bean
//	CommandLineRunner start(ProductRepository productRepository, UsersRepository usersRepository,
//							CategoryRepository categoryRepository, UsersTokenRepository usersTokenRepository, AdminRepository adminRepository){
//		return args -> {
//			Stream.of("Fouda","bobo","Abomo").forEach(name->{
//				Users users=new Users();
//				users.setName(name);
//				users.setEmail(name+"@gmail.com");
//				users.setImageUser(name+".png");
//				users.setPassWord("1234");
//				users.setTel("6789534");
//				usersRepository.save(users);
//			});
//			Admin admin1=new Admin();
//			;admin1.setName("Papa");
//			admin1.setPassword("1235");
//			adminRepository.save(admin1);
//
//			Admin admin2=new Admin();
//			;admin2.setName("Enama");
//			admin2.setPassword("2345");
//			adminRepository.save(admin2);
//
//			other category1=new other();
//			category1.setNameCat("Meubles");
//			category1.setAdmin(admin1);
//			categoryRepository.save(category1);
//
//			other category2=new other();
//			category2.setNameCat("Habillement");
//			category2.setAdmin(admin2);
//			categoryRepository.save(category2);
//			usersRepository.findAll().forEach(user -> {
//				Product product=new Product();
//				product.setDesignation(Math.random()*10>0.3?"chaise":"table");
//				product.setPrice(Math.random()*3000);
//				product.setImage("image.png");
//				product.setValid(true);
//				product.setCategory(category1);
//				product.setUsers(user);
//				productRepository.save(product);
//
//				UsersTokens usersTokens=new UsersTokens();
//				usersTokens.setToken(UUID.randomUUID().toString());
//				usersTokens.setUsers(user);
//				usersTokenRepository.save(usersTokens);
//
//			});
//
//		};
//	}
}
