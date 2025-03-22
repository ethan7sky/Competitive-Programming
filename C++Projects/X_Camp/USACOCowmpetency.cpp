#include<bits/stdc++.h>
using namespace std;

const int MAX_N = (int)1e5+10;
int T, N, Q, C;
int a[MAX_N];
int pointsTo[MAX_N];
bool hasZero[MAX_N];

void solve() {
    cin >> N >> Q >> C;

    for(int i=0; i<N; i++){
        a[i] = 0;
        pointsTo[i] = 0;
        hasZero[i] = 0;
    }

    for(int i=0; i<N; i++){
        cin >> a[i];
        if(a[i]==0) {
            hasZero[i] = true;
            a[i] = 1;
        }
    }

    for(int i=0; i<Q; i++){
        int a, b; cin >> a >> b; a--; b--;
        if(pointsTo[a]!=0 && pointsTo[a]!=b) {
            cout << "-1\n";
            return;
        }
        pointsTo[a] = b;
    }

    for(int i=0; i<N; i++){
        if(pointsTo[i]==0) continue;

        for(int j=i; j<pointsTo[i]; j++){
            if(pointsTo[j]!=0&&pointsTo[j]!=pointsTo[i]){
                cout << "-1\n";
                return;
            }
            pointsTo[j] = pointsTo[i];
        }
        i=pointsTo[i];
    }

    int lMax=0, rMax=0;
    for(int i=0; i<N; i++){
        lMax = max(lMax, a[i]);
        rMax = max(rMax, a[i]);

        if(pointsTo[i]==0) continue;

        else{

            for(int j=i+1; j<pointsTo[i]; j++) rMax = max(rMax, a[j]);

            if(lMax<rMax) {

                bool found0 = false;
                for(int j=i; j>=0; j--) {
                    if(hasZero[j]) {
                        if(pointsTo[j]!=0&&pointsTo[j]<pointsTo[i]) {
                            cout << "-1\n";
                            return;
                        }
                        found0 = true;
                        a[j] = rMax;
                        break;
                    }
                }
                if(!found0) {
                    cout << "-1\n";
                    return;
                }
                lMax = rMax;

            }

            if(hasZero[pointsTo[i]]) a[pointsTo[i]] = lMax+1;
            if(a[pointsTo[i]]<=lMax) {
                cout << "-1\n";
                return;
            }



        }
    }
    string ans = "";
    for(int i=0; i<N; i++){
        if(a[i]>C) {
            cout << "-1\n";
            return;
        } else {
            ans += to_string(a[i]);
            if(i!=N-1) ans += " ";
        }
    }
    cout << ans << "\n";

        
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> T;
    while(T--) {
        solve();
    }

}