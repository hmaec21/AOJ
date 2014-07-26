// https://gist.github.com/draftcode/1357281 を参考にした
// キーボード入力とファイルからの入力で結果が異なっているのは，改行コードのせい
#include <iostream>
#include <string>
#include <cctype>

using namespace std;
typedef string::const_iterator State;

class ParseError{};

void consume(State &begin, char expected);
int expression(State &begin);
int term(State &begin);
int factor(State &begin);
int number(State &begin);

// beginがexpectedを指していたらbeginを一つ進める。
void consume(State &begin, char expected) {
	if (*begin == expected) {
		begin++;
	} else {
		cerr << "Expected '" << expected << "' but got '" << *begin << "'"
			<< endl;
		cerr << "Rest string is '";
		while (*begin) {
			cerr << *begin++;
		}
		cerr << "'" << endl;
		throw ParseError();
	}
}

// 四則演算の式をパースして，その評価結果を返す．
int expression(State &begin) {
	int ret = term(begin);
	
	while (true) {
		if (*begin == '+') {
			begin++;
			ret += term(begin);
		} else if (*begin == '-') {
			begin++;
			ret -= term(begin);
		} else {
			break;
		}
	}
	
	return ret;
}

// 乗算除算の式をパースして，その評価結果を返す．
int term(State &begin) {
	//int ret = number(begin);
	int ret = factor(begin); // 括弧がある式に対応
	
	while (true) {
		if (*begin == '*') {
			begin++;
			//ret *= number(begin);
			ret *= factor(begin); // 括弧がある式に対応
		} else if (*begin == '/') {
			begin++;
			//ret /= number(begin);
			ret /= factor(begin); // 括弧がある式に対応
		} else {
			break;
		}
	}
	
	return ret;
}

// 括弧か数をパースして，その評価結果を返す．
int factor(State &begin) {
	if (*begin == '(') {
		begin++; // '('を飛ばす．
		int ret = expression(begin);
		begin++; // ')'を飛ばす．
		return ret;
	} else {
		return number(begin);
	}
}

// 数字の列をパースして，その数を返す．
int number(State &begin) {
	int ret = 0;
	
	while (isdigit(*begin)) {
		ret *= 10;
		ret += *begin - '0';
		begin++;
	}
	
	return ret;
}

int main() {
	int n;
	cin >> n;
	cin.ignore();
	for (int i = 0; i < n; i++) {
		string s;
		getline(cin, s);
		
		State begin = s.begin();
		int ans = expression(begin);
		consume(begin, '=');
		cout << ans << endl;
	}
	
	return 0;
}
