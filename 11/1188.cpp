#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

struct Node {
	vector<Node> children; // この選挙区に属する前の段階の選挙区
	int minvote; // この選挙区で勝つために必要な最小限の得票数
	
	Node() {
		minvote = 0;
	}
};

int vote(Node node) {
	if (node.children.empty()) {
		return node.minvote;
	}
	vector<int> nums;
	for (int i = 0; i < (int)node.children.size(); i++) {
		if (node.children[i].minvote == 0) {
			nums.push_back(vote(node.children[i]));
		} else {
			nums.push_back(node.children[i].minvote);
		}
	}
	sort(nums.begin(), nums.end());
	int minvote = 0;
	for (int i = 0; i < ((int)nums.size() + 1) / 2; i++) {
		minvote += nums[i];
	}
	node.minvote = minvote;
	
	return node.minvote;
}

Node parse(string s) {
	/*
	木を作って再帰
	プロジェクトでやった、XMLパーサと似ているかもしれない
	*/
	Node root;
	stack<Node> tmp;
	int num = 0;
	for (int i = 0; i < (int)s.length(); i++) {
		if (s.at(i) == '[') {
			// startElement
			Node node;
			tmp.push(node);
		} else if (s.at(i) == ']') {
			// endElement
			// 得票数を計算した後、numを0にリセット
			num = (num + 1) / 2;
			Node child;
			child = tmp.top();
			tmp.pop();
			child.minvote = num;
			//cout << child.minvote << endl;
			if (!tmp.empty()) {
				Node parent;
				parent = tmp.top();
				tmp.pop();
				parent.children.push_back(child);
				tmp.push(parent);
			} else {
				root = child;
			}
			
			num = 0;
		} else {
			// characters
			// ここは数字を読んだ時にしか呼び出されないはず
			/*
			if (!('0' <= s.at(i) && s.at(i) <= '9')) {
				cout << "入力がおかしいようです。" << endl;
			}
			*/
			num *= 10;
			num += s.at(i) - '0';
		}
	}
	
	return root;
}

int main() {
	int n;
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		Node node = parse(s);
		cout << vote(node) << endl;
		//cout << node.children.size() << endl;
	}
	
	return 0;
}
