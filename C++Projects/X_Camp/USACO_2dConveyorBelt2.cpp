#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1010, MAX_Q = 2*1e5;
int N, Q;
int di[] = {0,0,-1,1};
int dj[] = {-1,1,0,0};
char dC[] = {'L','R','U','D'};
int v[MAX_N][MAX_N], dir[MAX_N][MAX_N];
vector<tuple<int, int, char>> updates;
vector<int> ans;
int cnt;

bool inRange(int i, int j){
    return i>=1 && j>=1 && i<=N && j<=N;
}
bool inBorderRange(int i, int j) {
    return i>=0 && j>=0 && i<=N+1 && j<=N+1;
}

bool check(int i, int j) {
    if(!inRange(i, j)) return false;

    for(int d=0; d<4; d++){
        if(dir[i][j] != -1 && d!=dir[i][j]) continue;

        int ni = i+di[d];
        int nj = j+dj[d];

        if(!inRange(ni, nj) || v[ni][nj]) return true;
    }
    return false;
}

void dfs(int i, int j) {
    if(!check(i, j) || v[i][j]) return;

    v[i][j] = true;
    cnt++;

    for(int d=0; d<4; d++){
        dfs(i+di[d], j+dj[d]);
    }
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> Q;

    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            dir[i][j] = -1;
        }
    }

    updates.resize(Q);

    for(auto &[x, y, d]: updates) {
        cin >> x >> y >> d;
        dir[x][y] = find(dC, dC+4, d) - dC;
    }

    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            dfs(i, j);
        }
    }

    reverse(updates.begin(), updates.end());

    for(auto [x, y, d]: updates) {
        ans.push_back(N*N - cnt);

        dir[x][y] = -1;
        dfs(x, y);
    }

    reverse(ans.begin(), ans.end());
    for(int i: ans) {
        cout << i << "\n";
    }
}