package com.api.product.api.product.repository;

import com.api.product.api.product.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
