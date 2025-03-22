#include <bits/stdc++.h>
using namespace std;

int main(){
    cin.tie(0) -> sync_with_stdio(0);
    int n; cin >> n;
    vector<int> a;
    for(int i=0; i<n; i++) {int x; cin >> x; a.emplace_back(x);}
    a.emplace_back(0);
    string ans="";
    int i=0;
    while(!(i==0&&a[i]==0)){
        while(a[i]>0 && i<n){
            ans+="R";
            a[i]--; i++;
        }while(i>0 && (a[i-1]>1||a[i]==0)){
            ans+="L";
            i--; a[i]--; 
        }
    }cout << ans << endl;
}