package consultingProblem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class testATM {
	public static void main(String[] args) throws IOException {
		File inputFile = new File("inputFile.txt");
		//PrintWriter output2 = new PrintWriter(new FileOutputStream(inputFile));
		//output2.print("");
		//output2.close();
		File outputFile = new File("outputFile.txt");
		Scanner input = new Scanner(new FileInputStream(inputFile));
		boolean tru = true;
		ArrayList<String> out = new ArrayList<String>();
		ATM atm = new ATM();
		while (tru && input.hasNextLine()) {
			/*out.add("R - Restocks the cash machine");
			out.add("W- Withdraws that amount from the cash machine (e.g. W $145");
			out.add("O- Displays the number of bills in that denomination present in the cash machine (e.g. I $20 $10 $1)");
			out.add("Q - Quits the application");*/
			String in = input.nextLine();
			String[] inx = in.split(" " + "\\$");
			if (inx[0].equals("R")) {
				atm.R();
				out.add("Reset");
			} else if (inx[0].equals("W") && (atm.isInteger(inx[1]))) {
				if (Integer.parseInt(inx[1]) > 0) {
					out.add(atm.W(Integer.parseInt(inx[1])));
				} else {
					out.add("Did not understand");
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
						out.add("Did not understand");
						break OuterLoop;
					}
					out.add(atm.I(y));
				}
			} else if (inx[0].equals("Q")) {
				out.add("Quit the program");
				tru = false;
			} else {
				out.add("Did not understand");
			}
		}
		PrintWriter output = new PrintWriter(new FileOutputStream(outputFile));
		for (String outP : out) {
			output.println(outP);
		}
		output.close();
	}
}