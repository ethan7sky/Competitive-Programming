//misaka and rin will carry me to cm
#include <iostream>
#include <cstdio>
#include <cstring>
#include <utility>
#include <cassert>
#include <algorithm>
#include <vector>
#include <array>
#include <tuple>
 
#define ll long long
#define lb long double
#define sz(vec) ((int)(vec.size()))
#define all(x) x.begin(), x.end()
#define scam(v) sum[v] - dp[v] + arr[v]
const lb eps = 1e-9;
const ll mod = 1e9 + 7, ll_max = 1e18;
//const ll mod = (1 << (23)) * 119 +1;
const int MX = 1e5 +10, int_max = 0x3f3f3f3f;
 
using namespace std;
 
int n;
ll dp[MX], tot[MX], arr[MX], tim[MX], sum[MX];
//arr, time are input
//tot = sum_{v in child of u} arr[v]
//sum = sum_{v in child of u} dp[v]
//dp[u] best cost
vector<int> adj[MX];
 
//ll scam(int v){
//  return sum[v] - dp[v] + arr[v];
//}
 
void dfs(int u, int p){
    int cand = 0, cand2 = 0; ll best = 0, best2 = 0; //candidate for time[v] = 3
    ll lag = 0, lag3 = 0;
    for(int v : adj[u]){
        if(v == p) continue;
        dfs(v, u);
        sum[u] += dp[v];
        lag = max(lag, arr[v]);
                if(scam(v) > best){
            cand2 = cand, best2 = best;
            cand = v, best = scam(v);
        }else if(scam(v) > best2){
            cand2 = v, best2 = scam(v);
        }
    }
    for(int v : adj[u]){
        if(tim[v] == 3 && v != cand && v != p) lag3 = max(arr[v], lag3);
    }
    dp[u] = max(lag, lag3 + best);
    if(tim[cand] == 3) dp[u] = max(dp[u], best2 + arr[cand]);
    dp[u] += sum[u];
}
 
 
void solve(){
    cin >> n;
    for(int i = 0; i<=n; i++){
        tot[i] = dp[i] = sum[i] = 0;
        adj[i].clear();
    }
    for(int i = 1; i<=n; i++) cin >> arr[i];
    for(int i = 1; i<=n; i++) cin >> tim[i];
    for(int i = 1; i<n; i++){
        int a, b; cin >> a >> b;
        adj[a].push_back(b);
        b[adj].push_back(a);
    }
    dfs(1, 0);
    cout << dp[1] +arr[1] << "\n";
}
    
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int T; cin >> T;
    while(T--){
        solve();
    }
    return 0;
}