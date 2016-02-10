// AOJ 1100 "Area of Polygons" (ICPC国内予選 1998 Problem 1)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numOfSet = 0;
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            numOfSet++;
            double area = 0.0;
            Vektor[] v = new Vektor[n];
            
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                v[i] = new Vektor(x, y, 0);
                
                if (i > 0) {
                    area += v[i-1].exteriorProduct(v[i]).z;
                }
            }
            area += v[v.length-1].exteriorProduct(v[0]).z;
            area /= 2;
            System.out.println(numOfSet + " " + Math.abs(area));
        }
    }
}

// 3次元ベクトルを表すクラス(可変長配列のVectorとの混同を避けるため、ドイツ語)
class Vektor {
    int x;
    int y;
    int z;
    
    public Vektor(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    // このベクトルaと引数のベクトルvの外積axvを返すメソッド
    public Vektor exteriorProduct(Vektor v) {
        int x = this.y * v.z - this.z * v.y;
        int y = this.z * v.x - this.x * v.z;
        int z = this.x * v.y - this.y * v.x;
        
        return new Vektor(x, y, z);
    }
}
