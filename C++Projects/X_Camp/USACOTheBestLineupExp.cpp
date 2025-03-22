#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 2*1e5+5;
int sufMaxArr[MAX_N];
vector<int> a;
vector<int> b;
vector<int> c;
vector<int> ans;
map<int, int> lastIdx;

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
        lastIdx.clear();
        for(int i=0; i<n; i++){
            int x; cin >> x;
            a.push_back(x);
            lastIdx[x] = i;
        }
        sufMaxArr[n] = 0;
        for(int i=n-1; i>=0; i--) {
            sufMaxArr[i] = max(sufMaxArr[i+1], a[i]);
        }
        for(int i=0; i<n; i++){
            if(a[i] == sufMaxArr[i]) {
                b.push_back(a[i]);
            }
        }
        ans = b;
        
        for(auto temp: lastIdx){
            // cout << temp.first << " " << temp.second << endl;
            int skipIdx = temp.second;
            for(int insertIdx = 0; insertIdx < skipIdx; insertIdx++) {

                if(a[insertIdx] > a[skipIdx]) continue;
                
                c.clear();
                b.clear();

                bool found = false;
                for(int i=0; i<n; i++){
                    if(i==skipIdx) continue;
                    else if(i==insertIdx) {
                        if(!found) {
                            c.push_back(a[skipIdx]);
                            i--;
                            found = true;
                        }else {
                            c.push_back(a[i]);
                        }
                    }else {
                        c.push_back(a[i]);
                    }
                }

                // if(skipIdx==3 && insertIdx==0){
                //     for(int i: c) cout << i << " ";
                //     cout << endl;
                // }

                sufMaxArr[n] = 0;
                for(int i=n-1; i>=0; i--) {
                    sufMaxArr[i] = max(sufMaxArr[i+1], c[i]);
                }
                for(int i=0; i<n; i++){
                    if(c[i] == sufMaxArr[i]) {
                        b.push_back(c[i]);
                    }
                }

                // if(skipIdx==3 && insertIdx==0){
                //     for(int i: b) cout << i << " ";
                //     cout << endl;
                //     for(int i: ans) cout << i << " ";
                //     cout << endl;
                // }
                
                bool greater = false, equal = true;
                for(int i=0; i<min(b.size(), ans.size()); i++) {
                    if(b[i] > ans[i]) {
                        greater = true;
                        break;
                    }
                    if(b[i] != ans[i]) equal = false;
                }if(greater || equal && b.size() > ans.size()) {
                    ans = b;
                }

            }
        }
        for(int i=0; i<ans.size(); i++){
            if(i<ans.size()-1) cout << ans[i] << " ";
            else cout << ans[i] << "\n";
        }
    }
}