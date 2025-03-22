#include <bits/stdc++.h>
using namespace std;

const int MAX_NM = 200000+10;
int n, m;
vector<array<int, 3>> adj[MAX_NM];
int layover[MAX_NM];
int minTime[MAX_NM];

void dfs(int i) {
    while(adj[i].size()>0 && adj[i].back()[0] >= minTime[i]+layover[i]) {
        auto tempAdj = adj[i].back(); adj[i].pop_back();
        minTime[tempAdj[1]] = min(minTime[tempAdj[1]], tempAdj[2]);
        dfs(tempAdj[1]);
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    for(int i=0; i<m; i++){
        int c, r, d, s; cin >> c >> r >> d >> s;
        adj[c].push_back({r, d, s});
    }for(int i=1; i<=n; i++){
        cin >> layover[i];
        sort(adj[i].begin(), adj[i].end());
        minTime[i] = INT_MAX-1e8;
    }
    minTime[1] = -layover[1];
    dfs(1);
    minTime[1] = 0;
    for(int i=1; i<=n; i++){
        if(minTime[i]==INT_MAX-1e8) cout << "-1\n";
        else cout << minTime[i] << "\n";
    }
}