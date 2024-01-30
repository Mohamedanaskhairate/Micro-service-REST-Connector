package org.sid.bankaccountservice.services;

import org.sid.bankaccountservice.dto.CompteBancaireReponseDTO;
import org.sid.bankaccountservice.dto.CompteBancaireRequeteDTO;
import org.sid.bankaccountservice.entities.CompteBancaire;


public interface CompteService  {
     CompteBancaireReponseDTO addCompte(CompteBancaireRequeteDTO compteBancaireRequeteDTO);


     CompteBancaireReponseDTO updateCompte(String id, CompteBancaireRequeteDTO compteBancaireDTO);
}
