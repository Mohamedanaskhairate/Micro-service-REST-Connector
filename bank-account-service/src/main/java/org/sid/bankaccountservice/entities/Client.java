package org.sid.bankaccountservice.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom ;
    @OneToMany (mappedBy = "client")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<CompteBancaire> compteBancaires ;
}
