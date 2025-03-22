#include <bits/stdc++.h>

using namespace std;
using ll = long long;

const ll INF = (ll)INT_MAX;

ll dp[10001][2]; //node id, 0/1
int m, v;
pair<int, int> gates[10001]; // and/or, can change
int leaf_nodes[10001];

void calc(int node) {
    if(node>m) return;
    if(node*2>m){
        dp[node][leaf_nodes[node]==1?1:0] = 0;
        return;
    }
    else{
        calc(node*2);
        calc(node*2+1);

        if(gates[node].first==1){ //and
            dp[node][1] = dp[node*2][1] + dp[node*2+1][1];
            dp[node][0] = min(dp[node*2][0]+dp[node*2+1][0], 
                min(dp[node*2][1]+dp[node*2+1][0], dp[node*2][0]+dp[node*2+1][1]));
        }
        else{ //or
            dp[node][1] = min(dp[node*2][1]+dp[node*2+1][1], 
                min(dp[node*2][1]+dp[node*2+1][0], dp[node*2][0]+dp[node*2+1][1]));
            dp[node][0] = dp[node*2][0]+dp[node*2+1][0];
            
        }

        if(gates[node].second==1){ //can change
            if(gates[node].first==1){ //and
                dp[node][1] = min(dp[node][1],
                    min(dp[node*2][1] + dp[node*2+1][0] + 1, dp[node*2][0] + dp[node*2+1][1] + 1));
            }
            else { //or
                dp[node][0] = min(dp[node][0], 
                    min(dp[node*2][1] + dp[node*2+1][0] + 1, dp[node*2][0] + dp[node*2+1][1] + 1));
            }
        }

        dp[node][1] = min(dp[node][1], INF);
        dp[node][0] = min(dp[node][0], INF);
    }
}

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t; cin >> t;
    for(int test=1; test<=t; test++){
        cin >> m >> v;

        for(int i=1; i<=m; i++){
            dp[i][1] = INF;
            dp[i][0] = INF;
        }
        
        for(int i=1; i<=m; i++){
            if(i<=(m-1)/2){
                int g, c; cin >> g >> c;
                gates[i] = make_pair(g, c);
            }
            else{
                int x; cin >> x;
                leaf_nodes[i] = x;
            }
        }

        calc(1);

        cout << "Case #" << test << ": ";

        if(v==1) {
            if(dp[1][1] == INF) cout << "IMPOSSIBLE" << endl;
            else cout << dp[1][1] << endl;
        }
        else {
            if(dp[1][0] == INF) cout << "IMPOSSIBLE" << endl;
            else cout << dp[1][0] << endl;
        }
    }

}