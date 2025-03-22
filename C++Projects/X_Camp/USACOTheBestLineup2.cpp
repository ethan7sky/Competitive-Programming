#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 2*1e5+5;
pair<int, int> lastTwo[MAX_N];
int firstOccurence[MAX_N];
vector<int> idxs[MAX_N];
set<int> uNums;
vector<int> descNum;

int sufMaxArr[MAX_N];
vector<int> a;
vector<int> c;
vector<int> ans;

int t, n;

int main() {
    cin.tie(0) -> sync_with_stdio(0);
    cin >> t;
    while(t--) {
        cin >> n;
        a.clear();
        c.clear();
        ans.clear();
        descNum.clear();
        uNums.clear();
        for(int i=0; i<MAX_N; i++){
            idxs[i].clear();
            lastTwo[i] = {-1, -1};
            firstOccurence[i] = -1;
        }
        for(int i=0; i<n; i++){
            int x; cin >> x;
            a.push_back(x);
            if(firstOccurence[x]==-1) firstOccurence[x] = i;
            if(lastTwo[x].second==-1) lastTwo[x].second = i;
            else {
                lastTwo[x].first = lastTwo[x].second;
                lastTwo[x].second = i;
            }
            idxs[x].push_back(i);
            if(!uNums.count(x)) {
                uNums.insert(x);
                descNum.push_back(x);
            }
        }
        sort(descNum.begin(), descNum.end(), greater<int>());

        for(int i: descNum) {
            if(lastTwo[i].first == -1) lastTwo[i].first = lastTwo[i].second;
        }

        int skipIdx, insertIdx;

        descNum.push_back(-1);
        for(int i=0; i<n; i++) {
            int curr = descNum[i];
            int nextSmaller = descNum[i+1];
            if(nextSmaller == -1) break;

            int beforeCnt = 0, middleCnt = 0, afterCnt = 0;
            for(int i: idxs[curr]) {
                if(i>lastTwo[nextSmaller].second) afterCnt++;
                else if(i>lastTwo[nextSmaller].first) middleCnt++;
                else beforeCnt++;
            }
            if(afterCnt==1 || afterCnt==0 && middleCnt == 1) {
                insertIdx = firstOccurence[nextSmaller];
                skipIdx = idxs[curr][idxs[curr].size()-1];
                break;
            }
        }

        cout << insertIdx << " " << skipIdx << endl;

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