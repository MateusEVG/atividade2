package model;

/**Classe Carro conectada com postgresql
 * @author MateusEvangelistaDoNascimento
 */
public class Carro {
	
	private int id;
	private String marca;
	private String modelo;
	private String cor;
	private double kilometragem;
	
	// contrutor padrão
	public Carro() {
		this.id = -1;
		this.marca = "";
		this.modelo = "";
		this.cor = "";
		this.kilometragem = 0.0;
	}
	
	// construtor completo
	public Carro(int id, String marca, String modelo, String cor, double kilometragem) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.kilometragem = kilometragem;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(double kilometragem) {
		this.kilometragem = kilometragem;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", kilometragem="
				+ kilometragem + "]";
	}
	
}
