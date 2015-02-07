// AOJ 1240 "Unreliable Messengers" (ICPCアジア地区予選 会津大会 2003 Problem A)
import java.util.Scanner;

public class AOJ1240 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String messenger = sc.next();
            StringBuffer message = new StringBuffer(sc.next());
            
            for (int j = messenger.length() - 1; j >= 0; j--) {
                char tmp;
                switch(messenger.charAt(j)) {
                case 'C':
                    tmp = message.charAt(0);
                    message.deleteCharAt(0);
                    message.append(tmp);
                    break;
                    
                case 'J':
                    tmp = message.charAt(message.length() - 1);
                    message.deleteCharAt(message.length() - 1);
                    message.insert(0, tmp);
                    break;
                    
                case 'E':
                    char tmp2;
                    int length = message.length();
                    String s1 = message.substring(0, length / 2);
                    String s2 = message.substring((length + 1) / 2);
                    tmp2 = message.charAt(length / 2);
                    message.delete(0, length);
                    message.append(s1);
                    if (length % 2 == 1) {
                        message.insert(0, tmp2);
                    }
                    message.insert(0, s2);
                    break;
                    
                case 'A':
                    message.reverse();
                    break;
                    
                case 'M':
                    for (int k = 0; k < message.length(); k++) {
                        tmp = message.charAt(k);
                        if ('0' <= tmp && tmp <= '8') {
                            tmp++;
                        } else if (tmp == '9') {
                            tmp = '0';
                        }
                        message.setCharAt(k, tmp);
                    }
                    break;
                    
                case 'P':
                    for (int k = 0; k < message.length(); k++) {
                        tmp = message.charAt(k);
                        if ('1' <= tmp && tmp <= '9') {
                            tmp--;
                        } else if (tmp == '0') {
                            tmp = '9';
                        }
                        message.setCharAt(k, tmp);
                    }
                    break;
                }
            }
            System.out.println(message);
        }
    }
}
