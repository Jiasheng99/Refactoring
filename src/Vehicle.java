package refactoring;

public class Vehicle {
	public static final String BASIC = "Bàsic";
	public static final String GENERAL = "General";
	public static final String LUXE = "Luxe";
	private String model;
    private String marca;
    private String categoria;
    
	public Vehicle(String model, String marca, String categoria) {
		super();
		this.model = model;
		this.marca = marca;
		this.categoria = categoria;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", marca=" + marca + ", categoria=" + categoria + "]";
	}
    
}
