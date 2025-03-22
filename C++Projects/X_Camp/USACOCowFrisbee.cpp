#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAX_N = 3*1e5+5;

int n;
int heightToIdx[MAX_N];
int idxToHeight[MAX_N];
set<int> idx;
ll ans = 0;

int main() {
    cin.tie(0) -> sync_with_stdio(0);
    cin >> n;
    idx.insert(0); idx.insert(n+1);
    for(int i=1; i<=n; i++){
        idx.insert(i);
        int height; cin >> height;
        heightToIdx[height] = i;
        idxToHeight[i] = height;
    }
    for(int h=1; h<=n; h++){
        int currIdx = heightToIdx[h];

        int gIdx = *idx.upper_bound(currIdx);
        int lIdx = *(prev(idx.lower_bound(currIdx)));

        if(gIdx!=n+1) {
            ans += gIdx-currIdx+1;
        }if(lIdx!=0) {
            ans += currIdx-lIdx+1;
        }
        idx.erase(currIdx);
    }
    cout << ans << endl;
}