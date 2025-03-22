#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const ll MOD = 998244353;
ll dp[3001][3000]; // idx, number of open so far.

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string s; cin >> s;
    int len = s.length();

    if(s[0]=='?' || s[0]=='(') dp[0][1] = 1;
    else{
        cout << 0;
        return 0;
    }

    // cout << dp[0][0] << "  " << dp[0][1] << endl;

    for(int i=1; i<len; i++){
        
        if(s[i] == '('){
            for(int open=0; open<=i; open++){
                dp[i][open+1] = dp[i-1][open];
            }
        }
        else if(s[i] == ')'){
            for(int open=1; open<=i; open++){
                dp[i][open-1] = dp[i-1][open];
            }
        }
        else{
            dp[i][0] += dp[i-1][1]; dp[i][0] %= MOD;
            for(int open=1; open<=i+1; open++){
                dp[i][open] += dp[i-1][open-1] + dp[i-1][open+1];
                dp[i][open] %= MOD;
            }
        }

        // for(int j=0; j<=i+1; j++){
        //     cout << dp[i][j] << " ";
        // }cout << endl;
    }

    cout << dp[len-1][0] << endl;
}