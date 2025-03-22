#include <bits/stdc++.h>
using namespace std;

int n;
vector<vector<int>> adj;
double ans=0.0; //long double ? :O

void dfs(int p, int c, int d);

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    adj.resize(n+1);
    for(int i=0; i<n-1; i++){
        int a, b; cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    dfs(-1, 1, 1);
    cout << ans << endl;
}

void dfs(int p, int c, int d) {

    ans += (double)1.0/d;

    for(int i: adj[c]) {
        if(i==p) continue;
        dfs(c, i, d+1);
    }
}