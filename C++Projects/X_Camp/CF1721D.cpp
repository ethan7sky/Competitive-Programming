#include <bits/stdc++.h>
using namespace std;

int T, N;
vector<int> a, b;

int calc(int lastBit, vector<int>& a, vector<int>& b, int sz) {
    if(lastBit<0 || sz<=0) return 0;
    
    int aCnt = 0, bCnt = 0;
    int comp = 1<<lastBit;

    for(int i: a) if(comp & i) aCnt++;
    for(int i: b) if(comp & i) bCnt++;
    
    int sum = 0;

    if(aCnt + bCnt == sz) {

        vector<int> a0, b0, a1, b1;

        for(int i: a) {
            if(comp & i) a1.push_back(i);
            else a0.push_back(i);
        }
        
        for(int i: b) {
            if(comp & i) b1.push_back(i);
            else b0.push_back(i);
        }

        sum |= comp;

        // cout << comp << " " << aCnt << " " << bCnt << " " << sz << endl;
        int x = calc(lastBit-1, a1, b0, aCnt);
        int y = calc(lastBit-1, a0, b1, bCnt);

        // cout << x << " " << y << endl;
        sum |= x & y;
    }
    
    return max(sum, calc(lastBit-1, a, b, sz));
}

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while(T--) {
        cin >> N;
        
        a.clear(); b.clear();
        
        for(int i=0; i<N; i++) {int x; cin >> x; a.push_back(x);}
        for(int i=0; i<N; i++) {int x; cin >> x; b.push_back(x);}


        int ans = calc(30, a, b, N);
        cout << ans << endl;
    }
}