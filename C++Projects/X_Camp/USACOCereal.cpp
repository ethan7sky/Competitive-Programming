#include <bits/stdc++.h>
using namespace std;

int N, M;
const int MAX_N = (int)1e5+5;
vector<pair<int, int>> pref;
int whichCow[MAX_N];
int cnt = 0;

void dfs(int c) {

    int fav1 = pref[c].first;
    int fav2 = pref[c].second;
    if(whichCow[fav1]==-1) {
        cnt++;
        whichCow[fav1] = c;
    } else{ 
        if(whichCow[fav1] < c) {

            if(whichCow[fav2]==-1) {
                cnt++;
                whichCow[fav2] = c;
            } else{
                if(whichCow[fav2]<c) {
                    return;
                } else{
                    int updateCow = whichCow[fav2];
                    whichCow[fav2] = c;
                    dfs(updateCow);
                }
            }

        }
        else{ 
            int updateCow = whichCow[fav1];
            whichCow[fav1] = c;
            dfs(updateCow);
        }
    }


}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    freopen("cereal.in","r",stdin);
    freopen("cereal.out","w",stdout);

    cin >> N >> M;

    for(int i=0; i<N; i++){
        int x, y; cin >> x >> y;
        pref.push_back({x, y});
    }
    for(int i=1; i<=M; i++ ){
        whichCow[i] = -1;
    }

    vector<int> ans;

    for(int i=N-1; i>=0; i--) {
        // int first = pref[i].first;
        // int second = pref[i].second;
        dfs(i);
        ans.push_back(cnt);
    }

    for(int i=N-1; i>=0; i--) { 
        cout << ans[i] << "\n";
    }

}