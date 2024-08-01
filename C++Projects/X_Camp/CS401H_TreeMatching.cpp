#include <bits/stdc++.h>
using namespace std;

const int M = 2*10e5+1;
int dp[M][2];
vector<int> adj[M];

void dfs(int node , int parent) {
    dp[node][0] = 0;
    dp[node][1] = -M;
    for(int v : adj[node]){
        if(v!=parent){
            dfs(v, node);
            dp[node][0] += max(dp[v][0], dp[v][1]);
            int temp = min(dp[v][0]-dp[v][1], 0);
            dp[node][1] = max(dp[node][1], temp);
        }
    }
    dp[node][1] += dp[node][0]+1;
}

int main(){
    int n; cin >> n;
    for(int i=1; i<n; i++){
        int a, b; cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    dfs(1, -1);
    cout << max(dp[1][0], dp[1][1]);
}