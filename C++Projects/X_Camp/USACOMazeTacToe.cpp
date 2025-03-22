#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 27;
int N;
char board[MAX_N][MAX_N][3];
int v[MAX_N][MAX_N][19700];
int p3[10];
set<int> ans;
int combo[8][3][2] = {
    {{0,0},{0,1},{0,2}},
    {{1,0},{1,1},{1,2}},
    {{2,0},{2,1},{2,2}},
    {{0,0},{1,0},{2,0}},
    {{0,1},{1,1},{2,1}},
    {{0,2},{1,2},{2,2}},
    {{0,0},{1,1},{2,2}},
    {{0,2},{1,1},{2,0}}
};

bool works(int state) {
    int a[3][3];
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            a[i][j] = state%3; state/=3;
            // cout << a[i][j] << " ";
        }
    }
    // cout << "original state " << state << endl;

    for(int i=0; i<8; i++){
        string moo = "";
        for(int j=0; j<3; j++){
            moo += to_string(a[combo[i][j][0]][combo[i][j][1]]);
        }
        // cout << moo << endl;
        if(moo == "122" || moo == "221") {
            // cout << "YES" << endl;
            return true;
        }
    }
    return false;
}

void ff(int i, int j, int state) {
    if(board[i][j][0] == '#') return;
    if(v[i][j][state]) return;
    v[i][j][state] = true;

    // cout << i << " " << j << " " << state << endl;

    if(board[i][j][0]=='M'||board[i][j][0]=='O'){
        int x = board[i][j][1]-'1', y = board[i][j][2]-'1';
        int key = 3*x+y;
        if(state/p3[key]%3==0) {
            int letter = board[i][j][0]=='M'? 1:2;
            state = state%p3[key] + letter*p3[key] + (state-state%p3[key+1]);
            if(!v[i][j][state] && works(state)) {
                ans.insert(state);
                v[i][j][state] = true;
                return;
            }
            v[i][j][state] = true;
        }
    }

    ff(i+1, j, state);
    ff(i-1, j, state);
    ff(i, j+1, state);
    ff(i, j-1, state);


}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;

    int bi, bj;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> board[i][j][0] >> board[i][j][1] >> board[i][j][2];
            if(board[i][j][0]=='B') {
                bi=i; bj=j;
            }
        }
    }

    p3[0] = 1;
    for(int i=1; i<=9; i++){
        p3[i] = p3[i-1]*3;
    }

    ff(bi, bj, 0);
    cout << ans.size();
}