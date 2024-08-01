#include <bits/stdc++.h>
using namespace std;

int n, L, m;
vector<vector<int>> adj;

int timer;
vector<int> tin, tout;
vector<vector<int>> up;

void dfs(int v, int p){
    tin[v] = ++timer;
    up[v][0] = p;
    for(int i=1; i<=L; i++){
        up[v][i] = up[up[v][i-1]][i-1];
    }
    for(int u: adj[v]){
        if(u!=p) dfs(u, v);
    }
    tout[v] = ++timer;
}

bool isAncestor(int u, int v) {
    return tin[u] <= tin[v] && tout[u] >= tout[v];
}

int lca(int u, int v){
    if(isAncestor(u, v)) return u;
    if(isAncestor(v, u)) return v;
    for(int i=L; i>=0; i--){
        if(!isAncestor(up[u][i], v)) u = up[u][i];
    }
    return up[u][0];
}

void preprocess(int root) {
    tin.resize(n);
    tout.resize(n);
    timer = 0;
    L = ceil(log2(n));
    // up.assign(n, vector<int>(L+1));
    // dfs(root, root);
}

int main() {
    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    adj.resize(n);

    for(int i=0; i<n-1; i++){
        int a, b; cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
   preprocess(1);
   cout << "here";

//     for(int i=0; i<m; i++){
//         int a, b; cin >> a >> b;
//         cout << lca(a, b) << endl;
//     }

}