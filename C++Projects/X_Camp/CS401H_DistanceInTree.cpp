#include <bits/stdc++.h>

using namespace std;

const int M = 50000+1;
vector<int> adj[M];
int dp[M][501];
int n, k, ans=0;

void dfs(int node, int parent) {
    dp[node][0] = 1;
    for(int i: adj[node]){
        if(i==parent) continue;
        dfs(i, node);

        for(int j=0; j<k; j++){
            ans += dp[i][j] * dp[node][k-j-1];
        }
        for(int j=1; j<=k; j++){
            dp[node][j] += dp[i][j-1];
        }
    }
}

int main() {
    // #ifndef ONLINE_JUDGE 
    // freopen("IO_SPACE/input.txt", "r", stdin); 
    // freopen("IO_SPACE/output.txt", "w", stdout); 
    // #endif

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> k;
    for(int i=0; i<n-1; i++){
        int a, b; cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    dfs(1, 0);

    cout << ans << "\n";
    return 0;
}
