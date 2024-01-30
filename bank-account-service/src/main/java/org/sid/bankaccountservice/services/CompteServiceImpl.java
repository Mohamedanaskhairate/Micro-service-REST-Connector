package org.sid.bankaccountservice.services;

import org.sid.bankaccountservice.dto.CompteBancaireReponseDTO;
import org.sid.bankaccountservice.dto.CompteBancaireRequeteDTO;
import org.sid.bankaccountservice.entities.CompteBancaire;
import org.sid.bankaccountservice.mappers.CompteMapper;
import org.sid.bankaccountservice.repositories.CompteBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    private CompteBancaireRepository compteBancaireRepository;
    @Autowired
    private CompteMapper compteMapper ;
    @Override
    public CompteBancaireReponseDTO addCompte(CompteBancaireRequeteDTO compteBancaireDTO) {
        CompteBancaire compteBancaire=CompteBancaire.builder()
                .id(UUID.randomUUID().toString())
                .dateCreation(new Date())
                .solde(compteBancaireDTO.getSolde())
                .type(compteBancaireDTO.getType())
                .devise(compteBancaireDTO.getDevise())
                .build();
        CompteBancaire saveCompteBancaire  =compteBancaireRepository.save(compteBancaire);
        CompteBancaireReponseDTO compteBancaireReponseDTO = compteMapper.fromComptebancaire(saveCompteBancaire);
        return compteBancaireReponseDTO ;
    }
    @Override
    public CompteBancaireReponseDTO updateCompte(String id ,CompteBancaireRequeteDTO compteBancaireDTO) {
        CompteBancaire compteBancaire=CompteBancaire.builder()
                .id(id)
                .dateCreation(new Date())
                .solde(compteBancaireDTO.getSolde())
                .type(compteBancaireDTO.getType())
                .devise(compteBancaireDTO.getDevise())
                .build();
        CompteBancaire saveCompteBancaire  =compteBancaireRepository.save(compteBancaire);
        CompteBancaireReponseDTO compteBancaireReponseDTO = compteMapper.fromComptebancaire(saveCompteBancaire);
        return compteBancaireReponseDTO ;
    }
}

//CompteBancaireReponseDTO compteBancaireReponseDTO = CompteBancaireReponseDTO.builder()
//         .type(saveCompteBancaire.getType())
//      .solde(saveCompteBancaire.getSolde())
//       .devise(saveCompteBancaire.getDevise())
//           .build();