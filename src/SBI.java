import java.util.Objects;
import java.util.UUID;

public class SBI extends Bank {
    //attributes
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private double rateOfInterest;

    //constructor - alt+insert
    public SBI(String name, String password, double balance) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        this.rateOfInterest = 6.5;
        this.accountNo = String.valueOf(UUID.randomUUID()); //randomly creates a unique universal ID, converts to string
    }

    //private attributes, so getters and setters - alt+insert
    //name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //account number
    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

    //balance
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //rate of interest
    public double getRateOfInterest() {
        return rateOfInterest;
    }
    public void setRateOfInterest(double rateOfInterest) { this.rateOfInterest = rateOfInterest; }

    //method implementation
    @Override
    double checkBalance() {
        return balance;
    }

    @Override
    String addMoney(double amount) {
        balance += amount ;
        return "Your account is credited with Rs. "+ amount + ". The current balance of this account is " + balance;
    }

    @Override
    String withdrawMoney(double amount, String entered_password) {
        if (Objects.equals(entered_password, password)) { //password matches
            if (amount > balance) {                      //amount to be withdrawn > amount in account, cant do transaction
                return "Insufficient funds in account.";
            }
            balance -= amount;
            return "Rs. " + amount + "have been debited from your account, The current balance is Rs. " + balance;
        }
        return "The password entered is wrong.";
    }

    @Override
    double cal_interest(int years) {
        return (balance*years+rateOfInterest) / 100 ;
    }
}
