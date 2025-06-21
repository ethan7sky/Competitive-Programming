// The Number of Pairs
#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAX_N = 2*1e7;
ll primeCnt[MAX_N+1];
ll max_div[MAX_N+1];

void sieve() {
    max_div[1] = 1;
    for(int i=2; i<=MAX_N; i++){
        if(max_div[i]==0) {
            for(int j=i; j<=MAX_N; j+=i) {
                max_div[j] = i;
            }
        }
    }
    for(int i=2; i<=MAX_N; i++) {
        int j = i/max_div[i];
        primeCnt[i] = primeCnt[j] + (max_div[i] != max_div[j]);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    sieve();

    ll t; cin >> t;
    while(t--) {
        ll c, d, x;
        cin >> c >> d >> x;
        ll ans = 0;
        for(int i=1; i*i<=x; i++) {
            if(x%i!=0) continue;
            int k1 = x/i+d;
            if(k1%c==0) {
                ans += (1LL << primeCnt[k1/c]); // 2^primeCnt
            }
            if(i*i==x) continue;
            int k2 = i+d;
            if(k2%c==0) {
                ans += (1LL << primeCnt[k2/c]); // 2^primeCnt
            }
        }
        cout << ans << "\n";
    }
}