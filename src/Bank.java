public abstract class Bank {
    abstract double checkBalance();
    abstract String addMoney(double amount);
    abstract String withdrawMoney(double amount, String password);
    abstract double cal_interest(int years); //roi, amount -> in class
}
