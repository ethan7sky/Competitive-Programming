#include <bits/stdc++.h>

using namespace std;

const int N = 10e5;
int maxdiv[N];

int main() {

    for(int i=2; i<N; i++){
        if(maxdiv[i]==0){
            for(int j=i; j<N; j+=i){
                maxdiv[j] = i;
            }
        }
    }

    int x; cin >> x;
    

}