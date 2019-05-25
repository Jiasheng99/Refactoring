package refactoring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorLloguersLite {

	
	
	public static void main(String[] args) throws ParseException {
		//TODO Auto-generated method stub
		// demostració de construcció d'un vehicle de categoria BASIC
		Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
		Vehicle vehicleGeneral = new Vehicle("Tato", "Visita", Vehicle.GENERAL);
		Vehicle vehicleLuxe = new Vehicle("Tinta", "Visa", Vehicle.LUXE);

		// demostració de construcció d'un lloguer amb una data
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date dateBasic = dateFormat.parse("2/8/2013");
		Date dateGeneral = dateFormat.parse("3/9/2014");
		Date dateLuxe = dateFormat.parse("4/10/2015");
		Lloguer lloguerBasic = new Lloguer(dateBasic, 2, vehicleBasic);
		Lloguer lloguerGeneral = new Lloguer(dateGeneral, 2, vehicleGeneral);
		Lloguer lloguerLuxe = new Lloguer(dateLuxe, 2, vehicleLuxe);

		// demostració de construcció d'un client
		Client clientLuxe = new Client("X5189927T", "Jiasheng", "695519611");
		clientLuxe.afegeix(lloguerBasic);
		clientLuxe.afegeix(lloguerGeneral);
		clientLuxe.afegeix(lloguerLuxe);
		
		// demostració de format d'una data
		System.out.println(dateFormat.format(lloguerBasic.getData()));
		
		// demostració del format d'un client
		System.out.println(clientLuxe.toString());
	}
}
