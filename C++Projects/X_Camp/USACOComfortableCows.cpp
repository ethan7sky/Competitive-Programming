#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAX_N = (int)1e5+10;
const int MAX_DIM = 1001;
int N, cnt;
bool hasCow[3*MAX_DIM][3*MAX_DIM];
vector<int> xAdj = {0, 0, -1, 1, 0}, yAdj = {1, -1, 0, 0, 0};

void ff(int x, int y);
pair<int, int> adjacentCowCalc(int x, int y);

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i=0; i<N; i++){
        int x, y; cin >> x >> y;
        x+=1000; y+=1000;
        if(hasCow[x][y]) cnt--;
        else {
            hasCow[x][y] = true;
            ff(x, y);
        }
        cout << cnt << "\n";
    }
}
void ff(int x, int y) {
    for(int i=0; i<5; i++){
        int x2 = x+xAdj[i];
        int y2 = y+yAdj[i];
        if(hasCow[x2][y2]) {
            pair calc = adjacentCowCalc(x2, y2);
            if(calc.first == 3) {
                cnt++;
                hasCow[x2+xAdj[calc.second]][y2+yAdj[calc.second]] = true;
                ff(x2+xAdj[calc.second], y2+yAdj[calc.second]);
            }
        }
    }
}
pair<int, int> adjacentCowCalc(int x, int y){
    int adjCnt = 0;
    int emptyPos = 4;
    for(int i=0; i<4; i++){
        if(hasCow[x+xAdj[i]][y+yAdj[i]]) adjCnt++;
        else emptyPos = i;
    }
    return {adjCnt, emptyPos};
}