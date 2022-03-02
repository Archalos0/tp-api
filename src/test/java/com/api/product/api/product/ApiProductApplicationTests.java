package com.api.product.api.product;

import com.api.product.api.product.dto.CustomerDTO;
import com.api.product.api.product.model.Contract;
import com.api.product.api.product.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class ApiProductApplicationTests {

	@Test
	void getUserInformations() throws ParseException {

		Contract contract = new Contract();
		contract.setId_contrat(1l);
		contract.setNom("Contrat de test");
		contract.setDate_debut(new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-01"));
		contract.setDate_fin(new SimpleDateFormat("yyyy-MM-dd").parse("2022-04-30"));
		contract.setMarge(10f);

		Customer customer = new Customer();
		customer.setID(1l);
		customer.setNom("Tanguy");
		customer.setContrat(contract);

		CustomerDTO customerDTO = CustomerDTO.from(customer);

		Assertions.assertEquals("Tanguy", customerDTO.getNom(), "test en échec pour le nom du client != Tanguy");
		Assertions.assertEquals("Contrat de test", customerDTO.getContrat().getNom(), "test en échec pour le nom du contrat != Contrat de test");
		Assertions.assertEquals("2022-03-01", customerDTO.getContrat().getDate_debut(), "test en échec pour la date de début du contrat != 2022-03-01");
		Assertions.assertEquals("2022-04-30", customerDTO.getContrat().getDate_fin(), "test en échec pour la date de fin du contrat != 2022-04-30");
		Assertions.assertEquals(10f, customerDTO.getContrat().getMarge(), "test en échec pour la marge du contrat != 10");

	}

}
