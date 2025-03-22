#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1010;
int N;
int a[MAX_N][MAX_N];
vector<pair<int, int>> idx[MAX_N*2]; //idxs of #
int amt[MAX_N*2]; //amt of each #
int assignment[MAX_N*2];
pair<int, int> _2coord = {-1, -1}, _2Ncoord;

int main(){

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> a[i][j];
            amt[a[i][j]]++;
            idx[a[i][j]].push_back({i, j});
        }
    }

    for(int i=2; i<=2*N; i++){
        if(amt[i]==1) {
            // cout << i << endl;
            if(_2coord.first==-1) {
                _2coord = {idx[i][0].first, idx[i][0].second};
                _2Ncoord = _2coord;
            }
            // else _2Ncoord = {idx[i][0].first, idx[i][0].second};
        }
    }



    vector<vector<int>> ans1;
    ans1.resize(N);
    for(int i=0; i<N; i++) ans1[i].resize(N);
    vector<vector<int>> ans2;
    ans2.resize(N);
    for(int i=0; i<N; i++) ans2[i].resize(N);

    for(int i=0; i<2*MAX_N; i++) assignment[i] = -1;
    int i = _2coord.first;
    for(int j=0; j<N; j++){
        assignment[a[i][j]] = amt[a[i][j]]+1;
    }
    for(int i=2; i<=2*N; i++){
        if(assignment[i]==-1) {
            assignment[i] = 2*N-amt[i]+1;
        }
    }

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            ans1[i][j] = assignment[a[i][j]];
        }
    }

    for(int i=0; i<2*MAX_N; i++) assignment[i] = -1;
    i = _2Ncoord.first;
    for(int j=0; j<N; j++){
        assignment[a[i][j]] = 2*N-amt[a[i][j]]+1;
    }
    for(int i=2; i<=2*N; i++){
        if(assignment[i]==-1) {
            assignment[i] = amt[i]+1;
        }
    }
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            ans2[i][j] = assignment[a[i][j]];
        }
    }
    vector<vector<int>> ans = (ans1<ans2?ans1:ans2);
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cout << ans[i][j] << (j!=N-1?" ":"");
        }cout << "\n";
    }








}