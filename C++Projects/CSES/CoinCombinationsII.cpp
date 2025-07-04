#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9+7;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, x; cin >> n >> x;
    vector<int> a(n);
    for(int i=0; i<n; i++){
        cin >> a[i];
    }
    vector<int> dp(x+1, -1);
    dp[0] = 1;

    for(int i=0; i<n; i++){
        for(int j=a[i]; j<=x; j++){
            if(dp[j-a[i]] != -1) {
                if(dp[j]==-1) dp[j]=0;
                dp[j] += dp[j-a[i]];
                dp[j] %= MOD;
            }
        }
    }
    if(dp[x]==-1) dp[x]=0;
    cout << dp[x] << "\n";
}