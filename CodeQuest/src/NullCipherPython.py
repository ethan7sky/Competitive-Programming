n = int(input())

for i in range(n):
    s = input()
    ans = ""
    for j in range(len(s)-1):
        if(s[j]=='A' or s[j]=='E' or s[j]=='U' or s[j]=='O' or s[j]=='I'):
            ans += s[j+1]
            j = j+1
    print(ans)
