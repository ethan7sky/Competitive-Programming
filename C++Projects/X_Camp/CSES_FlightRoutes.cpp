#include <bits/stdc++.h>
using namespace std;
using ll = long long;
// #define ff first;
// #define ss second;

const int MAX_N = 2e5;
int n, m, k;
vector<pair<int, int>> adj[MAX_N+1];
priority_queue<ll> best[MAX_N+1];
priority_queue<pair<ll, int>, vector<pair<ll, int>>, greater<pair<ll, int>>> pq;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);


    cin >> n >> m >> k;

    for(int i=0; i<m; i++){
        int f, t, c; //from, to, cost
        cin >> f >> t >> c;
        adj[f].push_back({c, t});
    }

    best[1].push(0);
    pq.push({0, 1});
    
    while(!pq.empty()){
        auto i = pq.top();
        pq.pop();
        if(i.first > best[i.second].top()) continue;
        for(auto &j: adj[i.second]){
            ll sum = i.first+j.first;
            if(best[j.second].size() < k){
                best[j.second].push(sum);
                pq.push({sum, j.second});
            }
            else if(sum < best[j.second].top()){
                best[j.second].pop();
                best[j.second].push(sum);
                pq.push({sum, j.second});
            }
        }
    }

    vector<ll> ans;
    while(!best[n].empty()){
        ans.push_back(best[n].top());
        best[n].pop();
    }
    reverse(ans.begin(), ans.end());
    for(ll a: ans) cout << a << " ";
}
