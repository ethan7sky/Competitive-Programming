#include <bits/stdc++.h>
using namespace std;

const int MAX_N = (int)1e5+10;
int N;
int a[MAX_N], leafCnt[MAX_N], hasPotion[MAX_N];
vector<int> adj[MAX_N];


void dfs1(int n, int p) {
    if(adj[n].size()==1 && adj[n][0]==p) {
        leafCnt[n]=1;
        return;
    }
    int cnt=0;
    for(int c: adj[n]) {
        if(c==p) continue;
        dfs1(c, n);
        cnt += leafCnt[c];
    }
    leafCnt[n] = cnt;
}

int dfs2(int n, int p) {
    // if(adj[n].size()==1) {
    //     if(hasPotion[n]) return 1;
    //     else return 0;
    // }
    int potionCnt = hasPotion[n];
    for(int c: adj[n]) {
        if(c==p) continue;
        potionCnt += dfs2(c, n);
    }
    return min(potionCnt, leafCnt[n]);
}

int main(){

    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;
    for(int i=0; i<N; i++){
        cin >> a[i];
    }
    for(int i=1; i<N; i++){
        int x, y; cin >> x >> y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }

    dfs1(1, -1);

    // for(int i=1; i<=N; i++){
    //     cout << leafCnt[i] << endl;
    // }

    for(int i=0; i<leafCnt[1]; i++){
        hasPotion[a[i]]++;
    }

    cout << dfs2(1, -1);


}