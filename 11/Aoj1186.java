import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Aoj1186 {
    static final int MAX_LENGTH = 150; // 幅と高さの上限

    public static void main(String[] args) {
	final int MAX_LENGTH = 150;
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Square> squares = new ArrayList<Square>();
	
	// iは高さ、jは幅
	for (int i = 1; i <= MAX_LENGTH; i++) {
	    for (int j = i + 1; j <= MAX_LENGTH; j++) {
		Square s = new Square(i, j);
		squares.add(s);
	    }
	}
	Collections.sort(squares, new SquareComp());

	
	while (true) {
	    int h = sc.nextInt();
	    int w = sc.nextInt();
	    if (h == 0) {
		break;
	    }
	    
	    int diagonal = diagSquare(h, w); // 入力した長方形の対角線の長さの2乗
	    Square tmp = new Square(h, w);
	    
	    // 方法1. 素直に総当たりする
	    //all(h, w, diagonal);
	    
	    // 方法2. ソートして2分探索
	    binary(squares, tmp);
	}
    }
    
    public static int diagSquare(int h, int w) {
	return h * h + w * w;
    }
    
    public static void all(int h, int w, int diagonal) {
	// iは高さ、jは幅
	int resultH = 0;
	int resultW = 0;
	int resultD = Integer.MAX_VALUE;
	
	// iは高さ、jは幅
	for (int i = 1; i <= MAX_LENGTH; i++) {
	    for (int j = i + 1; j <= MAX_LENGTH; j++) {
		int diagonalT = diagSquare(i, j);
		// データセットより大きい長方形のみ対象
		if (diagonal < diagonalT || diagonal == diagonalT && h < i) {
		    // 今までの結果より小さければ結果を更新
		    if (diagonalT < resultD || diagonalT == resultD && i < resultH) {
			resultH = i;
			resultW = j;
			resultD = diagonalT;
		    }
		}
	    }
	}
	System.out.println(resultH + " " + resultW);
    }
    
    public static void binary(ArrayList<Square> squares, Square tmp) {
	
	int n = Collections.binarySearch(squares, tmp, new SquareComp());
	Square ans = squares.get(n+1);
	System.out.println(ans.h + " " + ans.w);
	
	/*
	for (int i = 0; i < squares.size(); i++) {
	    System.out.println(squares.get(i));
	}
	*/
    }
}

class Square {
    int h;
    int w;
    int diagonal;
    
    public Square(int h, int w) {
	this.h = h;
	this.w = w;
	this.diagonal = h * h + w * w;
    }
    
    public boolean equals(Square a) {
	return a.h == this.h && a.w == this.w;
    }
    
    public String toString() {
	return "(" + h + " " + w + " " + diagonal + ")";
    }
}

class SquareComp implements Comparator<Square> {
    public int compare(Square a, Square b) {
	if (a.diagonal < b.diagonal || a.diagonal == b.diagonal && a.h < b.h) {
	    return -1;
	} else if (a.equals(b)) {
	    return 0;
	} else {
	    return 1;
	}
    }
}
