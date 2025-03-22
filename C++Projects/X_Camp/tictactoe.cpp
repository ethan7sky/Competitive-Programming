#include <bits/stdc++.h>
using namespace std;

int ans1 = 0, ans2 = 0;

void uniqueCnt(char x, char y, char z) {
    set<char> set;
    set.insert(x);
    set.insert(y);
    set.insert(z);
    if(set.size()==1) ans1++;
    if(set.size()==2) ans2++;
}

int main() {

    /*
    abc
    def
    ghi
    */

   char a, b, c, d, e, f, g, h, i;
   cin >> a >> b >> c >> d >> e >> f >> g >> h >> i;

    uniqueCnt(a, b, c);
    uniqueCnt(d, e, f);
    uniqueCnt(g, h, i);
    uniqueCnt(a, d, g);
    uniqueCnt(b, e, h);
    uniqueCnt(c, f, i);
    uniqueCnt(a, e, i);
    uniqueCnt(c, e, g);

    cout << ans1 << endl << ans2 << endl;
}