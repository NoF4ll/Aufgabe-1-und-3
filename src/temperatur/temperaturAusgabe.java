package temperatur;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class temperaturAusgabe {

	public static void main(String[] args) {

		int[][] temp = new int[14][10];
		Random r = new Random();
		int durchschnittsTempDay = 0;
		int durchschnittsTempAllDays = 0;
		LocalDate today = LocalDate.now();
		FileWriter tp;
		try {
			tp = new FileWriter("C:\\Users\\Maximilian Neuner\\Documents\\JavaTxtFiles\\temperatur.txt", true);

			for (int i = 0; i < temp.length; i++) {
				System.out.println();
				durchschnittsTempDay = 0;
				for (int j = 0; j < temp[i].length; j++) {
					temp[i][j] = 25 + r.nextInt(36 - 24);
					durchschnittsTempDay = durchschnittsTempDay + temp[i][j];
					durchschnittsTempAllDays = durchschnittsTempAllDays + temp[i][j];
					System.out.print(" " + temp[i][j]);
					tp.write(" " + temp[i][j]);
				}
				
				System.out.print(" || DurchschnittsTagesTemp : " + durchschnittsTempDay / temp[i].length);
			}
			tp.write("\nDurchschnittstemperatur :"+durchschnittsTempDay / temp[1].length);
			tp.write("\nDatei erstellt am: "+today.getDayOfMonth()+" "+today.getDayOfMonth()+" "+today.getYear());
			System.out.println("\nDie Durchschnitts Temperatur der letzten 14 Tage war : "
					+ durchschnittsTempAllDays / (temp.length * temp[1].length));
			tp.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
