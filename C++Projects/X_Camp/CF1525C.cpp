#include<bits/stdc++.h>
using namespace std;

struct robot {
    int idx, pos;
    char d;
};

bool comp(const robot &a, const robot &b) {
    return a.pos < b.pos;
}

int T, N, M;
vector<robot> evens, odds;
vector<int> ans;
vector<int> x;
vector<char> dir;

void calc(bool isEven);

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while(T--) {
        cin >> N >> M;

        x.resize(N);
        dir.resize(N);
        ans.resize(N);
        for(int i=0; i<N; i++) ans[i] = 0;

        for(int i=0; i<N; i++){
            int k; cin >> k;
            x[i] = k;
        } for(int i=0; i<N; i++){
            char k; cin >> k;
            dir[i] = k;
        }

        evens.clear();
        odds.clear();

        for(int i=0; i<N; i++){
            if(x[i] %2==0) {
                evens.push_back({i, x[i], dir[i]});
            } else{
                odds.push_back({i, x[i], dir[i]});
            }
        }

        sort(evens.begin(), evens.end(), comp);
        sort(odds.begin(), odds.end(), comp);
        
        
        calc(true);
        calc(false);

        for(int i: ans){
            cout << i << " ";
        }cout << endl;

    }
}

void calc(bool isEven) {

    stack<robot> stack;
    if(isEven) {
        for(robot i: evens) {
            if(i.d == 'L' &&
            !stack.empty() && 
            stack.top().d == 'R') {
                robot j = stack.top(); stack.pop();
                int timeToCollide = abs(i.pos-j.pos) / 2;
                ans[i.idx] = timeToCollide;
                ans[j.idx] = timeToCollide;
            } else{
                stack.push(i);
            }
        }
    } else {
        for(robot i: odds) {
            if(i.d == 'L' &&
            !stack.empty() && 
            stack.top().d == 'R') {
                robot j = stack.top(); stack.pop();
                int timeToCollide = abs(i.pos-j.pos) / 2;
                ans[i.idx] = timeToCollide;
                ans[j.idx] = timeToCollide;
            } else{
                stack.push(i);
            }
        }
    }

    bool hasRightLeftOver = false;
    bool hasLeftLeftOver = false;
    robot rightLeftOver;
    robot leftLeftOver;

    while(!stack.empty() && stack.top().d == 'R') {
        robot first = stack.top(); stack.pop();
        if(!stack.empty() && stack.top().d == 'R') {
            robot second = stack.top(); stack.pop();
            int timeToCollide = M-(first.pos+second.pos)/2;
            ans[first.idx] = timeToCollide;
            ans[second.idx] = timeToCollide;
        } else{
            hasRightLeftOver = true;
            rightLeftOver = first;
        }
    }

    if(stack.size()%2==1) {
        hasLeftLeftOver = true;
        leftLeftOver = stack.top(); stack.pop();
    }

    while(!stack.empty()) {
        robot first = stack.top(); stack.pop();
        robot second = stack.top(); stack.pop();
        int timeToCollide = (first.pos+second.pos)/2;
        ans[first.idx] = timeToCollide;
        ans[second.idx] = timeToCollide;
    }


    if(hasRightLeftOver && hasLeftLeftOver) {
        int timeToCollide = (leftLeftOver.pos + (M-rightLeftOver.pos) + M)/2;
        ans[leftLeftOver.idx] = timeToCollide;
        ans[rightLeftOver.idx] = timeToCollide;
    } else if(hasRightLeftOver) {
        ans[rightLeftOver.idx] = -1;
    } else if(hasLeftLeftOver) {
        ans[leftLeftOver.idx] = -1;
    }

}