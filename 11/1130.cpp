#include <iostream>
#include <cstring>
#include <string>

using namespace std;

const int MAX_H = 20;
const int MAX_W = 20;

// 入力
int W, H;
char field[MAX_H][MAX_W+1]; // ヌル文字を考慮
int startx, starty;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

void dfs(int x, int y) {
	field[y][x] = '$';
	for (int i = 0; i < 4; i++) {
		int newX = x + dx[i];
		int newY = y + dy[i];
		if (field[newY][newX] == '.') {
			dfs(newX, newY);
		}
	}
}

int main() {
	while (true) {
		cin >> W >> H;
		if (W == 0) {
			break;
		}
		
		memset(field, 0, sizeof(field));
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				cin >> field[i][j];
				if (field[i][j] == '@') {
					startx = j;
					starty = i;
				}
			}
		}
		
		dfs(startx, starty);
		
		int ans = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (field[i][j] == '$') {
					ans++;
				}
			}
		}
		cout << ans << endl;
	}
	
	return 0;
}
