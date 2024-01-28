package org.sid.bankaccountservice.mappers;

import org.sid.bankaccountservice.dto.CompteBancaireReponseDTO;
import org.sid.bankaccountservice.entities.CompteBancaire;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {
    public CompteBancaireReponseDTO fromComptebancaire(CompteBancaire compteBancaire){
        CompteBancaireReponseDTO compteBancaireReponseDTO =new CompteBancaireReponseDTO();
        BeanUtils.copyProperties(compteBancaire,compteBancaireReponseDTO);
        return compteBancaireReponseDTO;
    }
}
