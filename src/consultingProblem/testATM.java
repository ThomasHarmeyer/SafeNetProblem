package consultingProblem;

import java.util.Scanner;

public class testATM {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean tru = true;
		ATM atm = new ATM();
		while (tru) {
			System.out.println("R - Restocks the cash machine");
			System.out.println("W- Withdraws that amount from the cash machine (e.g. W $145");
			System.out.println(
					"O- Displays the number of bills in that denomination present in the cash machine (e.g. I $20 $10 $1)");
			System.out.println("Q - Quits the application");
			String in = input.nextLine();
			String[] inx = in.split(" " + "\\$");
			if (inx[0].equals("R")) {
				atm.R();
				System.out.println("Reset");
			} else if (inx[0].equals("W") && (atm.isInteger(inx[1]))) {
				if (Integer.parseInt(inx[1]) > 0) {
					System.out.println(atm.W(Integer.parseInt(inx[1])));
				}else {
					System.out.println("Did not understand");
				}
			} else if (inx[0].equals("I")) {
				int y = 0;
				OuterLoop:
				for (int i = 1; i < inx.length; i++) {
					if (inx[i].equals("1")) {
						y = 0;
					}else if (inx[i].equals("5")) {
						y = 1;
					}else if (inx[i].equals("10")) {
						y = 2;
					}else if (inx[i].equals("20")) {
						y = 3;
					}else if (inx[i].equals("50")) {
						y = 4;
					}else if (inx[i].equals("100")) {
						y = 5;
					}else if (inx[i].equals("1000")) {
						y = 6;
					}else {
						System.out.println("Did not understand");
						break OuterLoop;
					}
					System.out.println(atm.I(y));
				}
			} else if (inx[0].equals("Q")) {
				System.out.println("Quit the program");
				tru = false;
			} else {
				System.out.println("Did not understand");
			}
		}
	}
}