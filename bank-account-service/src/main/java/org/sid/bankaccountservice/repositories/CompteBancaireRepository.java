package org.sid.bankaccountservice.repositories;

import org.sid.bankaccountservice.entities.CompteBancaire;
import org.sid.bankaccountservice.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteBancaireRepository extends JpaRepository<CompteBancaire,String> {
 @RestResource(path = "/byType")
 List<CompteBancaire> findByType(@Param("t") TypeCompte type);
}
