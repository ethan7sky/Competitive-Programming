#include <bits/stdc++.h>
using namespace std;
using ll = long long;
 
const ll MOD = 1e9+7;
 
int n, m;
ll dp[1000][(1<<10)];
vector<int> bitmasks;
 
int findLSB(int n){
    int k = __builtin_clz(n);
    return 1<<(31-k);
}

bool canBeFinal(int bitmask) {
    bitmask = bitmask ^ ((1<<n)-1);
    //cout << bitmask << endl;
    while(bitmask!=0){
        int lsb = findLSB(bitmask);

        if(lsb==1) {
            return false;
        }
        if(bitmask & (lsb/2)) {
            bitmask = bitmask^lsb^(lsb/2);
        }
        else{
            return false;
        }
    }
    return true;
}

void calcFinalMasks(int prevMask, int currMask) {
    int zeroMask = prevMask ^ ((1<<n)-1);
    if(zeroMask==0) {
        bitmasks.push_back(currMask);
        return;
    }
    int lsb = findLSB(zeroMask);
 
    if(lsb==1){
        return;
    }
    else{
        if((zeroMask & (lsb/2))){
            calcFinalMasks(prevMask|lsb|(lsb/2), currMask);
        }
        else{
            return;
        }
    }
}
 
void calcMasks(int prevMask, int currMask) {
    int zeroMask = prevMask ^ ((1<<n)-1);
    //cout << prevMask << " " << currMask << " " << zeroMask << endl;
    if(zeroMask==0) {
        bitmasks.push_back(currMask);
        return;
    }
    int lsb = findLSB(zeroMask);
 
    if(lsb==1){
        bitmasks.push_back(currMask|1);
        return;
    }
    else{
        if((zeroMask & lsb/2)){
            calcMasks(prevMask|lsb|(lsb/2), currMask);
        }
        calcMasks(prevMask|lsb, currMask|lsb);
    }
}
 
int calc(int col, int bitmask) {

    //cout << col << " " << bitmask << endl;
 
    if(dp[col][bitmask]!=-1) return dp[col][bitmask];
 
    else{
        if(col==m-1) {

            //cout << "here "<<bitmask << endl;

            if(canBeFinal(bitmask)){
                //cout << "HERE!" << endl;
                dp[col][bitmask] = 1;
                return 1;
            }
            else{
                dp[col][bitmask] = 0;
                return 0;
            }
        }
        else{
            bitmasks.clear();
            calcMasks(bitmask, 0);
            int sum = 0;
            for(int mask: bitmasks) {
                sum += calc(col+1, mask);
                sum %= MOD;
            }
            dp[col][bitmask] = sum;
            return sum;
        }
    }
}
 
int main() {
 
    for(int i=0; i<1000; i++){
        for(int j=0; j<(1<<10); j++){
            dp[i][j] = -1;
        }
    }
 
    cin >> n >> m;
 
    calc(0, 0);
 
    cout << dp[0][0] << endl;
}
