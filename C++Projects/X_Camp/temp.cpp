#include <bits/stdc++.h>
using namespace std;

int gcd(int a, int b){
    return (b == 0 ? a : gcd(b, a % b));
}
bool check(vector<char> v) {
    return v[0]=='B'&&v[1]=='A'&&v[2]=='C'&&v[3]=='D'&&v[4]=='E';
}

void bruteForce(vector<char> v, int depth ){
    if(depth<=0) return;
    if(check(v)) {
        cout << "YES" << endl;
    } else{
        vector<char> copy = v;
        copy[0] = v[2];
        copy[2] = v[3];
        copy[3] = v[0];
        bruteForce(copy, depth-1);
        copy = v;
        copy[1] = v[3];
        copy[3] = v[4];
        copy[4] = v[1];
        bruteForce(copy, depth-1);
    }
}

vector<int> sequence;
unordered_set<int> used;
int n;
int anscnt=0;

void findTours(int step) {
    if(anscnt>1) return;
    if(step == n-1) {
        for(int num: sequence){
            cout << num << " ";
        }
        cout << n-1;
        cout << endl;
        anscnt++;
        return;
    }
    for (int i = 1; i < n-1; i++) {
        if (used.count(i)) continue; // Skip if already used
        
        // Check if it can be formed by subtracting two earlier elements
        bool valid = false;
        for (int j = 0; j < step; j++) {
            for (int k = 0; k < j; k++) {
                if (abs(sequence[j] - sequence[k]) == i) {
                    valid = true;
                    break;
                }
            }
            if (valid) break;
        }
        
        if (valid) {
            sequence.push_back(i);
            used.insert(i);
            findTours(step + 1);
            sequence.pop_back();
            used.erase(i);
        }
    }
}

int main() {

    cin >> n;
    sequence.push_back(n);
    used.insert(n);
    for(int i=1; i<n-1; i++){
        sequence.push_back(i);
        used.insert(i);
        findTours(2);
        sequence.pop_back();
        used.erase(i);
    }





    // // for(int a=1; a<=100; a++){
    // //     for(int b=a+1; b<=100; b++){
    // //         set<int> vals = {a, b};
    // //         queue<int> q;
    // //         q.push(a);
    // //         q.push(b);
    // //         while(vals.size()<1000 && q.size()>0) {
    // //             int curr = q.front();
    // //             q.pop();
    // //             for(int val: vals) {
    // //                 if(val==curr) continue;
    // //                 if(vals.size()>1000) break;
    // //                 int newVal = (curr+val)/gcd(curr, val);
    // //                 if(!vals.count(newVal)) {
    // //                     q.push(newVal);
    // //                     vals.insert(newVal);
    // //                 }
    // //             }
    // //         }
    // //         if(vals.size()<1000){
    // //             cout << a << " " << b << endl;
    // //         }

    // //     }
    // // }
    // vector<char> v = {'A', 'B', 'C', 'D', 'E'};
    // bruteForce(v, 20);
}