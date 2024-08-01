#include <bits/stdc++.h>
using namespace std;

const int M = 2e5+2;

vector<int> c[M];
int cnt[M];

void dfs(int node) {
    for(int child : c[node]){
        dfs(child);
        cnt[node] += cnt[child]+1;
    }
}

int main() {
    int n; 
    cin >> n;
    for(int i=2; i<=n; i++){
        int p; 
        cin >> p;
        c[p].push_back(i);
    }

    dfs(1);
    for(int i=1; i<n; i++){
        cout << cnt[i] << " ";
    }cout << cnt[n] << "\n";
}