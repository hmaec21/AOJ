// AOJ 1153 "等しい合計点" (ICPC国内予選 2008 Problem A)
import java.util.Scanner;

public class AOJ1153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int[] taro = new int[n];
            int[] hanako = new int[m];
            int taroSum = 0;
            int hanakoSum = 0;
            for (int i = 0; i < n; i++) {
                taro[i] = sc.nextInt();
                taroSum += taro[i];
            }
            for (int i = 0; i < m; i++) {
                hanako[i] = sc.nextInt();
                hanakoSum += hanako[i];
            }
            
            // 太郎と花子のカードを1枚ずつ交換することを全通り試す
            int ansTaro = -1;   // 太郎が渡すカードの点数
            int ansHanako = -1; // 花子が渡すカードの点数
            int sum = 999;      // 渡すカードの点数の合計(初期値は適当に大きい数)
            boolean isChanged = false; // 交換したかどうか
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    taroSum = taroSum - taro[i] + hanako[j];
                    hanakoSum = hanakoSum - hanako[j] + taro[i];
                    if (taroSum == hanakoSum) {
                        if (taro[i] + hanako[j] < sum) {
                            ansTaro = taro[i];
                            ansHanako = hanako[j];
                            sum = taro[i] + hanako[j];
                        }
                        isChanged = true;
                    }
                    taroSum = taroSum - hanako[j] + taro[i];
                    hanakoSum = hanakoSum - taro[i] + hanako[j];
                }
            }
            
            if (isChanged) {
                System.out.println(ansTaro + " " + ansHanako);
            } else {
                System.out.println(-1);
            }
        }
    }
}
