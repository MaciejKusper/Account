import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maciek on 02.08.2017.
 */
public class Konto implements Comparable<Konto> {
    private String accountNumber;
    private String ownerName;
    private int balance;
    static private int accountID=0;
    private int numberOfOperation;

    public  Konto()
    {
        accountNumber = String.format("%1$03d", accountID);
        ownerName="No Name";
        balance=0;
        numberOfOperation=0;
        accountID++;
    }

    public Konto(String ownerName , int balance){
        accountNumber = String.format("%1$03d", accountID);
        this.ownerName=ownerName;
        this.balance=balance;
        numberOfOperation=0;
        accountID++;
    }
    public Konto(String ownerName) {
        accountNumber = String.format("%1$03d", accountID);
        this.ownerName=ownerName;
        numberOfOperation=0;
        balance=0;
        accountID++;
    }

    public int getAccountID(){
        return accountID;
    }

    public String getacoountNumber(){
        return accountNumber;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public int getNumberOfOperation(){return numberOfOperation; }

    public void setAccountNumber(String accountNumber){
        this.accountNumber=accountNumber;
    }

    public void payment(int amount) throws IllegalArgumentException{

        if (amount<0)
        {
            throw new IllegalArgumentException("The amount can not be negative!");
        }
        else {
            balance += amount;
            numberOfOperation++;
        }
    }

    public void transfer(int amount, Konto account) throws Deficit, IllegalArgumentException
    {
        if (amount<0)
        {
            throw new IllegalArgumentException("The amount can not be negative!");
        }
        else if (amount>balance) {
            throw new Deficit();
        }
        else

        {
            balance -= amount;
            account.payment(amount);
            numberOfOperation++;
            account.numberOfOperation++;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Konto)) return false;

        Konto konto = (Konto) o;

        if (accountNumber != null ? !accountNumber.equals(konto.accountNumber) : konto.accountNumber != null)
            return false;
        return ownerName != null ? ownerName.equals(konto.ownerName) : konto.ownerName == null;
    }

    @Override
    public int hashCode() {
        int result = accountNumber != null ? accountNumber.hashCode() : 0;
        result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "This acoount belongs to "+ ownerName;
    }

    // this method let as to compere accounts for one way for example by number
    // ( if wen we wont to have few more options we have to implement Comparator

    @Override
    public int compareTo(Konto o) {
        int compareAccoutNumber = accountNumber.compareTo(o.accountNumber);
        return compareAccoutNumber;
    }
}
