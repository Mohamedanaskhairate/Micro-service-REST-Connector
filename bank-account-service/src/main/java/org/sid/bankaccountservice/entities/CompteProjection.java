package org.sid.bankaccountservice.entities;

import org.sid.bankaccountservice.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = CompteBancaire.class, name="p1")
public interface CompteProjection {
    public String getId();
    public TypeCompte gettype();
    public Double getsolde();
}

