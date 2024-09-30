package entities;

//classe abstrata = nao pode ser instanciada, mas pode ser estendida
public abstract class Account {

    protected Integer number;
    protected String holder;
    protected Double balance;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        balance -= amount  + 5.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    //Para ter um methodo abstrado, a classe tambem precisa ser abstrata
    @Override
    public abstract String toString();

//    @Override
//    public String toString() {
//        return "Account{" +
//                "number=" + number +
//                ", holder='" + holder + '\'' +
//                ", balance=" + balance +
//                '}';
//    }
}
