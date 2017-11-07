package random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Payment {
	Set<Integer> setInt = new HashSet<Integer>();
	ArrayList<Integer> intArr = new ArrayList<Integer>();
	ArrayList<Integer> payArr = new ArrayList<Integer>();
	int i;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Payment p = new Payment();
		p.calculatePay(n);

	}

	private void calculatePay(int n) {

		for (i = 1; i <= n; i++) {
			setInt.add(i);
		}
		int c = 0;
		while (c < n) {
			int num = randInt(n);

			if (setInt.contains(num) && !intArr.contains(num)) {
				intArr.add(num);
				setInt.remove(num);
				c++;
			}
		}
		int sum = intArr.get(0);
		payArr.add(sum);
		for (i = 1; i < intArr.size(); i++) {
			int pay = (intArr.get(i) - intArr.get(i - 1)) > 0 ? intArr.get(i) - intArr.get(i - 1)
					: -1 * (intArr.get(i) - intArr.get(i - 1));
			sum += pay;
			payArr.add(pay);
		}
		System.out.println("Total payment  = " + sum);
		double mean = ((1d) * sum) / payArr.size();
		System.out.println("Mean of the payment= " + mean);
		System.out.println("Standard Deviation of the payments = " + findSD(payArr, mean));

	}

	private double findSD(ArrayList<Integer> nums, double mean) {
		double sd = 0;
		for (int i = 0; i < nums.size(); i++) {
			sd += Math.pow((nums.get(i) - mean), 2) / nums.size();
		}
		return Math.sqrt(sd);

	}

	public static int randInt(int n) {

		Random rn = new Random();
		int randomNum = rn.nextInt(n + 1);
		return randomNum;
	}

}
