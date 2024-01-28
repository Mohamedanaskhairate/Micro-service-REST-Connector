package org.sid.bankaccountservice;

import org.sid.bankaccountservice.entities.CompteBancaire;
import org.sid.bankaccountservice.enums.TypeCompte;
import org.sid.bankaccountservice.repositories.CompteBancaireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class  BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start (CompteBancaireRepository  compteBancaireRepository){
    return args -> {
      for(int i=0;i<10;i++){
			CompteBancaire  compteBancaire = CompteBancaire.builder()
					.id(UUID.randomUUID().toString())
					.type(Math.random()>0.5? TypeCompte.Compte_Courant:TypeCompte.Compte_Epargne)
					.solde(10000+Math.random()*90000)
					.dateCreation(new Date())
					.devise("Dirham")
					.build();
			compteBancaireRepository.save(compteBancaire);
		}
	 };
	}

}
