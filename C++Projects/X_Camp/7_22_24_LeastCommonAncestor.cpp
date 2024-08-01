#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 2e5+1;
int n, q, depth[MAX_N], first[MAX_N], idx=1, euler[2*MAX_N];
vector<int> adj[MAX_N];

struct segtree{ 
    int n;
    vector<int> tree;
    segtree(int n) {
        tree.resize(2*n+2, 1e9);
    }
    int comb(int a, int b){
        if(depth[a]<depth[b]) return a;
        return b;
    }
    void pull(int p){
        tree[p] = comb(tree[2*p],tree[2*p+1]);
    }
    void update(int p, int val) {
        p += n;
        tree[p] = val;
        while(p>0){
            p/=2;
            pull(p);
        }
    }
    int query(int l, int r){
        int lAns = 1e9, rAns = 1e9;
        l+=n;
        r+=n+1;
        while(l<r){
            if(l&1) lAns = comb(lAns, tree[l++]);
            if(r&1) rAns = comb(rAns, tree[--r]);
            l /= 2;
            r /= 2;
        }
        return comb(lAns, rAns);
    }
};



void dfs(int node, int parent, int d) {
    first[node] = idx;
    euler[idx] = node;
    idx++;
    depth[node] = d;
    for(int c: adj[node]) {
        if(c!=parent){
            dfs(c, node, d+1);
            euler[idx] = node;
            idx++;
        }
    }

}

int lca(int a, int b, segtree s){
    return s.query(min(first[a],first[b]), max(first[a],first[b]));
}

int main() {
    
    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout << "test";
    cin >> n >> q;
    for(int i=1; i<n; i++){
        int a, b; cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    cout << "test";
    dfs(1, 0, 0);
    segtree st(2*n-1);
    while(q-->0) {
        cout << "hi" ;
        int a, b; cin >> a >> b;
//         cout << lca(a, b, st) << endl;
    }
}