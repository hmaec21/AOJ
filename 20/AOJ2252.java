// AOJ 2252 "koukyoukoukokukikou" (ICPC模擬国内予選 2011 Problem A)
import java.util.Scanner;
import java.util.Arrays;

public class AOJ2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String s = sc.next();
            if (s.equals("#")) {
                break;
            }
            
            int ans = solve(s);
            System.out.println(ans);
        }
    }
    
    public static int solve(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            boolean a = isLeftHand(s.charAt(i));
            boolean b = isLeftHand(s.charAt(i - 1));
            if (a && !b || !a && b) {
                // i文字目とi-1文字目で打つ手が異なればカウント
                ans++;
            }
        }
        
        return ans;
    }
    
    /* qwerty配列で、ある英小文字が左手で打つものならtrue、そうでないならfalse */
    public static boolean isLeftHand(char c) {
        char[] cArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
                         'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
        int tmp = Arrays.binarySearch(cArray, c);
        if (tmp >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
