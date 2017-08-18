import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Maciek on 02.08.2017.
 */
public class Home {
    public static void main(String[] args) throws Deficit {
        //I'm meaking few example accounts
        InterestBearingAccount Maciek = new InterestBearingAccount("Maciej Kusper", 2500, 2);
        InterestBearingAccount Basia = new InterestBearingAccount("Basia Kusper", 1000, 2);
        InterestBearingAccount Pawel = new InterestBearingAccount("Pawel Frantczak", 200, 2);
        InterestBearingAccount Franek = new InterestBearingAccount("Franek Z Białki", 25000, 2);
        //meking new list an adding elements
        List<InterestBearingAccount> list = new ArrayList<InterestBearingAccount>();
        list.add(Maciek);
        list.add(Basia);
        list.add(Franek);
        list.add(Pawel);
        System.out.println(list.toString()); // i use to string method
        Collections.sort(list); // i use compareble method to compare account by account number
        System.out.println(list.toString());
        Collections.sort(list, new ComparatorBalance());
        System.out.println(list.toString());
        InterestBearingAccount MaciekKopia= Maciek;
        Maciek.payment(1000);

        System.out.println(Maciek.getacoountNumber());
        System.out.println(MaciekKopia.getacoountNumber());
        System.out.println(Pawel.coutGain(12));
        // i try the equals method
        if( MaciekKopia.equals(Maciek)) {
            System.out.println("Te obiekty sa takie same");
        }
        System.out.println(Maciek.getNumberOfOperation());
        System.out.println(MaciekKopia.getNumberOfOperation());
       // Maciek.transfer(2000,Basia);
    }

    // comparator to comp
    private static class ComparatorBalance implements Comparator<Konto>{
        @Override
        public int compare(Konto o1, Konto o2) {
            int compareBalance = o1.getBalance() - o2.getBalance();
            if(compareBalance==0){
                return o1.compareTo(o2); // if we get the same balance we will compare it by account number (compereTo)
            }
            return compareBalance;
        }
    }
}
