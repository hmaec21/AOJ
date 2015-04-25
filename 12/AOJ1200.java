// AOJ 1200 "Goldbach's Conjecture" (ICPCアジア地区予選 1998 東京大会 Problem A)
import java.util.Scanner;
import java.util.BitSet;
import java.util.ArrayList;

public class AOJ1200 {
    static BitSet isNotPrime; // 素数でないならtrue
    static ArrayList<Integer> primeList;
    static final int MAX_N = 65535;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        isNotPrime = new BitSet(MAX_N);
        primeList = new ArrayList<Integer>();
        sieve();
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int ans = 0;
            for (int i = 0; primeList.get(i) <= n / 2; i++) {
                if (!isNotPrime.get(n - primeList.get(i))) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
    
    // ここのsieveはふるいにかけると同時に、素数だけのリストを生成する
    public static void sieve() {
        isNotPrime.set(0);
        isNotPrime.set(1);
        for (int i = 2; i <= MAX_N; i++) {
            if (!isNotPrime.get(i)) {
                primeList.add(i);
                for (int j = i * 2; j <= MAX_N * 2; j += i) {
                    isNotPrime.set(j);
                }
            }
        }
    }

}
