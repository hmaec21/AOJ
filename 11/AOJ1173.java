// AOJ 1173 "世界の天秤" (ICPC国内予選 2011 Problem B)
import java.util.Scanner;
import java.util.Stack;

public class AOJ1173 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String s = sc.nextLine(); // 空白も考慮する(Scanner.next()はだめ)
            if (s.equals(".")) {
                break;
            }
            
            Stack<Character> st = new Stack<Character>();
            boolean isBalanced = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[') {
                    st.push(c);
                } else if (c == ')' || c == ']') {
                    if (st.empty()) {
                        isBalanced = false;
                        break;
                    }
                    char tmp = st.pop();
                    // 括弧が対応しているかどうか
                    if (!(c == ')' && tmp == '(') &&
                        !(c == ']' && tmp == '[')) {
                        isBalanced = false;
                        break;
                    }
                }
            }
            if (!st.empty()) {
                isBalanced = false;
            }
            
            if (isBalanced) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
