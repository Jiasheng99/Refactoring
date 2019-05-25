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
		//No se si esta bien, con el assertEquals no me sale
		assertEquals(clientInforme, clientLuxe.informe());
	}
	
	@Test
	public void InformeSIN() throws ParseException {
		clientLuxe = new Client("X5189927T", "Jiasheng", "695519611");
		System.out.println(clientInforme2);
		System.out.println(clientLuxe.informe());
		//No se si esta bien, con el assertEquals no me sale
		assertEquals(clientInforme2, clientLuxe.informe());
	}	
	

	public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TestClientInforme");
        
    }
	
}
