#include <bits/stdc++.h>
using namespace std;

int N;
const int MAX_N = 550;
vector<int> adj[MAX_N];
bool path[MAX_N][MAX_N];

void dfs(int c, int p) {
    if(path[p][c]) return;
    path[p][c] = true;
    for(int i: adj[c]) {
        dfs(i, p);
    }
}

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);


    cin >> N;
    for(int i=1; i<=N; i++){
        int x = 0;
        while(x!=i) {
            cin >> x;
            adj[i].push_back(x);
        }
        for(int j=adj[i].size(); j<N; j++){
            int dummy; cin >> dummy;
        }
    }

    for(int i=1; i<=N; i++){
        dfs(i, i);
    }

    for(int i=1; i<=N; i++){ // which cow
        for(int j=0; j<N; j++){ // which gift
            if(path[adj[i][j]][i]) {
                cout << adj[i][j] << "\n";
                break;
            }
        }
    }


}