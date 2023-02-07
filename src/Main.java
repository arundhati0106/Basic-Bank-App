import java.util.Scanner;

public class Main {
    static String menu = "Enter 1 to see balance\n" +"Enter 2 to add money\n" +
            "Enter 3 to withdraw money\n" + "Enter 4 to check rate of interest offered\n" +
            "Enter 5 to exit";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        // Created user :--->
        System.out.println("Which bank you wish to create an account in?\n" +
                "for HDFC, press 1\n" + "for SBI, press 2\n" + "for ICICI, press 3\n"
        );

        Bank user;
        String s = sc.next();
        int bank = Integer.parseInt(s);

        System.out.println("Enter your Name");
        String name = sc.next() ;

        System.out.println("Enter a password");
        String password = sc.next() ;

        System.out.println("Enter initial balance, to create an account");
        double balance = sc.nextDouble() ;

        // Created object:-->>
        if(bank == 1) {
             user = new HDFC(name, password, balance);
        }
        else if(bank == 2) {
            user = new SBI(name, password, balance);
        }
        else {
            user = new ICICI(name, password, balance);
        }

        System.out.println(menu);

        while(sc.hasNext()) {
            System.out.println("Hello");
            String input = sc.next();

            // check balance :--->>
            if (input.equals("1")) {
                System.out.println("The current balance in your account is " + user.checkBalance());
            }

            // adding money :--->>
            else if (input.equals("2")) {
                System.out.println("Enter the amount you wish to add into account.");
                double add = sc.nextDouble();
                String message = user.addMoney(add);
                System.out.println(message);
            }

            // Withdraw money :-->>
            else if (input.equals("3")) {
                System.out.println("Enter the amount to be withdrawn.");
                double money = sc.nextInt();

                System.out.println("Enter the password : ");
                String pass = sc.next();

                System.out.println(user.withdrawMoney(money, pass));
            }

            // Rate of interest :-->>
            else if (input.equals("4")) {
                System.out.println("Enter the time period for which you wish to find roi.");
                int timeperiod = Integer.parseInt(sc.next());
                System.out.println("RateOfInterest :" + user.cal_interest(timeperiod));
            }

            else {
                System.exit(0);
            }

            option();
        }
    }

    public static void option() {
        System.out.println(" ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to go back to main menu, and 0 to exit");
        if(sc.next().equals("1")) {
            System.out.println("\n" + menu);
        }
        else if(sc.next().equals("0")) {
            System.exit(0);
        }
    }
}