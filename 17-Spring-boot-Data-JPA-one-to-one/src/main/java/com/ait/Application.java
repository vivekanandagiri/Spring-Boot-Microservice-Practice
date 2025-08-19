package com.ait;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ait.entity.PassportEntity;
import com.ait.entity.PersonEntity;
import com.ait.repository.PersonRepository;



@SpringBootApplication
public class Application {

    private final PersonRepository personRepository;

    Application(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
@Bean


public CommandLineRunner loadDBRecord(PersonRepository repo) {
	return args->{
		PersonEntity personEntity=new PersonEntity();
		personEntity.setName("Vivek");
		personEntity.setAddress("Bhubaneswar");
		
		PassportEntity passportEntity=new PassportEntity(); 
		passportEntity.setPassportNo("AB121122");
		passportEntity.setExpiryDate(LocalDate.now().plusYears(7));
		//Linking together
		personEntity.setPassportEntity(passportEntity);
		passportEntity.setPersonEntity(personEntity);
		
		PersonEntity save = personRepository.save(personEntity);
		
		System.out.println("Person and Passport Details: ");
		PersonEntity saved = personRepository.findById(1L).orElse(null);
        if (saved != null) { 
            System.out.println("\n--- Retrieved Person ---");
            System.out.println("Person Details: " + saved);
            System.out.println("Associated Passport: " + saved.getPassportEntity());
        } 
	};
}
}
