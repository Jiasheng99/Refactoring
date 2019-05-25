package refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class TestClientInforme {
	
	private Vehicle vehicleBasic;
	private Vehicle vehicleGeneral;
	private Vehicle vehicleLuxe;
	private Lloguer lloguerBasic;
	private Lloguer lloguerGeneral;
	private Lloguer lloguerLuxe;
	private Client clientLuxe;
	
	private static final String clientInforme = "Informe de lloguers del client Jiasheng (X5189927T)\n" + 
			"	Vista Tata: 90.0€\n" + 
			"	Visita Tato: 120.0€\n" + 
			"	Visa Tinta: 360.0€\n" + 
			"Import a pagar: 570.0€\n" + 
			"Punts guanyats: 4\n";
	private static final String clientInforme2 = "Informe de lloguers del client Jiasheng (X5189927T)\n" + 
			"Import a pagar: 0.0€\n" + 
			"Punts guanyats: 0\n";
	private static final String clientInforme3 = "Informe de lloguers del client Jiasheng (X5189927T)\n" + 
			"	Vista Tata: 90.0€\n" + 
			"Import a pagar: 90.0€\n" + 
			"Punts guanyats: 1\n";
	private static final String clientInforme4 = "Informe de lloguers del client Jiasheng (X5189927T)\n" + 
			"	Visita Tato: 120.0€\n" + 
			"Import a pagar: 120.0€\n" + 
			"Punts guanyats: 1\n";
	private static final String clientInforme5 = "Informe de lloguers del client Jiasheng (X5189927T)\n" + 
			"	Visa Tinta: 900.0€\n" +
			"Import a pagar: 900.0€\n" + 
			"Punts guanyats: 2\n";
	
	@Test
	public void InformeTODO() throws ParseException {
		vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
		vehicleGeneral = new Vehicle("Tato", "Visita", Vehicle.GENERAL);
		vehicleLuxe = new Vehicle("Tinta", "Visa", Vehicle.LUXE);
		clientLuxe = new Client("X5189927T", "Jiasheng", "695519611");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date dateBasic = dateFormat.parse("2/8/2013");
		lloguerBasic = new Lloguer(dateBasic, 2, vehicleBasic);
		clientLuxe.afegeix(lloguerBasic);
		Date dateGeneral = dateFormat.parse("3/9/2014");
		lloguerGeneral = new Lloguer(dateGeneral, 2, vehicleGeneral);
		clientLuxe.afegeix(lloguerGeneral);
		Date dateLuxe = dateFormat.parse("4/10/2015");
		lloguerLuxe = new Lloguer(dateLuxe, 2, vehicleLuxe);
		clientLuxe.afegeix(lloguerLuxe);
		System.out.println(clientInforme);
		System.out.println(clientLuxe.informe());
		assertEquals(clientInforme, clientLuxe.informe());
	}
	
	@Test
	public void InformeSIN() throws ParseException {
		clientLuxe = new Client("X5189927T", "Jiasheng", "695519611");
		System.out.println(clientInforme2);
		System.out.println(clientLuxe.informe());
		assertEquals(clientInforme2, clientLuxe.informe());
	}	
	
	@Test
	public void InformeUN() throws ParseException {
		vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
		clientLuxe = new Client("X5189927T", "Jiasheng", "695519611");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date dateGeneral = dateFormat.parse("3/9/2014");
		lloguerLuxe = new Lloguer(dateGeneral, 2, vehicleBasic);
		clientLuxe.afegeix(lloguerLuxe);
		System.out.println(clientInforme3);
		System.out.println(clientLuxe.informe());
		assertEquals(clientInforme3, clientLuxe.informe());
	}	
	
	@Test
	public void InformeUNDIA() throws ParseException {
		vehicleGeneral = new Vehicle("Tato", "Visita", Vehicle.GENERAL);
		clientLuxe = new Client("X5189927T", "Jiasheng", "695519611");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date dateGeneral = dateFormat.parse("3/9/2014");
		lloguerLuxe = new Lloguer(dateGeneral, 1, vehicleGeneral);
		clientLuxe.afegeix(lloguerLuxe);
		System.out.println(clientInforme4);
		System.out.println(clientLuxe.informe());
		assertEquals(clientInforme4, clientLuxe.informe());
	}	
	
	@Test
	public void InformeMASDIA() throws ParseException {
		vehicleLuxe = new Vehicle("Tinta", "Visa", Vehicle.LUXE);
		clientLuxe = new Client("X5189927T", "Jiasheng", "695519611");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date dateLuxe = dateFormat.parse("4/10/2015");
		lloguerLuxe = new Lloguer(dateLuxe, 5, vehicleLuxe);
		clientLuxe.afegeix(lloguerLuxe);
		System.out.println(clientInforme5);
		System.out.println(clientLuxe.informe());
		assertEquals(clientInforme5, clientLuxe.informe());
	}	

	@Test
	public void ComprovaNewInforme() throws ParseException {
		clientLuxe = new Client("X5189927T", "Jiasheng", "695519611");
		System.out.println(clientLuxe.informe());
	}
	
	public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TestClientInforme");
        
    }
	
}
