// AOJ 1276 "Prime Gap" (ICPCアジア地区予選 2007 東京大会 Problem B)
import java.util.Scanner;
import java.util.BitSet;
import java.util.ArrayList;

public class Main {
    static BitSet isNotPrime; // 素数でないならtrue
    static ArrayList<Integer> primeList;
    static final int MAX_N = 1299709;
    
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
            
            if (!isNotPrime.get(n)) {
                System.out.println(0);
            } else {
                int pos = 0;
                while (primeList.get(pos) < n) {
                    pos++;
                }
                System.out.println(primeList.get(pos) - primeList.get(pos - 1));
            }
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
