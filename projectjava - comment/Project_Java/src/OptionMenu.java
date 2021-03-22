import java.text.DecimalFormat;
import java.util.Scanner;

public class OptionMenu extends Calculator {
    Scanner menuInput = new Scanner(System.in); // input ค่าเพื่อเลือกรายการ
    DecimalFormat moneyFormat = new DecimalFormat("'฿'###,##0.00"); // DecimalFormat เพื่อให้แสดง ฿ ค่าเงินบาทได้

    int selection;

    public void getOptionChoice() { // เลือกรายการที่จะใช้งาน
        System.out.println(" *--- Welcome ---* ");
        System.out.println("Please select option");
        System.out.println("---> 1 - ATM");
        System.out.println("---> 2 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt(); // สร้างตัวแปรใหม่ (selection) ไว้เก็บค่าที่ input เข้าไป

        switch (selection) { // เอาค่าที่เก็บใน selection มาเข้า switch case
        case 1: // 1 เรียกใช้ getChecking() ข้างล่าง
            getChecking();
            break;

        case 2: // ออกจากโปรแกรม
            System.out.println("Thank You for using this ATM, bye.");
            break;

        default: // ตัวเลือกไม่ถูกต้อง จะเรียกใช้ getOptionChoice() อีก
            System.out.println("\n" + "Invalid Choice." + "\n");
            getOptionChoice();
        }
    }

    public void getChecking() { // menuรายการ
        System.out.println("Select option: ");
        System.out.println("---> 1 - View Balance"); // ดูเงินคงเหลือ
        System.out.println("---> 2 - Withdraw Funds"); // ถอนเงิน
        System.out.println("---> 3 - Deposit Funds"); // ฝากเงิน
        System.out.println("---> 4 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
        case 1: // ดูยอดเงินคงเหลือ moneyFormat.format คือเรียกใช้ moneyFormat
                // ข้างบนเพื่อเสดงค่าเงินบาทได้ แล้วเรียกใช้ getCheckingBalance() จาก file
                // Calculator
            System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()) + "\n");
            getChecking();
            break;

        case 2:
            getCheckingWithdrawInput(); // เรียกใช้จาก file Calculator (เอา input ไปคำนวณ)
            getChecking();
            break;

        case 3:
            getCheckingDepositInput(); // เรียกใช้จาก file Calculator (เอา input ไปคำนวณ)
            getChecking();
            break;

        case 4: // ออกจากโปรแรม
            System.out.println("Thank You for using this ATM, bye.");
            break;

        default: // ใส่ค่าไม่ถูก
            System.out.println("\n" + "Invalid choice." + "\n");
            getChecking();
        }
    }

}