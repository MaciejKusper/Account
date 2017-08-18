/**
 * Created by Maciek on 02.08.2017.
 */
public class InterestBearingAccount extends Konto {
    private double interest;

    InterestBearingAccount(){
        super();
        interest = 0;
    }
    InterestBearingAccount(String ownerName , int balance, double interest ){
        super(ownerName,balance);
        this.interest=interest;
    }
    public double getInterest(){
        return interest;
    }
    public double coutGain(int periodInMonth) {
        return getBalance()*(interest/100)*(periodInMonth/12);
    }

}
