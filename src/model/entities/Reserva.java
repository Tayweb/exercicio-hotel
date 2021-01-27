package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public long duracao() {
		long diferenca = dataSaida.getTime() - dataEntrada.getTime(); // Aqui pega a diferen�a das datas em milisegundos
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); // convers�o de milesegundos para dias
	}

	public void updateDates(Date dataEntrada, Date dataSaida) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

//	public void imprimir() {
//		System.out.println("N�mero do quarto: " + this.numeroQuarto);
//		System.out.println("Data de entrada: " + sdf.format(getDataEntrada()));
//		System.out.println("Data de sa�da: " + sdf.format(getDataSaida()));
//		System.out.println("Dura��o: " + duracao() + "noites");
//	}
	
	@Override
	public String toString() {
		return "Room "
				+numeroQuarto
				+", Data de Entrada: "
				+ sdf.format(dataEntrada)
				+", Data de Sa�da: "
				+ sdf.format(dataSaida)
				+ " , "
				+ duracao()
				+" noites ";
		
	}
}
