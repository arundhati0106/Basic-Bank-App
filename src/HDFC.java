import java.util.Objects;
import java.util.UUID;

public class HDFC extends Bank {
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private double rateOfInterest;

    public HDFC(String name, String password, double balance) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        this.rateOfInterest = 12;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public double getRateOfInterest() { return rateOfInterest; }
    public void setRateOfInterest(double rateOfInterest) { this.rateOfInterest = rateOfInterest; }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(double amount) {
        balance += amount;
        return "Your account is credited with Rs. "+ amount + ". The current balance of this account is " + balance;
    }

    @Override
    public String withdrawMoney(double amount, String entered_password) {
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
    public double cal_interest(int years) {
        return (balance*years+rateOfInterest) / 100 ;
    }
}
