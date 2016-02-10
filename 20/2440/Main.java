// AOJ 2440 "Kagisys" (JAG夏合宿 2012 day 3B Problem A)
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> registerID = new ArrayList<String>();
        boolean isClose = true;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String u = sc.next();
            registerID.add(u);
        }
        Collections.sort(registerID);
        
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String t = sc.next();
            if (Collections.binarySearch(registerID, t) >= 0) {
                if (isClose) {
                    System.out.println("Opened by " + t);
                    isClose = false;
                } else {
                    System.out.println("Closed by " + t);
                    isClose = true;
                }
            } else {
                System.out.println("Unknown " + t);
            }
        }
    }
}
