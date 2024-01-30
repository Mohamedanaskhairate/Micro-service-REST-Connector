package org.sid.bankaccountservice;

import org.sid.bankaccountservice.entities.Client;
import org.sid.bankaccountservice.entities.CompteBancaire;
import org.sid.bankaccountservice.enums.TypeCompte;
import org.sid.bankaccountservice.repositories.ClientRepository;
import org.sid.bankaccountservice.repositories.CompteBancaireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class  BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start (CompteBancaireRepository  compteBancaireRepository, ClientRepository clientRepository){
    return args -> {
		Stream.of("Anas","mustapha","Mouad","Saadia","Kawtar").forEach(c->{
			Client client = Client.builder()
					.nom(c)
					.build();
           clientRepository.save(client);
		});
        clientRepository.findAll().forEach(client -> {
			for(int i=0;i<10;i++){
				CompteBancaire  compteBancaire = CompteBancaire.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? TypeCompte.Compte_Courant:TypeCompte.Compte_Epargne)
						.solde(10000+Math.random()*90000)
						.dateCreation(new Date())
						.devise("Dirham")
						.client(client)
						.build();
				compteBancaireRepository.save(compteBancaire);
			}
		});
	 };
	}
}