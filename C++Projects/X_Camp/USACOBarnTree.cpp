#include <bits/stdc++.h>
using namespace std;
using ll = long long;

vector<ll> cnt, subtree_tot;
vector<vector<int>> adj;
ll avg;
vector<tuple<int, int, ll>> ans; // {source, destination, bales}

void calc_subtrees(int n, int p) {
    subtree_tot[n] = cnt[n]-avg;
    for(int c: adj[n]) {
        if(c!=p) {
            calc_subtrees(c, n);
            subtree_tot[n] += subtree_tot[c];
        }
    }
}

void solve(int n, int p) {
    for(int c: adj[n]) {
        if(c!=p) {
            if(subtree_tot[c]>=0) solve(c, n);
            if(subtree_tot[c]>0) ans.emplace_back(c, n, subtree_tot[c]);
        }
    }
    for(int c: adj[n]){
        if(c!=p){
            if(subtree_tot[c]<0) {
                ans.emplace_back(n, c, -subtree_tot[c]);
                solve(c, n);
            }
        }
    }
}

int main() {
    cin.tie(0) -> sync_with_stdio(0);
    int n; cin >> n;
    cnt.resize(n); adj.resize(n); subtree_tot.resize(n);
    for(ll &c : cnt) cin >> c, avg += c;
    avg /= n;
    for(int i=0; i<n-1; i++){
        int a, b; cin >> a >> b; a--; b--;
        adj[a].emplace_back(b); adj[b].emplace_back(a);
    }

    calc_subtrees(0, -1);
    solve(0, -1);

    cout << size(ans) << "\n";
    for(auto [a, b, c] : ans) cout << a+1 << " " << b+1 << " " << c << "\n";
    
}