#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MOD = 1e9+7;
const int OFFSET = 5e3;

const int MAX_N = 100;
const int MAX_X = 5000;

int main() {
    int n, x;
    cin >> n >> x;
    vector<int> a(n);
    for(int i=0; i<n; i++) cin >> a[i];
    sort(a.begin(), a.end());

    vector<vector<ll>> dp1(n+1, vector<ll>(x+OFFSET+1));
    vector<vector<ll>> dp2(n+1, vector<ll>(x+OFFSET+1));

    dp1[0][OFFSET] = 1;
    for(int i=0; i<n; i++){
        for(int j=0; j<=n-i; j++){
            for(int k=0; k<=x+OFFSET; k++) {
                if(dp1[j][k]>0) {
                    //solo group
                    dp2[j][k] += dp1[j][k];
                    //finish group
                    if(j>0 && k-OFFSET+a[i] <= x) {
                        dp2[j-1][k+a[i]] += j*dp1[j][k];
                    }
                    //start group
                    if(j+1 <= n-(i+1)) {
                        dp2[j+1][k-a[i]] += dp1[j][k];
                    }
                    //join unfinished group
                    if(j <= n-(i+1)) {
                        dp2[j][k] += j*dp1[j][k];
                    }
                }
            }
        }
        for(int j=0; j<n-i; j++){
            for(int k=0; k<=x+OFFSET; k++){
                dp1[j][k] = dp2[j][k] % MOD;
                dp2[j][k] = 0;
            }
        }
    }
    int ans=0;
    for(int i=OFFSET; i<=x+OFFSET; i++){
        ans += dp1[0][i];
        ans %= MOD;
    }
    cout << ans << '\n';
}

