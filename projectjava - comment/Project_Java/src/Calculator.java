import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'฿'###,##0.00");
	private double checkingBalance = 0;

	public double getCheckingBalance() { // จะ return ค่า checkingBalance (เงินที่มีอยู่)
		return checkingBalance;
	}

	public double calcCheckingWithdraw(double amount) { // เช็คเงินคงเหลือจากการถอนเงิน
		checkingBalance = (checkingBalance - amount); // ยอดเงินคงเหลือ - จำนวนที่กรอกเข้ามา
		return checkingBalance; // return เงินที่เหลือในบัญชีหลังถอน
	}

	public double calcCheckingDeposit(double amount) { // เช็คเงินคงเหลือจากการฝากเงิน
		checkingBalance = (checkingBalance + amount); // ยอดเงินคงเหลือ + จำนวนที่กรอกเข้ามา
		return checkingBalance; // return เงินที่เหลือในบัญชีหลังฝาก
	}

	// method ถอนเงิน
	public void getCheckingWithdrawInput() { // เอาค่าที่ input จาก file OptionMenu มาคิด
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance)); // แสดงค่าเงินบาท
								// และเงินที่เหลืออยู่ตอนนี้
		System.out.print("Amount you want to withdraw from Checking Account: ");
		double amount = input.nextDouble(); // รับค่าจน.เงินที่จะถอน

		if ((checkingBalance - amount) >= 0) { // เช็คว่าสามารถถอนได้มั้ย
					// ถ้าเงินที่มีอยู่ในบัญชี ลบ จน.เงินที่
					// input แล้วไม่ติดลบจะเข้า เงื่อนไขแรก
			calcCheckingWithdraw(amount); // สามารถถอนได้
			System.out.println("New Checking Account balance: "
					+ moneyFormat.format(checkingBalance) // แสดงค่าเงินบาทและจน.เงินที่เหลืออยู่
					+ "\n");
		} else {
			System.out.println("Not enough money." + "\n"); // ถ้าเงินมีไม่พอจะแสดงว่า
						// เงินในบช.มีไม่พอ
		}
	}

	// method ฝากเงิน
	public void getCheckingDepositInput() { // เอาค่าที่ input จาก file OptionMenu มาคิด
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance)); // แสดงค่าเงินบาท
								// และเงินที่เหลืออยู่ตอนนี้
		System.out.print("Amount you want to deposit from Checking Account: ");
		double amount = input.nextDouble(); // รับค่าจน.เงินที่จะฝาก

		if ((checkingBalance + amount) >= 0) { // เช็คว่าสามารถฝากได้มั้ย เงินที่ input
					// แล้วไม่ติดลบจะเข้า เงื่อนไขแรก
			calcCheckingDeposit(amount);
			System.out.println("New Checking Account balance: "
					+ moneyFormat.format(checkingBalance) // แสดงค่าเงินบาทและจน.เงินที่มีอยู่
					+ "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n"); // เงินที่ฝากห้ามติดลบ
		}
	}
}