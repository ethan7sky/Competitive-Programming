#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m; cin >> n >> m;
    vector<int> adj(n);
    for(int i=0; i<m; i++){
        int u, v; cin >> u >> v;
        u--; v--;
        adj[u] |= 1<<v;
        adj[v] |= 1<<u;
    }
    vector<int> dp(1<<n, INT_MAX);
    for(int mask=0; mask<(1<<n); mask++){
        bool complete = true;
        for(int j=0; j<n; j++){
            if((mask&(1<<j))!=0) {
                if(((adj[j]|(1<<j))&mask)!=mask){
                    complete = false;
                    break;
                }
            }
        }
        if(complete) dp[mask] = 1;
    }
    for(int mask=0; mask<(1<<n); mask++){
        for(int submask=mask; submask!=0; submask=(submask-1)&mask) {
            int subset = submask^mask;
            if(dp[submask]!=INT_MAX&&dp[subset]!=INT_MAX){
                dp[mask] = min(dp[mask], dp[subset]+dp[submask]);
            }
        }
    }
    cout << (dp[(1<<n)-1]);
}
