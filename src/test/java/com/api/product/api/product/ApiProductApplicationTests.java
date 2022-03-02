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
		contract.setMarge(10f);

		Customer customer = new Customer();
		customer.setID(1l);
		customer.setNom("Tanguy");
		customer.setContrat(contract);

		CustomerDTO customerDTO = CustomerDTO.from(customer);

		Assertions.assertEquals("Tanguy", customerDTO.getNom(), "test en échec pour le nom du client != Tanguy");
		Assertions.assertEquals("Contrat de test", customerDTO.getContrat().getNom(), "test en échec pour le nom du contrat != Contrat de test");
		Assertions.assertEquals(10f, customerDTO.getContrat().getMarge(), "test en échec pour la marge du contrat != 10");

	}

}
