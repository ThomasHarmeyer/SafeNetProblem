package consultingProblem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class testATM {
	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/Thomas/workspace/SafeNetProblem/src/consultingProblem/file.txt");
		Scanner input = new Scanner(new FileInputStream(file));
		PrintWriter output = new PrintWriter(new FileOutputStream(file));
		boolean tru = true;
		ATM atm = new ATM();
		while (tru && input.hasNextLine()) {
			output.println("R - Restocks the cash machine");
			output.println("W- Withdraws that amount from the cash machine (e.g. W $145");
			output.println(
					"O- Displays the number of bills in that denomination present in the cash machine (e.g. I $20 $10 $1)");
			output.println("Q - Quits the application");
			String in = input.nextLine();
			String[] inx = in.split(" " + "\\$");
			if (inx[0].equals("R")) {
				atm.R();
				output.println("Reset");
			} else if (inx[0].equals("W") && (atm.isInteger(inx[1]))) {
				if (Integer.parseInt(inx[1]) > 0) {
					output.println(atm.W(Integer.parseInt(inx[1])));
				} else {
					output.println("Did not understand");
				}
			} else if (inx[0].equals("I")) {
				int y = 0;
				OuterLoop: for (int i = 1; i < inx.length; i++) {
					if (inx[i].equals("1")) {
						y = 0;
					} else if (inx[i].equals("5")) {
						y = 1;
					} else if (inx[i].equals("10")) {
						y = 2;
					} else if (inx[i].equals("20")) {
						y = 3;
					} else if (inx[i].equals("50")) {
						y = 4;
					} else if (inx[i].equals("100")) {
						y = 5;
					} else if (inx[i].equals("1000")) {
						y = 6;
					} else {
						output.println("Did not understand");
						break OuterLoop;
					}
					output.println(atm.I(y));
				}
			} else if (inx[0].equals("Q")) {
				output.println("Quit the program");
				tru = false;
			} else {
				output.println("Did not understand");
			}
		}
		output.close();
	}
}