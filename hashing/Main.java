package hashing;

public class Main {


    private static int myHashCode(String value) {
        return 17;
    }

    public static void main(String[] args) {
        String msg = "Hoi, hashing with simple algorithm";
        System.out.println( msg.hashCode() );
        System.out.println( myHashCode(msg) );
    }
    
}
