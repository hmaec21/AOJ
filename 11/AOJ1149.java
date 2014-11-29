import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class AOJ1149 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
        int n, w, d;
        n = sc.nextInt();
        w = sc.nextInt();
        d = sc.nextInt();
        if (w == 0) {
        break;
        }
        
        ArrayList<Cake> pieces = new ArrayList<Cake>();
        Cake c = new Cake(w, d);
        pieces.add(c);
        
        for (int i = 0; i < n; i++) {
        int p, s;
        p = sc.nextInt();
        s = sc.nextInt();
        Cake piece = pieces.get(p - 1);
        pieces.remove(p - 1);
        s = s % (piece.w + piece.w + piece.d + piece.d);
        int tmpw, tmpd, tmpw2, tmpd2;
        if (s < piece.w) {
            tmpw = s;
            tmpd2 = tmpd = piece.d;
            tmpw2 = piece.w - tmpw;
        } else if (s < piece.w + piece.d) {
            tmpw2 = tmpw = piece.w;
            tmpd = s - piece.w;
            tmpd2 = piece.d - tmpd;
        } else if (s < piece.w + piece.w + piece.d) {
            tmpw = s - piece.w - piece.d;
            tmpd2 = tmpd = piece.d;
            tmpw2 = piece.w - tmpw;
        } else {
            tmpw2 = tmpw = piece.w;
            tmpd = s - piece.w - piece.w - piece.d;
            tmpd2 = piece.d - tmpd;
        }
        //System.out.println(tmpw + " " + tmpd);
        //System.out.println(tmpw2 + " " + tmpd2);
        Cake tmp1 = new Cake(tmpw, tmpd);
        Cake tmp2 = new Cake(tmpw2, tmpd2);
        
        if (tmp1.area < tmp2.area) {
            pieces.add(tmp1);
            pieces.add(tmp2);
        } else {
            pieces.add(tmp2);
            pieces.add(tmp1);
        }
        }
        
        Collections.sort(pieces, new CakeSort());
        for (int i = 0; i < pieces.size(); i++) {
        if (i != 0) {
            System.out.print(" ");
        }
        System.out.print(pieces.get(i));
        }
        System.out.println();
    }
    }
}

class Cake {
    int w;
    int d;
    int area;
    
    Cake(int w, int d) {
    this.w = w;
    this.d = d;
    this.area = w * d;
    }
    
    public String toString() {
    return Integer.toString(area);
    }
}

class CakeSort implements Comparator<Cake> {
    public int compare(Cake a, Cake b) {
    return a.area - b.area;
    }
}
