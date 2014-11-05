import java.util.Scanner;

public class AOJ2006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] c = {{},
            {'.', ',', '!', '?', ' '},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            StringBuffer ans = new StringBuffer();
            int count = 0; // 確定ボタンを押すまでに他のボタンを押した回数
            int num = 0; // 何番のボタンを押したか (1-9)
            for (int j = 0; j < s.length(); j++) {
                int tmp = s.charAt(j) - '0';
                if (tmp == 0) {
                    if (count > 0) {
                        ans.append(c[num][(count-1)%c[num].length]);
                    }
                    count = 0;
                    num = 0;
                } else {
                    count++;
                    num = tmp;
                }
            }
            System.out.println(ans);
        }
    }
}
