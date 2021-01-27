package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class main {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Digite o número do quarto: ");
		int number = sc.nextInt();
		System.out.println("Digite a Data de entrada (dd/MM/yyyy): ");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.println("Digite a Data de Saída (dd/MM/yyyy): ");
		Date dataSaida = sdf.parse(sc.next());

		if (!dataSaida.after(dataEntrada)) {
			System.out.println("Erro de reserva: A data de saída tem que ser depois da data de entrada.");
		} else {
			Reserva reserva = new Reserva(number, dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Digite a data atualizada:");
			System.out.println("Digite a Data de entrada (dd/MM/yyyy): ");
			dataEntrada = sdf.parse(sc.next());
			System.out.println("Digite a Data de Saída (dd/MM/yyyy): ");
			dataSaida = sdf.parse(sc.next());

			Date now = new Date();
			if (dataEntrada.before(now) || dataSaida.before(now)) {
				System.out.println("Erro de reserva: As datas tem que ser futuras");
			} else if (!dataSaida.after(dataEntrada)) {
				System.out.println("Erro de reserva: A data de saída tem que ser depois da data de entrada.");
			}

			reserva.updateDates(dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);
		}

	}

}
