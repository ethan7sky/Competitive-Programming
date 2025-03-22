#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 3*(int)1e4;

int N, M; 
vector<vector<int>> adj;
bool v[MAX_N+1];
vector<int> ans;

void dfs(int i);

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;

    adj.resize(N+1);
    for(int i=0; i<M; i++){
        int a, b; cin >> a >> b;
        adj[b].push_back(a);
    }

    for(int i=1; i<=N; i++){
        if(!v[i]) dfs(i);
    }

    for(int i=N-1; i>=0; i--) {
        cout << ans[i] << " ";
    }
}

void dfs(int i) {
    v[i] = true;
    for(auto c: adj[i]) {
        if(!v[c]) dfs(c);
    }
    ans.push_back(i);
}