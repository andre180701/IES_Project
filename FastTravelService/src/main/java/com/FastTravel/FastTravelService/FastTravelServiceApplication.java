package com.FastTravel.FastTravelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.FastTravel.FastTravelService.model.*;
import com.FastTravel.FastTravelService.repository.*;
import java.sql.Date;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class FastTravelServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FastTravelServiceApplication.class, args);
	}

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CreditCardRepository creditCardRepository;
	@Autowired
	private IdentifierRepository identifierRepository;
	@Autowired
	private ScutRepository scutRepository;

	public void run(String... args) throws Exception {
		Client Pedro = new Client("pedrofigs@ua.pt", "pedroFigs!", 237789, "Pedro", "Figueiredo");
		CreditCard cartaoPedro = new CreditCard(1234567890, "Pedro Figueiredo", Date.valueOf("2023-10-1"), "Portugal", 123);
		clientRepository.save(Pedro);
		creditCardRepository.save(cartaoPedro);
		identifierRepository.save(new Identifier("AA-BB-18", 3, Pedro, cartaoPedro));
		identifierRepository.save(new Identifier("CC-18-VV", 1, Pedro, cartaoPedro));
		scutRepository.save(new Scut(70.0987, 56.9987, "Peso Regua N/S", Date.valueOf("2001-11-6"), 1.70, 2.30, 3.09, 2.25, 2.70));
		scutRepository.save(new Scut(51.4679, 51.3333, "Vila Real S O/E", Date.valueOf("2001-12-17"), 1.75, 3.27, 2.75, 2.25, 2.56));
		scutRepository.save(new Scut(60.8901, 45.6709, "Campea O/E", Date.valueOf("2001-5-20"), 1.70, 2.56, 3.98, 2.28, 2.61));
	}

}

