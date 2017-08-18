import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Maciek on 07.08.2017.
 */
public class Deficit extends Exception {
    public  Deficit(){
        System.err.println("You haven't got enough money.");
    }
    public Deficit(String msg){
        super(msg);
    }
}
