package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do Quarto: ");
		int number = sc.nextInt();
		System.out.print("Check-in Date (dd/MM/yyyy):  ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out Date (dd/MM/yyyy):  ");
		Date checkout = sdf.parse(sc.next());
		
		if (! checkout.after(checkin)) {
			System.out.println("erro na reserva ! data de chek-in é maior que a do chec-out");
		}
		else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reserva: "+ reservation);
			
			System.out.println();
			System.out.println("atualize a reserva : ");
			System.out.print("Check-in Date (dd/MM/yyyy):  ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out Date (dd/MM/yyyy):  ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkin.before(now) || checkout.before(now)); {
				System.out.println("erro na reserva ! Para atulização as datas devem se futuras.");
			}
			 if (! checkout.after(checkin)) { 	 
					System.out.println("erro na reserva ! data de chek-in é maior que a do chec-out");
			}
			else {
			
			reservation.updateDate(checkin, checkout);
			System.out.println("Reserva: "+ reservation);
			}
		}
		
		
		
		
		sc.close();

	}

}
