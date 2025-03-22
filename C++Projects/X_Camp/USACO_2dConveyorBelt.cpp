#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1010, MAX_Q = 2*1e5;
int N, Q;
pair<pair<int, int>, char> belt[MAX_Q];
set<pair<int, int>> pointsHere[MAX_N][MAX_N];
pair<int, int> pointsTo[MAX_N][MAX_N];
bool v[MAX_N][MAX_N];
int ans;


bool inRange(int i, int j){
    return i>=1 && j>=1 && i<=N && j<=N;
}
bool inBorderRange(int i, int j) {
    return i>=0 && j>=0 && i<=N+1 && j<=N+1;
}


void bfs(int x, int y) {
    if(x<0||x>N+1||y<0||y>N+1) return;
    if(v[x][y]) return;
    v[x][y] = true;
    if(inRange(x, y)) ans++;
    for(pair i: pointsHere[x][y]) {
        bfs(i.first, i.second);
    }
}

pair<int, int> getPointsToPair(int x, int y, char c) {
    if(c=='U') x--;
    else if(c=='D') x++;
    else if(c=='L') y--;
    else y++;
    return {x, y};
}

vector<int> revAns;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> Q;

    for(int i=0; i<=N+1; i++){
        for(int j=0; j<=N+1; j++){
            if(inRange(i+1, j)) pointsHere[i][j].insert({i+1, j});
            if(inRange(i-1, j)) pointsHere[i][j].insert({i-1, j});
            if(inRange(i, j+1)) pointsHere[i][j].insert({i, j+1});
            if(inRange(i, j-1)) pointsHere[i][j].insert({i, j-1});
        }
    }

    for(int i=0; i<Q; i++){
        int x, y; char c;
        cin >> x >> y >> c;
        belt[i] = {{x, y}, c};
        if(inBorderRange(x+1, y) && c != 'D') pointsHere[x+1][y].erase({x,y});
        if(inBorderRange(x-1, y) && c != 'U') pointsHere[x-1][y].erase({x,y});
        if(inBorderRange(x, y+1) && c != 'R') pointsHere[x][y+1].erase({x,y});
        if(inBorderRange(x, y-1) && c != 'L') pointsHere[x][y-1].erase({x,y});
    }

    for(int i=1; i<=N; i++){
        bfs(0, i);
        bfs(N+1, i);
        bfs(i, 0);
        bfs(i, N+1);
    }

    for(int i=Q-1; i>=0; i--){
        revAns.push_back(ans);

        int x = belt[i].first.first;
        int y = belt[i].first.second;
        char c = belt[i].second;

        bool canEscape = false;
        if(inBorderRange(x+1, y)) {
            pointsHere[x+1][y].insert({x, y});
            if(v[x+1][y]) canEscape = true;
        }
        if(inBorderRange(x-1, y)) {
            pointsHere[x-1][y].insert({x, y});
            if(v[x-1][y]) canEscape = true;
        }
        if(inBorderRange(x, y+1)) {
            pointsHere[x][y+1].insert({x, y});
            if(v[x-1][y]) canEscape = true;
        }
        if(inBorderRange(x, y-1)) {
            pointsHere[x][y-1].insert({x, y});
            if(v[x][y-1]) canEscape = true;
        }
        if(canEscape) bfs(x, y);
    }

    for(int i=Q-1; i>=0; i--) {
        cout << (N*N-revAns[i]) << "\n";
    }
}