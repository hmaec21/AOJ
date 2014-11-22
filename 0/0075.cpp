#include <cstdio>

using namespace std;

const double LIMIT = 25;

bool bmi(double weight, double hight) {
    if ((weight / (hight * hight)) >= LIMIT) {
        return true;
    } else {
        return false;
    }
}

int main() {
    int student_num;
    double weight;
    double hight;
    while (scanf("%d,%lf,%lf", &student_num, &weight, &hight) != EOF) {
        if (bmi(weight, hight)) {
            printf("%d\n", student_num);
        }
    }
    
    return 0;
}
