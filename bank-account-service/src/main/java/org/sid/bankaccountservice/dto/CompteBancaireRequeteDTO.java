package org.sid.bankaccountservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice.enums.TypeCompte;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteBancaireRequeteDTO {

    private  String id ;
    private Date dateCreation ;
    private Double solde ;
    private String devise ;
    private TypeCompte type ;
}
