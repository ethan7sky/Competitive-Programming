#include <bits/stdc++.h>
using namespace std;

int N;
int main() {
    cin >> N;
    cout << "YES" << endl;

    if(N==3) {
        cout << "2 1 3";
    }
    else { 
        vector<int> ans = {1};
        if(N%4==3) {
            ans = {2, 1, 3, 4};
        }
        int size = ans.size();
        while(size != N) {
            if(size%4==0){
                ans.push_back(ans.back()+2);
            } else if(size%4==1) {
                ans.push_back(ans.back()+ ((N%4==3) ? -1:1));
            } else if(size%4==2){
                ans.push_back(ans.back()+2);
            } else{
                ans.push_back(ans.back()+ ((N%4==3) ? 1:-1));
            } size++;
        }
        for(int i: ans) cout << i << " ";
    }
}