// AOJ 1346 "Miscalculation" (ICPCアジア地区予選 2014 東京大会 Problem B)
import java.util.Scanner;

public class AOJ1346 {
    static int pos = 0; // 四則演算の構文解析における現在位置
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        int ansOfBob = sc.nextInt();
        
        int ansMulFirst = evalMulFirst(s);
        int ansLeftToRight = evalLeftToRight(s);
        
        if (ansOfBob == ansMulFirst && ansOfBob == ansLeftToRight) {
            System.out.println("U");
        } else if (ansOfBob == ansMulFirst) {
            System.out.println("M");
        } else if (ansOfBob == ansLeftToRight) {
            System.out.println("L");
        } else {
            System.out.println("I");
        }
    }
    
    public static int evalMulFirst(String s) {
        int ans = evalMul(s);
        while (pos < s.length()) {
            pos++;
            ans += evalMul(s);
        }
        return ans;
    }
    
    private static int evalMul(String s) {
        int ans = evalFactor(s);
        while (pos < s.length() && s.charAt(pos) == '*') {
            pos++;
            int b = evalFactor(s);
            ans *= b;
        }
        
        return ans;
    }
    
    private static int evalFactor(String s) {
        int num = s.charAt(pos) - '0';
        pos++;
        return num;
    }
    
    public static int evalLeftToRight(String s) {
        int ans = s.charAt(0) - '0'; // 最初の文字を足す
        for (int i = 1; i < s.length(); i += 2) {
            char c = s.charAt(i);
            if (c == '+') {
                ans += s.charAt(i + 1) - '0';
            } else {
                ans *= s.charAt(i + 1) - '0';
            }
        }
        
        return ans;
    }
}
