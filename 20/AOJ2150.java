// AOJ 2150 "Matsuzaki Number" (ICPC模擬国内予選 2009 Problem B)
import java.util.Scanner;
import java.util.BitSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AOJ2150 {
    static BitSet isNotPrime; // 素数でないならtrue
    static ArrayList<Integer> primeList;
    static final int MAX_N = 250000; // 素数表の上限
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        isNotPrime = new BitSet();
        primeList = new ArrayList<Integer>();
        sieve();
        
        while (true) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            if (n == -1) {
                break;
            }
            
            ArrayList<Integer> result = new ArrayList<Integer>();
            List<Integer> tmp;
            int pos = 0;
            while (primeList.get(pos) <= n) {
                pos++;
            }
            tmp = primeList.subList(pos, pos + 100); // nより大きい素数を小さい方から100個とる
            for (int i = 0; i < tmp.size(); i++) {
                for (int j = i; j < tmp.size(); j++) {
                    result.add(tmp.get(i) + tmp.get(j));
                }
            }
            Collections.sort(result);
            System.out.println(result.get(p - 1));
        }
    }
    
    // ここのsieveはふるいにかけると同時に、素数だけのリストを生成する
    public static void sieve() {
        isNotPrime.set(0);
        isNotPrime.set(1);
        for (int i = 2; i < MAX_N; i++) {
            if (!isNotPrime.get(i)) {
                primeList.add(i);
                for (int j = i * 2; j <= MAX_N * 2; j += i) {
                    isNotPrime.set(j);
                }
            }
        }
    }
}
