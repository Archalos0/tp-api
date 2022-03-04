package com.api.product.api.product;

import com.api.product.api.product.dto.ContractDTO;
import com.api.product.api.product.dto.CustomerDTO;
import com.api.product.api.product.dto.ProductCustomerDTO;
import com.api.product.api.product.model.Contract;
import com.api.product.api.product.model.Customer;
import com.api.product.api.product.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RunWith(Parameterized.class)
@SpringBootTest
class ApiProductApplicationTests {

	static Stream<Arguments> getCustomer() throws Throwable {
		return Stream.of(
				Arguments.of(new Customer(1L,"Client 1"),
						new Contract(1L,"Contrat de test",10f)),
				Arguments.of(new Customer(2L, "Client 2"),
						new Contract(2L, "Contrat numéro 2", 5f)));
	}

	static Stream<Arguments> getContract() throws Throwable {
		return Stream.of(
				Arguments.of(new Contract(1L,"Contrat de test",10f),
						new Customer(1L,"Client 1"),
						new Customer(2L,"Client 2")),
				Arguments.of(new Contract(2L, "Contrat numéro 2", 5f),
						new Customer(1L,"Client 1"),
						new Customer(2L, "Client 2")));
	}

	static Stream<Arguments> getProductCustomer() throws Throwable {
		return Stream.of(
				Arguments.of(new Customer(2L,"Client 2"),
						new Contract(2L, "Contrat numéro 2", 15f),
						new Product(1L,"Moteur", 152.58f),
						205.98f),
				Arguments.of(new Customer(1L,"Client 1"),
						new Contract(1L, "Contrat 1", 5f),
						new Product(1L,"Moteur", 100f),
						125f));
	}

	@ParameterizedTest(
			name = "Test get customer"
	)
	@MethodSource({"getCustomer"})
	void getCustomerInformations(Customer customer, Contract contract) {

		customer.setContrat(contract);

		CustomerDTO customerDTO = CustomerDTO.from(customer);

		Assertions.assertEquals(customer.getID(), customerDTO.getId_client(), "test en échec pour l'id' du client != " + customer.getID());
		Assertions.assertEquals(customer.getNom(), customerDTO.getNom(), "test en échec pour le nom du client != " + customer.getNom());

		Assertions.assertEquals(contract.getId_contrat(), customerDTO.getContrat().getId_contrat(), "test en échec pour l'id du contrat != " + contract.getId_contrat());
		Assertions.assertEquals(contract.getNom(), customerDTO.getContrat().getNom(), "test en échec pour le nom du contrat != " + contract.getNom());
		Assertions.assertEquals(contract.getMarge(), customerDTO.getContrat().getMarge(), "test en échec pour la marge du contrat != " + contract.getMarge());

	}

	@ParameterizedTest(
			name = "Test get contract"
	)
	@MethodSource({"getContract"})
	void getContractInformations(Contract contract, Customer customer1, Customer customer2) {

		customer1.setContrat(contract);
		customer2.setContrat(contract);

		List<Customer> customersLinkToContract = new ArrayList<>();
		customersLinkToContract.add(customer1);
		customersLinkToContract.add(customer2);

		contract.setCustomers(customersLinkToContract);

		ContractDTO contractDTO = ContractDTO.from(contract);

		Assertions.assertEquals(contract.getId_contrat(), contractDTO.getId_contrat(), "test en échec pour l'id du contrat != " + contract.getId_contrat());
		Assertions.assertEquals(contract.getNom(), contractDTO.getNom(), "test en échec pour le nom du contrat != " + contract.getNom());
		Assertions.assertEquals(contract.getMarge(), contractDTO.getMarge(), "test en échec pour la marge du contrat != " + contract.getMarge());

		Assertions.assertEquals(contract.getId_contrat(), contractDTO.getCustomersDTO().get(0).getContrat().getId_contrat(), "test en échec pour le contrat du client 1 != " + contract.getId_contrat());
		Assertions.assertEquals(contract.getNom(), contractDTO.getCustomersDTO().get(0).getContrat().getNom(), "test en échec pour le nom du contrat du client 1 != " + contract.getNom());
		Assertions.assertEquals(contract.getMarge(), contractDTO.getCustomersDTO().get(0).getContrat().getMarge(), "test en échec pour la marge du contrat du client 1 != " + contract.getMarge());

		Assertions.assertEquals(contract.getId_contrat(), contractDTO.getCustomersDTO().get(1).getContrat().getId_contrat(), "test en échec pour le contrat du client 2 != " + contract.getId_contrat());
		Assertions.assertEquals(contract.getNom(), contractDTO.getCustomersDTO().get(1).getContrat().getNom(), "test en échec pour le nom du contrat du client 2 != " + contract.getNom());
		Assertions.assertEquals(contract.getMarge(), contractDTO.getCustomersDTO().get(1).getContrat().getMarge(), "test en échec pour la marge du contrat du client 2 != " + contract.getMarge());
	}

	@ParameterizedTest(
			name = "Test get products by customer"
	)
	@MethodSource({"getProductCustomer"})
	void getProductCustomer(Customer customer, Contract contract, Product product1, float sellingPrice) {

		customer.setContrat(contract);

		List<Customer> customersLinkToContract = new ArrayList<>();
		customersLinkToContract.add(customer);
		contract.setCustomers(customersLinkToContract);

		ProductCustomerDTO productDTO1 = ProductCustomerDTO.from(product1, customer.getContrat().getMarge());

		Assertions.assertEquals(product1.getID(), productDTO1.getId_article(), "test en échec pour l'id marge du produit != " + product1.getID());
		Assertions.assertEquals(product1.getDesignation(), productDTO1.getDesignation(), "test en échec pour le nom du produit != " + product1.getDesignation());
		Assertions.assertEquals(product1.getPrix(), productDTO1.getPrix(), "test en échec pour le prix de fabricationdu produit != " + product1.getPrix());
		Assertions.assertEquals(sellingPrice, productDTO1.getPrix_vente(), "test en échec pour le prix de vente du produit par rapport au client != " + sellingPrice);
	}
}
