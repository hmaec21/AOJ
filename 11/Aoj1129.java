import java.util.Scanner;
import java.util.ArrayList;

public class Aoj1129 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			if (n == 0) {
				break;
			}
			
			// 花札の束、0番目が一番上
			ArrayList<Integer> cards = new ArrayList<Integer>();
			for (int i = n; i >= 1; i--) {
				cards.add(i);
			}
			
			for (int i = 0; i < r; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();
				
				// 札を抜いて一番上に積む
				for (int j = 0; j < c; j++) {
					int k = cards.remove(p - 1 + c - 1);
					cards.add(0, k);
				}
			}
			System.out.println(cards.get(0));
		}
	}
}
