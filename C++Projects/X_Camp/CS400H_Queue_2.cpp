#include <bits/stdc++.h>
using namespace std;

int main(){
    int n; cin >> n;
    set<int> a;
    for(int i=0; i<n; i++){
        int x; cin >> x;
        a.insert(x);
    }


    int time=0;
    int cnt=0;
    while(true){
        int greater = *a.upper_bound(time);

        if(greater==a.size()) break;
        else{
            cnt++;
            time += greater;
            a.erase(greater);
        }
    }
    cout << cnt << endl;
}