#include<bits/stdc++.h>
using namespace std;
const int MAX_N = (int)1e5+5;

int N, M;

vector<pair<int, int>> adj[MAX_N];
vector<int> adj2[MAX_N];
bool v[MAX_N];
unordered_set<int> tempV;
int a[MAX_N];

void dfs(int c) {
    v[c] = true;
    if(tempV.count(c)) return;
    tempV.insert(c);
    for(int i: adj2[c]) {
        dfs(i);
    }
}

bool check(int minW) {

    for(int i=1; i<=N; i++){
        v[i] = false;
    }

    for(int i=1; i<=N; i++){
        adj2[i].clear();
        for(pair j: adj[i]) {
            if(j.second >= minW) {
                adj2[i].push_back(j.first);
            }
        }
    }

    for(int i=1; i<=N; i++) {
        if(!v[i]) {
            tempV.clear();
            dfs(i);
            for(int i: tempV) {
                if(!tempV.count(a[i])) return false;
            }
        }
    }
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    freopen("wormsort.in","r",stdin);
    freopen("wormsort.out","w",stdout);

    bool sorted = true;

    cin >> N >> M;
    for(int i=1; i<=N; i++){
        cin >> a[i];
        if(i!=a[i]) sorted = false;
    }

    if(sorted) {
        cout << -1;
        return 0;
    }

    for(int i=0; i<M; i++) {
        int x, y, w; cin >> x >> y >> w;
        adj[x].push_back({y, w});
        adj[y].push_back({x, w});
    }

    // cout << check(9) << endl;

    int ans;

    int low = 1, high = (int)1e9, mid;
    while(low<=high) {
        // cout << mid << endl;
        mid = (low+high)/2;
        if(check(mid)) {
            ans = mid;
            low = mid+1;
        } else high = mid-1;
        
    }

    cout << ans;

}
