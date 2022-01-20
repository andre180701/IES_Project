package com.FastTravel.FastTravelService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.FastTravel.FastTravelService.model.*;
import com.FastTravel.FastTravelService.repository.*;
import com.FastTravel.FastTravelService.service.AdminService;
import com.FastTravel.FastTravelService.service.ClientService;
import com.FastTravel.FastTravelService.service.CreditCardService;
import com.FastTravel.FastTravelService.service.ScutService;

import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class FastTravelServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FastTravelServiceApplication.class, args);
	}

	@Autowired
	private ClientService clientService;
	@Autowired
	private CreditCardService creditCardService;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ScutService scutService;
	@Autowired
	private CreditCardRepository creditCardRepository;
	@Autowired
	private ScutRepository scutRepository;
	@Autowired
	private AdminRepository adminRepository;
  @Autowired
	private IdentifierRepository identifierRepository;
	
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    { 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
        return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
    }
    
    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash); 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
  
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
  
        return hexString.toString(); 
    }
  
	public void run(String... args) throws Exception {
		Client Pedro = new Client("pedrofigs@ua.pt", toHexString(getSHA("pedroFigs!")), 237789, "Pedro", "Figueiredo");
		
		Boolean flag = true;
		for (Client client : clientService.getClients()) {
			if (Pedro.getEmail().equals(client.getEmail()) && Pedro.getNif() == client.getNif()){
				flag = false;
			}
		}
		if (flag == true){
			clientRepository.save(Pedro);
		}

		
		flag = true;
		CreditCard cartaoPedro = new CreditCard(1234567890, "Pedro Figueiredo", Date.valueOf("2023-10-1"), "Portugal", 123);
		for (CreditCard creditCard : creditCardService.getCreditCards()) {
			if (cartaoPedro.getNumber() == creditCard.getNumber() && cartaoPedro.getCvv() == creditCard.getCvv()){
				flag = false;
			}
		}
		if (flag == true){
			creditCardRepository.save(cartaoPedro);
		}
		
		flag = true;
		Scut scut1 = new Scut(70.0987, 56.9987, "Peso Regua N/S", Date.valueOf("2001-11-6"), 1.70, 2.30, 3.09, 2.25, 2.70);
		for (Scut scut : scutService.getScuts()) {
			if (scut1.getLatitude() == scut.getLatitude() && scut1.getLongitude() == scut.getLongitude() ){
				flag = false;
			}
		}
		if (flag == true){
			scutRepository.save(scut1);
		}
		
		Scut scut2 = new Scut(51.4679, 51.3333, "Vila Real S O/E", Date.valueOf("2001-12-17"), 1.75, 3.27, 2.75, 2.25, 2.56);
		flag = true;
		for (Scut scut : scutService.getScuts()) {
			if (scut2.getLatitude() == scut.getLatitude() && scut2.getLongitude() == scut.getLongitude() ){
				flag = false;
			}
		}
		if (flag == true){
			scutRepository.save(scut2);
		}
		Scut scut3 = new Scut(60.8901, 45.6709, "Campea O/E", Date.valueOf("2001-5-20"), 1.70, 2.56, 3.98, 2.28, 2.61);
		flag = true;
		for (Scut scut : scutService.getScuts()) {
			if (scut3.getLatitude() == scut.getLatitude() && scut3.getLongitude() == scut.getLongitude() ){
				flag = false;
			}
		}
		if (flag == true){
			scutRepository.save(scut3);
		}
		flag = true;
		Admin admin1 = new Admin("andrefreixo18@ua.pt", toHexString(getSHA("andrefreixo!")), "André", "Freixo");
		for (Admin admin : adminService.getAdmins()) {
			if (admin1.getEmail().equals(admin.getEmail())){
				flag = false;
			}
		}
		if (flag == true){
			adminRepository.save(admin1);
		}

		if(identifierRepository.findAll().isEmpty()){
			identifierRepository.save(new Identifier("AA-BB-18", 3, Pedro, cartaoPedro));
			identifierRepository.save(new Identifier("CC-18-VV", 1, Pedro, cartaoPedro));
		} 
		
	}
	
}



