package org.sid.bankaccountservice.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice.enums.TypeCompte;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteBancaire {
    @Id
    private  String id ;
    private Date dateCreation ;
    private Double solde ;
    private String devise ;
    @Enumerated(EnumType.STRING)
    private TypeCompte type ;
}
