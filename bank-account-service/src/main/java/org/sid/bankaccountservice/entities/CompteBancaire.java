package org.sid.bankaccountservice.entities;
import jakarta.persistence.*;
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
    @ManyToOne
    private Client client ;
}
