#include <bits/stdc++.h>
using namespace std;

using ll = long long;

ll t, N, n, m, k;
const int MAX_M = 3*1e5+3, MAX_K = 4+3;
int a[MAX_M][MAX_K];
pair<int, int> b[MAX_M];
bool isChooseEven[MAX_M];

void reset() {
    for(int i=0; i<MAX_M; i++) isChooseEven[i] = false;
}

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> t;
    while(t--){
        reset();

        cin >> N >> m >> k;
        n = N;
        for(int i=0; i<m; i++){
            for(int j=0; j<k; j++){
                cin >> a[i][j];
            }
        }
        bool works = true;
        int minArray[m+1];
        for(int i=0; i<m; i++){
            int maxEven = 0;
            int maxOdd = 0;
            int minEven = INT_MAX;
            int minOdd = INT_MAX;
            for(int j=0; j<k; j++){
                if(a[i][j]%2==0) {
                    maxEven = max(maxEven, a[i][j]);
                    minEven = min(minEven, a[i][j]);
                }
                else {
                    maxOdd = max(maxOdd, a[i][j]);
                    minOdd = min(minOdd, a[i][j]);
                }
            }
            if(maxEven==0) {
                isChooseEven[i] = false;
                n += minOdd;
                b[i] = {-maxOdd, minOdd};
            }else if(maxOdd==0) {
                isChooseEven[i] = true;
                n += minEven;
                b[i] = {minEven, -maxEven};
            } else{
                if(maxEven >= maxOdd) {
                    isChooseEven[i] = true;
                    n -= maxOdd;
                    b[i] = {-maxOdd, -maxEven};
                } else {
                    isChooseEven[i] = false;
                    n -= maxEven;
                    b[i] = {-maxOdd, -maxEven};
                }
            }
            minArray[i] = n;
            if(n<=0) {
                cout << "-1\n";
                works = false;
                break;
            }
        }if(!works) continue;
        else {

            minArray[m] = INT_MAX;
            for(int i=m-1; i>=0; i--){
                minArray[i] = min(minArray[i], minArray[i+1]);
            }
            int delta = 0;

            for(int i=0; i<m; i++){
                if(isChooseEven[i]) N += b[i].first;
                else N += b[i].second;

                if(!isChooseEven[i]) {
                    if(N + b[i].first - b[i].second > 0 && minArray[i]+delta+b[i].first-b[i].second>0) {
                        isChooseEven[i] = true;
                        N = N+b[i].first-b[i].second;
                        delta += (b[i].first-b[i].second);
                    }
                }
            }
        }
        for(int i=0; i<m; i++){
            cout << (isChooseEven[i]?"Even":"Odd") << (i!=m-1?" ":"");
        }
        cout << "\n";

        
    }
}