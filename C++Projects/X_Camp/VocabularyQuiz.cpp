#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1e6+5;

set<int> adj[MAX_N];
int parent[MAX_N], depth[MAX_N];
int leafCnt = 0;

void dfs(int n, int d) {
    // cout << n << endl;
    depth[n] = d;
    d++;
    for(int c: adj[n]) {
        dfs(c, d);
    }
    if(adj[n].size()==0) leafCnt++;
}

int main() {
    cin.tie(0) -> sync_with_stdio(0);
    int n; cin >> n;
    for(int i=1; i<=n; i++){
        int p; cin >> p;
        adj[p].insert(i);
        parent[i] = p;
    }
    // cout << "HERE" << endl;
    depth[0] = 0;
    dfs(0, 0);

    // cout << leafCnt << endl;
    
    while(leafCnt--) {
        int node; cin >> node;
        while(node != 0 && adj[parent[node]].size()==1) {
            node = parent[node];
        }
        adj[parent[node]].erase(node);
        cout << depth[node] << "\n";
    }
}