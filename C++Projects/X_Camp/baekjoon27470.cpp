#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 5*(int)1e5;
int N, a[MAX_N];
vector<int> d;

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for(int i=0; i<N; i++) cin >> a[i];
    
    vector<int> ans;
    bool works = false;

    for(int i=0; i< min(N, 100); i++){

        d.clear();

        for(int j=2; j<=sqrt(a[i]); j++){
            if(a[i]%j==0) {
                d.push_back(j);
                if(j*j != a[i]) d.push_back(a[i]/j);
            }
        }
        d.push_back(a[i]);

        vector<int> cnt(d.size());
        for(int j=0; j<d.size(); j++) cnt[j] = 0;
        
        for(int j=0; j<N; j++){
            for(int di=0; di<d.size(); di++){
                if(a[j]%d[di]==0) cnt[di]++;
            }
        }

        for(int j=0; j<cnt.size(); j++) {
            int curr = cnt[j];
            if(curr>=ceil(N/2.0)) {
                for(int k=0; k<N; k++){
                    if(a[k]%d[j]==0) ans.push_back(a[k]);
                }
                works = true;
                break;
            }
        }
        if(works) break;
    }
    cout << (works ? "YES":"NO") << endl;
    if(works){
        for(int i=0; i<ceil(N/2.0); i++) cout << ans[i] << " ";
    }
}