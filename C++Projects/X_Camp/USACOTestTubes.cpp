#include<bits/stdc++.h>
using namespace std;

int T, N, P;
string s1, s2;
int s1sz, s2sz;

string compress(string s) {
    string ans = "";
    s = " "+s;
    for(int i=1; i<=N; i++){
        if(s[i]!=s[i-1]) ans += s[i];
    }return ans;
}
string chng(string s){
    string ans="";
    for(int i=0; i<s.length(); i++) {
        ans += s[i]=='1'? "2":"1";
    }
    return ans;
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> T;
    while(T--) {
        cin >> N >> P;
        cin >> s1 >> s2;
        s1 = compress(s1);
        s2 = compress(s2);

        if(s1[0]==s2[0]) {
            if(s1[0]=='1') s2 = "2"+s2;
            else s1 = "1"+s1;
        }
        else{
            if(s1[0]=='2'&&s2[0]=='1') {
                s1 = chng(s1);
                s2 = chng(s2);
            }
        }

        //s1 = 12121....
        //s2 = 21212....
        s1sz = s1.length();
        s2sz = s2.length();
        
        if(s1sz==1 && s2sz==1) {
            cout << "0\n";
            continue;
        }

        int M = 0;
        vector<pair<int, int>> ans;

        if(s1[s1sz-1]==s2[s2sz-1]) {
            if(s1sz>s2sz) {
                s1 = s1.substr(0, s1sz);
                s1sz--;
                ans.push_back({1, 2});
            } else {
                s2 = s2.substr(0, s2sz);
                s2sz--;
                ans.push_back({2, 1});
            }
            M++;
        } if(s1sz==1 && s2sz==1) {
            cout << M << "\n";
            cout << ans[0].first << " "<< ans[0].second << "\n";
            continue;
        }

        //s1 = 12121
        //s2 = 212

        M += s1sz-1 + s2sz-1;

        stack<int> t1, t2;
        for(int i=0; i<s1sz; i++){
            t1.push(s1[i]);
        } for(int i=0; i<s2sz; i++){
            t2.push(s2[i]);
        }

        char goesIntoBeaker;
        if(s1sz>=s2sz) {
            goesIntoBeaker = s1[s1sz-s2sz];
        }  else {
            goesIntoBeaker = s2[s2sz-s1sz];
        }

        while(s1sz>1&&s2sz>1) {
            if(goesIntoBeaker == '1') {
                //1s go into beaker
                if(t1.top()=='1') {
                    ans.push_back({1, 3});
                    ans.push_back({2, 1});
                } else {
                    ans.push_back({2, 3});
                    ans.push_back({1, 2});
                }
            }
            else{
                //2s go into beaker
                if(t1.top()=='1') {
                    ans.push_back({2, 3});
                    ans.push_back({1, 2});
                } else {
                    ans.push_back({1, 3});
                    ans.push_back({2, 1});
                }
            }
            t1.pop();
            t2.pop();
            s1sz--; s2sz--;
        }

        if(s1sz==1 && s2sz>1) {
            while(s2sz>1) {
                if(t2.top()=='2') {
                    ans.push_back({2, 3});
                }else {
                    ans.push_back({2, 1});
                }t2.pop();
                s2sz--;
            }
        } else if(s1sz>1&&s2sz==1) { 
            while(s1sz>1) {
                if(t1.top()=='1') {
                    ans.push_back({1, 3});
                } else {
                    ans.push_back({1, 2});
                }t1.pop();
                s1sz--;
            }
        }
        if(s1sz==1&&s2sz==1) {
            M++;
            if(goesIntoBeaker=='1') {
                ans.push_back({3, 1});
            }else {
                ans.push_back({3, 2});
            }
        }

        cout << M << "\n";
        if(P==2 || P==3) {
            for(pair i: ans) {
                cout << i.first << " " << i.second << "\n";
            }
        }
    }

}