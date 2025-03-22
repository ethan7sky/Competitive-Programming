#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MOD = 998244353;

ll dp[41][41][41][10]; //idx, top, bottom, min digit
int n, m;
char s[40][40];

ll calc(int idx, int top, int bottom, int minDigit) {

    if(top==bottom) return 1;
    if(minDigit>9) return 0;
    if(idx==m){
        if(top+1==bottom) return 1;
        else return 0;
    }
    if(dp[idx][top][bottom][minDigit] == -1){
        dp[idx][top][bottom][minDigit] = 0 + calc(idx, top, bottom, minDigit+1)%MOD;
        int k=top;
        while(k<bottom && (s[k][idx]=='?' || s[k][idx]-'0' == minDigit)){
            dp[idx][top][bottom][minDigit] += (calc(idx+1, top, k+1, 0) * calc(idx, k+1, bottom, minDigit+1))%MOD; 
            dp[idx][top][bottom][minDigit] %= MOD;
            k++;  
        }
    }
    return dp[idx][top][bottom][minDigit];
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;

    memset(dp, -1, sizeof(dp));

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> s[i][j];
        }
    }

    cout << calc(0, 0, n, 0) << endl;
}