#include <bits/stdc++.h>
using namespace std;

int N;
const int MAX_N = 260;
int a[MAX_N][MAX_N]; //colors on grid
int id[MAX_N][MAX_N]; //id on grid, id = node
int sz[MAX_N*MAX_N]; //size of each id
int color[MAX_N*MAX_N]; //color of each id
bool v[MAX_N][MAX_N]; //visited or not (for ff)
int currId, currColor, currSz; //currId = maxId+1
unordered_set<int> adj[MAX_N*MAX_N]; //adjacent ids (nodes)
set<int> v2[MAX_N*MAX_N]; //first = color, second = id
int ans1=0, ans2=0;

void ff(int i, int j) {
    if(i<0||i>=N||j<0||j>=N) return;

    if(a[i][j]==currColor) {
        if(v[i][j]) return;
        id[i][j] = currId;
        v[i][j] = true;
        currSz++;
        ff(i+1, j);
        ff(i-1, j);
        ff(i, j+1);
        ff(i, j-1);
    } else {
        if(id[i][j] != 0){
            adj[currId].insert(id[i][j]);
            adj[id[i][j]].insert(currId);
        }
    }

}

int ff2(int id, pair<int, int> colorPair) {
    int currSize = sz[id];
    for(int j: adj[id]) {
        if(color[j]==colorPair.first||color[j]==colorPair.second) {
            if(!v2[j].count(color[id])) {
                v2[j].insert(color[id]);
                currSize += ff2(j, colorPair);
            }
        }
    }
    return currSize;
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    freopen("multimoo.in","r",stdin);
    freopen("multimoo.out","w",stdout);

    cin >> N;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> a[i][j];
        }
    }

    currId = 1;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(!v[i][j]) {
                currSz = 0;
                currColor = a[i][j];
                ff(i, j);
                
                sz[currId] = currSz;
                color[currId] = currColor;
                currId++;
            }
        }
    }


    for(int i=1; i<=currId; i++){
        for(int j: adj[i]) {
            v2[i].insert(color[j]);
            ans2 = max(ans2, ff2(i, {color[i],color[j]}));
        }
    }


    for(int i=1; i<currId; i++){
        ans1 = max(ans1, sz[i]);
    }

    cout << ans1 << "\n" << ans2;
}