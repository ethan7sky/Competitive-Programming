#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 2*1e5+5;
int lastIdx[MAX_N], sufMaxArr[MAX_N];
vector<int> a;
vector<int> b;
vector<int> c;
vector<int> ans;

int t, n;

int main() {
    cin.tie(0) -> sync_with_stdio(0);
    cin >> t;
    while(t--) {
        cin >> n;
        a.clear();
        b.clear();
        c.clear();
        ans.clear();
        for(int i=0; i<MAX_N; i++){
            lastIdx[i] = 0;
            sufMaxArr[i] = 0;
        }
        for(int i=0; i<n; i++){
            int x; cin >> x;
            a.push_back(x);
            b.push_back(x);
            lastIdx[x] = i;
        }
        sort(b.begin(), b.end(), greater<int>());

        bool found = false; int skipIdx;
        for(int i=0; i<n; i++){
            // cout << a[i] << " " << b[i] << endl;
            if(!found && a[i] != b[i]) {
                found = true;
                skipIdx = lastIdx[b[i]];
                c.push_back(b[i]);
                i--;
            }else {
                if(found && i==skipIdx) continue;
                c.push_back(a[i]);
            }
        }

        // for(int i: c) cout << i << " ";
        // cout << endl;
        sufMaxArr[n] = 0;
        for(int i=n-1; i>=0; i--) {
            sufMaxArr[i] = max(sufMaxArr[i+1], c[i]);
        }
        for(int i=0; i<n; i++){
            if(c[i] == sufMaxArr[i]) {
                ans.push_back(c[i]);
            }
        }
        for(int i=0; i<ans.size(); i++){
            if(i<ans.size()-1) cout << ans[i] << " ";
            else cout << ans[i] << "\n";
        }
    }
}