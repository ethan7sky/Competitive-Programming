#include <bits/stdc++.h>
using namespace std;

using ll = long long;

const int MAX_N = (int)1e5;

int N;
ll a[MAX_N];
vector<unordered_set<int>> adj(MAX_N);
unordered_set<int> releventV;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> a[i];
    }

    for(ll k=0; k<64; k++){
        ll currIdx = ((ll)1)<<k;
        vector<int> temp;
        for(int i=0; i<N; i++){
            if(a[i] & currIdx) temp.push_back(i);
        }
        if(temp.size()>=3) {
            cout << 3 << endl;
            return 0;
        } else if(temp.size()==2) {
            adj[temp[0]].insert(temp[1]);
            adj[temp[1]].insert(temp[0]);
            releventV.insert(temp[0]);
            releventV.insert(temp[1]);
        }
    }

    int ans = INT_MAX;

    for(int i: releventV){
        vector<int> dist(N, (int)1e9);
        vector<int> p(N, -1);

        dist[i] = 0;
        queue<int> q;

        q.push(i);
        while(!q.empty()) {
            int x = q.front();
            q.pop();

            for(int c: adj[x]) {
                if(dist[c] == (int)1e9) {
                    dist[c] = dist[x]+1;
                    p[c] = x;
                    q.push(c);
                } else if(p[x] != c && p[c] != x) {
                    ans = min(ans, dist[x]+dist[c]+1);
                }
            }
        }
    }

    if(ans==INT_MAX) cout << -1 << endl;
    else cout << ans << endl;
}