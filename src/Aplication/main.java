package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("Digite o número do quarto: ");
			int number = sc.nextInt();
			System.out.println("Digite a Data de entrada (dd/MM/yyyy): ");
			Date dataEntrada = sdf.parse(sc.next());
			System.out.println("Digite a Data de Saída (dd/MM/yyyy): ");
			Date dataSaida = sdf.parse(sc.next());

			Reserva reserva = new Reserva(number, dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Digite a data atualizada:");
			System.out.println("Digite a Data de entrada (dd/MM/yyyy): ");
			dataEntrada = sdf.parse(sc.next());
			System.out.println("Digite a Data de Saída (dd/MM/yyyy): ");
			dataSaida = sdf.parse(sc.next());

			reserva.updateDates(dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);

		} catch (ParseException e) {
			System.out.println("Formato de Data inválida:");
		}

		catch (DomainException e) {
			System.out.println("Erro de reserva: " + e.getMessage());
		}

	}

}
