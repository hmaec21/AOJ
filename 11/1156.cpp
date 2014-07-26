#include <iostream>
#include <algorithm>

using namespace std;

const int INF = 10000000;
const int MAX_W = 30;
const int MAX_H = 30;
const int MAX_V = MAX_W * MAX_H * 4;

int field[MAX_H][MAX_W];
int cost[MAX_V][MAX_V];
int d[MAX_V];
bool used[MAX_V];
int V;

// 入力
int w, h;
int c[4];

void dijkstra(int s) {
	fill(d, d + V, INF);
	fill(used, used + V, false);
	d[s] = 0;
	
	while (true) {
		int v = -1;
		for (int u = 0; u < V; u++) {
			if (!used[u] && (v == -1 || d[u] < d[v])) {
				v = u;
			}
		}
		
		if (v == -1) {
			break;
		}
		
		used[v] = true;
		
		for (int u = 0; u < V; u++) {
			d[u] = min(d[u], d[v] + cost[v][u]);
		}
	}
	
	return;
}

void solve() {
	for (int i = 0; i < MAX_V; i++) {
		fill(cost[i], cost[i] + MAX_V, INF);
		cost[i][i] = 0;
	}
	for (int i = 0; i < V; i++) {
		int place = i / 4;
		int placex = place % w;
		int placey = place / w;
		int direction = i % 4;
		// 向きと次に進む方向で場合分け
		switch (direction) {
		case 0: // 右向きの場合
			if (placex == w - 1) {
			} else if (field[placey][placex] == 0) {
				cost[i][i+4] = 0;
			} else {
				cost[i][i+4] = c[0];
			}
			if (placey == h - 1) {
			} else if (field[placey][placex] == 1) {
				cost[i][i+4*w+1] = 0;
			} else {
				cost[i][i+4*w+1] = c[1];
			}
			if (placex == 0) {
			} else if (field[placey][placex] == 2) {
				cost[i][i-4+2] = 0;
			} else {
				cost[i][i-4+2] = c[2];
			}
			if (placey == 0) {
			} else if (field[placey][placex] == 3) {
				cost[i][i-4*w+3] = 0;
			} else {
				cost[i][i-4*w+3] = c[3];
			}
			break;
		case 1: // 下向きの場合
			if (placey == h - 1) {
			} else if (field[placey][placex] == 0) {
				cost[i][i+4*w] = 0;
			} else {
				cost[i][i+4*w] = c[0];
			}
			if (placex == 0) {
			} else if (field[placey][placex] == 1) {
				cost[i][i-4+1] = 0;
			} else {
				cost[i][i-4+1] = c[1];
			}
			if (placey == 0) {
			} else if (field[placey][placex] == 2) {
				cost[i][i-4*w+2] = 0;
			} else {
				cost[i][i-4*w+2] = c[2];
			}
			if (placex == w - 1) {
			} else if (field[placey][placex] == 3) {
				cost[i][i+4-1] = 0;
			} else {
				cost[i][i+4-1] = c[3];
			}
			break;
		case 2: // 左向きの場合
			if (placex == 0) {
			} else if (field[placey][placex] == 0) {
				cost[i][i-4] = 0;
			} else {
				cost[i][i-4] = c[0];
			}
			if (placey == 0) {
			} else if (field[placey][placex] == 1) {
				cost[i][i-4*w+1] = 0;
			} else {
				cost[i][i-4*w+1] = c[1];
			}
			if (placex == w - 1) {
			} else if (field[placey][placex] == 2) {
				cost[i][i+4-2] = 0;
			} else {
				cost[i][i+4-2] = c[2];
			}
			if (placey == h - 1) {
			} else if (field[placey][placex] == 3) {
				cost[i][i+4*w-1] = 0;
			} else {
				cost[i][i+4*w-1] = c[3];
			}
			break;
		case 3: // 上向きの場合
			if (placey == 0) {
			} else if (field[placey][placex] == 0) {
				cost[i][i-4*w] = 0;
			} else {
				cost[i][i-4*w] = c[0];
			}
			if (placex == w - 1) {
			} else if (field[placey][placex] == 1) {
				cost[i][i+4-3] = 0;
			} else {
				cost[i][i+4-3] = c[1];
			}
			if (placey == h - 1) {
			} else if (field[placey][placex] == 2) {
				cost[i][i+4*w-2] = 0;
			} else {
				cost[i][i+4*w-2] = c[2];
			}
			if (placex == 0) {
			} else if (field[placey][placex] == 3) {
				cost[i][i-4-1] = 0;
			} else {
				cost[i][i-4-1] = c[3];
			}
			break;
		}
	}
	dijkstra(0);
	int ans = min(d[4*(w*h-1)], d[4*(w*h-1)+1]);
	cout << ans << endl;
	
	return;
}

int main() {
	while (true) {
		cin >> w >> h;
		if (w == 0) {
			break;
		}
		V = w * h * 4;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				cin >> field[i][j];
			}
		}
		cin >> c[0] >> c[1] >> c[2] >> c[3];
		solve();
	}
	
	return 0;
}
