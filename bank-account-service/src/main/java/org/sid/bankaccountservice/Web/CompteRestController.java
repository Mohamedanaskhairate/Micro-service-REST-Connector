package org.sid.bankaccountservice.Web;
import org.sid.bankaccountservice.dto.CompteBancaireReponseDTO;
import org.sid.bankaccountservice.dto.CompteBancaireRequeteDTO;
import org.sid.bankaccountservice.entities.CompteBancaire;
import org.sid.bankaccountservice.mappers.CompteMapper;
import org.sid.bankaccountservice.repositories.CompteBancaireRepository;
import org.sid.bankaccountservice.services.CompteService;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompteRestController {
    private CompteBancaireRepository compteBancaireRepository;
    private CompteService compteService;
    private CompteMapper compteMapper;
    public CompteRestController(CompteBancaireRepository compteBancaireRepository, CompteMapper compteMapper) {
        this.compteBancaireRepository = compteBancaireRepository;
        this.compteMapper = compteMapper;
        this.compteService = compteService;
    }
    @GetMapping("/compteBancaires")
    public List<CompteBancaire> compteBancaires() {
        return compteBancaireRepository.findAll();
    }
    @GetMapping("/compteBancaires/{id}")
    public CompteBancaire compteBancaires(@PathVariable String id) {
        return compteBancaireRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("compte %s n'existe pas",id)));
    }
    @PostMapping("/compteBancaires")
    public CompteBancaireReponseDTO ajouter(@RequestBody CompteBancaireRequeteDTO requeteDTO ){
        return compteService.addCompte(requeteDTO);
    }

    @PutMapping("/compteBancaires/{id}")
    public CompteBancaire modifier(@PathVariable String id,@RequestBody CompteBancaire compteBancaire){
        CompteBancaire compte = compteBancaireRepository.findById(id).orElseThrow();
        if (compteBancaire.getSolde()!=null)
            compte.setSolde(compteBancaire.getSolde());
        if (compteBancaire.getDateCreation()!=null)
            compte.setDateCreation(new Date());
        if (compteBancaire.getType()!=null)
            compte.setType(compteBancaire.getType());
        if (compteBancaire.getDevise()!=null)
            compte.setDevise(compteBancaire.getDevise());
        return compteBancaireRepository.save(compte);
    }
    @DeleteMapping("/compteBancaires/{id}")
    public void supprimer (@PathVariable String id) {
         compteBancaireRepository.deleteById(id);
    }
}

