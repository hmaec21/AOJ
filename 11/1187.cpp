#include <iostream>
#include <algorithm>

using namespace std;

const int MAX_PROBLEM = 10; // 最大出題数
const int PENALTY     = 20; // 不正解1回毎のペナルティ

struct Team {
	int wa[MAX_PROBLEM+1]; // 各問題の不正解数
	int num; // チーム番号
	int ac;  // 正解数
	int pt;  // ペナルティタイム
};

// チーム番号に対して降順にソート
bool sort1(const Team& left, const Team& right) {
	return left.num > right.num;
}

// ペナルティタイムに対して昇順にソート
bool sort2(const Team& left, const Team& right) {
	return left.pt < right.pt;
}

// 正解数に対して降順にソート
bool sort3(const Team& left, const Team& right) {
	return left.ac > right.ac;
}

// 上記3つの関数を1つにまとめたもの
// ソート順位: 1.正解数(降順) 2.ペナルティタイム(昇順) 3.チーム番号(降順)
bool sort4(const Team& left, const Team& right) {
	if (left.ac == right.ac) {
		if (left.pt == right.pt) {
			return left.num > right.num;
		}
		return left.pt < right.pt;
	}
	return left.ac > right.ac;
}

int main() {
	while (true) {
		int m, t, p, r;
		cin >> m >> t >> p >> r;
		if (m == 0) {
			break;
		}
		Team te[t+1];
		for (int i = 0; i <= t; i++) {
			te[i].num = i;
			te[i].ac = te[i].pt = 0;
			for (int j = 0; j <= MAX_PROBLEM; j++) {
				te[i].wa[j] = 0;
			}
		}
		te[0].pt = 999999999; // 0番のチームを最下位にする
		
		for (int i = 0; i < r; i++) {
			int rm, rt, rp, rj;
			cin >> rm >> rt >> rp >> rj;
			if (rj == 0) {
				// Accepted!!
				te[rt].ac++;
				te[rt].pt += rm + PENALTY * te[rt].wa[rp];
			} else {
				// Wrong answer
				te[rt].wa[rp]++;
			}
		}
		
		//sort(te, te+t+1, sort1);
		//stable_sort(te, te+t+1, sort2);
		//stable_sort(te, te+t+1, sort3);
		sort(te, te+t+1, sort4);
		
		/*
		for (int i = 0; i < t; i++) {
			cout << "Team " << te[i].num << ":" << endl;
			cout << "ac: " << te[i].ac << endl;
			cout << "pt: " << te[i].pt << endl;
			cout << endl;
		}
		*/
		cout << te[0].num;
		for (int i = 1; i < t; i++) {
			// 自分より1つ上位のチームと結果が同じなら同順位
			if (te[i-1].ac == te[i].ac && te[i-1].pt == te[i].pt) {
				cout << "=";
			} else {
				cout << ",";
			}
			cout << te[i].num;
		}
		cout << endl;
	}
	
	return 0;
}
