package refactoring;

import java.util.Date;

public class Lloguer {
	private Date data;
    private Integer dies;
    private Vehicle vehicle;
    private static final double EUROS_PER_UNITAT_DE_COST_BASIC = 3;
    private static final double EUROS_PER_UNITAT_DE_COST_GENERAL = 4;
    private static final double DIES_INICI_VEHICLE_BASIC = 3;
    private static final double DIES_INICI_VEHICLE_GENERAL = 2;
    private static final double EUROS_PER_DIES_INICI_VEHICLE_BASIC = 1.5;
    private static final double EUROS_PER_DIES_INICI_VEHICLE_GENERAL = 2.5;
    private static final double EUROS_PER_DIES_INICI_VEHICLE_LUXE = 6;
    
	public Lloguer(Date data, int dies, Vehicle vehicle) {
		this.data = data;
		this.dies = dies;
		this.vehicle = vehicle;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getDies() {
		return dies;
	}

	public void setDies(Integer dies) {
		this.dies = dies;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public double PreuVehicle() {
    	double preu = 0;
        switch (getVehicle().getCategoria()) {
            case Vehicle.BASIC:
                preu += EUROS_PER_UNITAT_DE_COST_BASIC;
                if (getDies() > DIES_INICI_VEHICLE_BASIC) {
                    preu += (getDies() - DIES_INICI_VEHICLE_BASIC) * EUROS_PER_DIES_INICI_VEHICLE_BASIC;
                }
                break;
            case Vehicle.GENERAL:
                preu += EUROS_PER_UNITAT_DE_COST_GENERAL;
                if (getDies() > DIES_INICI_VEHICLE_GENERAL) {
                    preu += (getDies() - DIES_INICI_VEHICLE_GENERAL) * EUROS_PER_DIES_INICI_VEHICLE_GENERAL;
                }
                break;
            case Vehicle.LUXE:
                preu += getDies() * EUROS_PER_DIES_INICI_VEHICLE_LUXE;
                break;
        }
        return preu;
    }
	
    public int bonificacions() {
        int bonificacions = 1;
    	if (getVehicle().getCategoria() == Vehicle.LUXE &&
                getDies()>1 ) {
            bonificacions ++;
        }
		return bonificacions;
    }
	
	@Override
	public String toString() {
		return "Lloguer [data=" + data + ", dies=" + dies + ", vehicle=" + vehicle + "]";
	}
	
}
