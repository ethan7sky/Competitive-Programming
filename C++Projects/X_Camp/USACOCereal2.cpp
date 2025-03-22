#include<bits/stdc++.h>
using namespace std;

const int MAX_N = (int)1e5+5;
vector<pair<int, int>> adj[MAX_N];
vector<pair<int, int>> pref = {{-1, -1}};
bool v[MAX_N], v2[MAX_N];
bool addedToOrder[MAX_N];
int N, M;
int cycleRootEdge = -1;
int noCycleRootEdge = -1;
vector<int> order;

void dfs2(int c, int p) {
    v2[c] = 1;
    for(pair<int, int> i: adj[c]) {
        if(i.second==p) continue;
        
        if(v2[i.first]) continue;
        v2[i.first] = true;
        order.push_back(i.second);
        addedToOrder[i.second] = true;
        dfs2(i.first, i.second);
    }
}

void dfs(int c, int p) {
    v[c] = true;
    for(pair<int, int> i: adj[c]) {
        if(i.second==p) continue;
        
        if(v[i.first]) {
            cycleRootEdge = i.second;
        } else {
            noCycleRootEdge = i.second;
            dfs(i.first, i.second);
        }
    }
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    for(int i=1; i<=N; i++){
        int f, s; cin >> f >> s;
        adj[f].push_back({s, i});
        adj[s].push_back({f, i});
        pref.push_back({f, s});
    }

    for(int i=1; i<=M; i++){
        if(!v[i]) {
            cycleRootEdge = -1;
            noCycleRootEdge = -1;
            dfs(i, -1);

            if(cycleRootEdge==-1) {
                if(noCycleRootEdge != -1) {
                    dfs2(pref[noCycleRootEdge].first, -1);

                }
            } else{
                order.push_back(cycleRootEdge);
                addedToOrder[cycleRootEdge] = true;
                dfs2(pref[cycleRootEdge].first, cycleRootEdge);
            }
        }
    }

    cout << N - order.size() << endl;
    for(int i: order){
        cout << i << "\n";
    }
    for(int i=1; i<=N; i++){
        if(!addedToOrder[i]) {
            cout << i << "\n";
        }
    }

}