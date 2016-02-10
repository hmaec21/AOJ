// AOJ 2424 "かけざん" (JAG夏合宿 2012 day 2 Problem A)
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            Set<Integer> is = new HashSet<Integer>();
            int count = 0;
            while (n >= 10) {
                count++;
                String tmp = Integer.toString(n);
                int max = 0;
                for (int j = 1; j < tmp.length(); j++) {
                    int n1 = Integer.parseInt(tmp.substring(0, j));
                    int n2 = Integer.parseInt(tmp.substring(j));
                    max = Math.max(max, n1 * n2);
                }
                n = max;
                if (!is.add(n)) {
                    count = -1;
                    break;
                }
            }
            
            System.out.println(count);
        }
    }
}
