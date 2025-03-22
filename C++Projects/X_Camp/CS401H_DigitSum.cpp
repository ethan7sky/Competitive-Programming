#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll dp[16][2][136];

ll calc(string s, int idx, int prevLimit, int sum) {

    if(idx==s.size()) return sum;

    if(dp[idx][prevLimit][sum] != -1) {
        return dp[idx][prevLimit][sum];
    }

    ll ans=0;
    int limit = prevLimit? 9:s[idx]-'0';

    for(int i=0; i<=limit; i++){
        ans += calc(s, idx+1, prevLimit || i<s[idx]-'0', sum+i);
    }

    dp[idx][prevLimit][sum] = ans;
    return ans;
}

void solve() {
    ll a, b; cin >> a >> b;
    memset(dp, -1, sizeof dp);

    if(a==0) {
        cout << calc(to_string(b), 0, 0, 0) << endl;
    }
    else{
        ll bAns = calc(to_string(b), 0, 0, 0);
        memset(dp, -1, sizeof dp);
        ll aAns = calc(to_string(a-1), 0, 0, 0);
        cout << bAns - aAns << endl;
    }
}


int main() {
    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t; cin >> t;
    while(t--) solve();

    return 0;
}