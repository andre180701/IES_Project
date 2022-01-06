package com.FastTravel.FastTravelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.FastTravel.FastTravelService.model.*;
import com.FastTravel.FastTravelService.repository.*;
import com.rabbitmq.client.Command;
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
	private PassageRepository passageRepository;
	@Autowired
	private ScutRepository scutRepository;

	public void run(String... args) throws Exception {
		long millis=System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis);  
		Client Pedro = new Client("pedrofigs@ua.pt", "pedroFigs!", 237789, "Pedro", "Figueiredo");
		CreditCard cartaoPedro = new CreditCard(1234567890, "Pedro Figueiredo", date, "Portugal", 123);
		System.out.println("Cartao de crédito: " + cartaoPedro );
		clientRepository.save(Pedro);
		creditCardRepository.save(cartaoPedro);
		/*identifierRepository.save(new Identifier("AA-BB-18", 3, Pedro, cartaoPedro));
		identifierRepository.save(new Identifier("CC-18-VV", 1, Pedro, cartaoPedro));
		scutRepository.save(new Scut(70.0987, 56.9987, "Vermelha, tem 3 metros", date, 1.70, 2.30, 3.09, 2.25, 2.70));
		scutRepository.save(new Scut(51.4679, 51.3333, "Azul, tem 3.20 metros", date, 1.75, 3.27, 2.75, 2.25, 2.56));
		scutRepository.save(new Scut(60.8901, 45.6709, "Verde, tem 3.70 metros", date, 1.70, 2.56, 3.98, 2.28, 2.61));*/
	}

}
