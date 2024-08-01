#include <bits/stdc++.h>

using namespace std;

int main() {
    int k;
    cin >> k;
    cout << "100 133" << endl;
    int prev = 1000000;
    for(int i=0; i<17; i++) {
        int curr = i*4+1;
        cout << curr << " " << curr+1 << " " << prev << endl;
        cout << curr << " " << curr+2 << " 1" << endl;
        cout << curr+1 << " " << curr+2 << " 1" << endl;
        cout << curr+1 << " " << curr+3 << " 1" << endl;
        cout << curr << " "<<curr+3<<" " << prev/2 << endl;
        cout << curr+3 << " " << curr+4 << " 1" << endl;
        prev = prev/2-3;
    }
    for(int i = 69; i<=99; i++) {
        cout << i << " " << i+1 << " 1" << endl;
    }
}