#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int cnt_exp_2(int n) {
    int cnt = 0;
    if(n==0) return 0;
    while(n%2==0) {
        n/=2;
        cnt++;
    }
    return cnt;
}

//7th row of pascal's triangle: 
// 1 7 21 35 35 21 7 1

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n; cin >> n;
    int exp2 = 0;
    int ans = 0;
    n--;
    for(int i=0; i<=n; i++){
        int x; cin >> x;
        if(exp2==0) {
            // cout << x << endl;
            ans ^= x;
        }
        exp2 += cnt_exp_2(n-i);
        exp2 -= cnt_exp_2(i+1);
    }
    cout << ans;
}