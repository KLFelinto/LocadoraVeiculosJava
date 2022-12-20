package model;

public class Veiculo {
	;
	private int id_veiculo;
	private String modelo;
	private String cor;
	private String placa;
	private int id_proprietario;
	
	public int getId() {
		return id_veiculo;
	}

	public void setId(int id_veiculo) {
		this.id_veiculo = id_veiculo;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getId_proprietario() {
		return id_proprietario;
	}

	public void setId_proprietario(int id_proprietario) {
		this.id_proprietario = id_proprietario;
	};
}