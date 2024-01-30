package org.sid.bankaccountservice.repositories;

import org.sid.bankaccountservice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClientRepository extends JpaRepository<Client,Long> {
}
