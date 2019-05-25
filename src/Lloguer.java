package refactoring;

import java.util.Date;

public class Lloguer {
	private Date data;
    private Integer dies;
    private Vehicle vehicle;
    
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

	public double quantitat() {
    	double quantitat = 0;
        switch (getVehicle().getCategoria()) {
            case Vehicle.BASIC:
                quantitat += 3;
                if (getDies() > 3) {
                    quantitat += (getDies() - 3) * 1.5;
                }
                break;
            case Vehicle.GENERAL:
                quantitat += 4;
                if (getDies() > 2) {
                    quantitat += (getDies() - 2) * 2.5;
                }
                break;
            case Vehicle.LUXE:
                quantitat += getDies() * 6;
                break;
        }
        return quantitat;
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
