package consultingProblem;

public class ATM {
	private int[] cash = new int[6];
	private int[] bills = { 1, 5, 10, 20, 50, 100 };

	public ATM() {
		for (int x = 0; x < cash.length; x++) {
			cash[x] = 10;
		}
	}

	public void R() {
		for (int x = 0; x < cash.length; x++) {
			cash[x] = 10;
		}
	}

	public String W(int x) {
		int d = x;
		boolean cashed=false;
		int[] cashX = new int[6];
		outerLoop:
		while (x >= 0) {
			if ((x >= 100) && (((cash[5] - cashX[5]) > 0)) && (!cashed)) {
				x -= 100;
				cashX[5]++;
				cashed=true;
			}
			if ((x >= 50) && (((cash[4] - cashX[4]) > 0)) && (!cashed)) {
				x -= 50;
				cashX[4]++;
				cashed=true;
			}
			if ((x >= 20) && (((cash[3] - cashX[3]) > 0)) && (!cashed)) {
				x -= 20;
				cashX[3]++;
				cashed=true;
			}
			if ((x >= 10) && (((cash[2] - cashX[2]) > 0)) && (!cashed)) {
				x -= 10;
				cashX[2]++;
				cashed=true;
			}
			if ((x >= 5) && (((cash[1] - cashX[1]) > 0)) && (!cashed)) {
				x -= 5;
				cashX[1]++;
				cashed=true;
			}
			if ((x >= 1) && (((cash[0] - cashX[0]) > 0)) && (!cashed)) {
				x -= 1;
				cashX[0]++;
				cashed=true;
				}
			if(!cashed) {
				break outerLoop;
			}
			cashed=false;
		}
		if(x>0) {
			return ("Failure: insufficient funds");
		}
		for (int y = 0; y < 6; y++) {
			if (!((cash[y] - cashX[y]) >= 0)) {
				return ("Failure: insufficient funds");
			}
		}
		for (int z = 0; z < 6; z++) {
			cash[z] -= cashX[z];
		}
		return ("Success: Dispensed $" + d);
	}

	public String I(int x) {
		return ("$" + bills[x] + " - " + cash[x]);
	}

}