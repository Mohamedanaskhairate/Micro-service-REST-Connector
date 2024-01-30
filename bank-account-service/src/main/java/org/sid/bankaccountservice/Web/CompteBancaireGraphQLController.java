package org.sid.bankaccountservice.Web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice.dto.CompteBancaireReponseDTO;
import org.sid.bankaccountservice.dto.CompteBancaireRequeteDTO;
import org.sid.bankaccountservice.entities.Client;
import org.sid.bankaccountservice.entities.CompteBancaire;
import org.sid.bankaccountservice.repositories.ClientRepository;
import org.sid.bankaccountservice.repositories.CompteBancaireRepository;
import org.sid.bankaccountservice.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompteBancaireGraphQLController {
    @Autowired
    private CompteBancaireRepository compteBancaireRepository ;
    @Autowired
    private CompteService compteService;
    @Autowired
    private ClientRepository clientRepository;
    @QueryMapping
    public List<CompteBancaire> comptesList(){
        return compteBancaireRepository.findAll();
    }
    @QueryMapping
    public CompteBancaire compteBancaireById(@Argument String id){
        return  compteBancaireRepository.findById(id)
                .orElseThrow(()-> new  RuntimeException(String.format("ce compte %s n'existe pas",id)));
    }
    @MutationMapping
    public CompteBancaireReponseDTO addCompte(@Argument CompteBancaireRequeteDTO compteBancaire){
        return compteService.addCompte(compteBancaire);
    }
    @MutationMapping
    public CompteBancaireReponseDTO updateCompte(@Argument String id ,@Argument CompteBancaireRequeteDTO compteBancaire){
        return compteService.updateCompte(id,compteBancaire) ;
    }
    @MutationMapping
    public Boolean deleteCompte(@Argument String id ){
         compteBancaireRepository.deleteById(id);
         return true;
    }
    @QueryMapping
    public List<Client> clients(){
     return clientRepository.findAll();
    }
}





