#include <iostream>

using namespace std;

int main(){

    //  #ifndef ONLINE_JUDGE 
    // freopen("IO_SPACE/input.txt", "r", stdin); 
    // freopen("IO_SPACE/output.txt", "w", stdout); 
    // #endif
    // ios_base::sync_with_stdio(0);
    // cin.tie(0);

    int t;
    cin >> t;
    for(int tc = 0; tc < t; tc++){
        int a;
        int b;
        cin >> a >> b;
        string s;
        cin >> s;
        int zeroCount = 0;
        int oneCount = 0;
        int n = s.length();
        bool imp = false;
        for(int i = 0; i < n; i++){
            if((s[i] == '?') == (s[n-i-1] == '?')){
                if(s[i] != s[n-i-1]){
                    imp = true;
                }
            }else{
                if(s[i] == '1' || s[n-i-1] == '1'){
                    s[i] = '1';
                    s[n-i-1] = '1';
                }else{
                    s[i] = '0';
                    s[n-i-1] = '0';
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(s[i] == '0'){
                zeroCount++;
            }else if(s[i] == '1'){
                oneCount++;
            }
        }
        if(!imp && (zeroCount <= a && oneCount <= b)){
            if(n%2 == 0){
                if(a%2 == 0 && b%2 == 0){
                    for(int i = 0; i < n; i++){
                        if(s[i] == '?'){
                            if(zeroCount < a){
                                zeroCount += 2;
                                s[i] = '0';
                                s[n-i-1] = '0';
                            }else{
                                oneCount += 2;
                                s[i] = '1';
                                s[n-i-1] = '1';
                            }
                        }
                   }
                    cout << s << endl;
                }else{
                    cout << -1 << endl;
                }
            }else{
                if(s[n/2] == '?'){
                    if((a%2+b%2) == 1){
                        if(a%2 == 0){
                            s[n/2] = '1';
                            oneCount++;
                        }else{
                            s[n/2] = '0';
                            zeroCount++;
                        }
                        for(int i = 0; i < n; i++){
                            if(s[i] == '?'){
                                if(zeroCount < a){
                                    zeroCount += 2;
                                    s[i] = '0';
                                    s[n-i-1] = '0';
                                }else{
                                    s[i] = '1';
                                    s[n-i-1] = '1';
                                }
                            }
                        }
                        cout << s << endl;
                    }else{
                        cout << -1 << endl;
                    }
                }else{
                    if(s[n/2] == '0' && a%2 == 1 && b%2 == 0){
                        for(int i = 0; i < n; i++){
                            if(s[i] == '?'){
                                if(zeroCount < a){
                                    zeroCount += 2;
                                    s[i] = '0';
                                    s[n-i-1] = '0';
                                }else{
                                    s[i] = '1';
                                    s[n-i-1] = '1';
                                }
                            }
                        }
                        cout << s << endl;
                    }else if(s[n/2] == '1' && a%2 == 0 && b%2 == 1){
                        for(int i = 0; i < n; i++){
                            if(s[i] == '?'){
                                if(zeroCount < a){
                                    zeroCount += 2;
                                    s[i] = '0';
                                    s[n-i-1] = '0';
                                }else{
                                    s[i] = '1';
                                    s[n-i-1] = '1';
                                }
                            }
                        }
                        cout << s << endl;
                    }else{
                        cout << -1 << endl;
                    }
                    
                }
            }
        }else{
            cout << -1 << endl;
        }
    }
}