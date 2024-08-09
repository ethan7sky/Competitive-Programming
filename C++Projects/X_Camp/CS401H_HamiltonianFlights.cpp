#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAX_N = 20;
const ll MOD = 1e9+7;

ll dp[1 << MAX_N][MAX_N];
vector<int> arrivals[MAX_N];
int n, m;


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); 

    cin >> n >> m;

    for(int i=0; i<m; i++){
        int from, to; 
        cin >> from >> to;
        from--; to--;
        arrivals[to].push_back(from);
    }

    dp[1][0] = 1;
    for(int i=2; i<(1<<n); i++){
        if(!(i&1)) continue;
        if(i&(1<<(n-1)) && i!=(1<<n)-1) continue;
        for(int last=0; last<n; last++){
            if(i & (1<<last)){
                for(int from: arrivals[last]){
                    if(i&(1<<from)){
                        dp[i][last] += dp[i-(1<<last)][from];
                        dp[i][last] %= MOD;
                    }
                }

            }
        }
    }

    cout << dp[(1<<n)-1][n-1] << endl;
    return 0;
}