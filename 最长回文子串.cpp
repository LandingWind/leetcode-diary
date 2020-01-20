#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string longestPalindrome(string s) {
    int slen = s.length();
    if(slen == 0 || slen == 1) return s;
    int start=0;
    int maxLen=1;
    int map[slen][slen]; 
    memset(map, 0, sizeof(map));
    // map[i][j] means (i to j) is longestPalindrome or not
    // init the map
    for(int i=0;i<slen;i++)
    {
        map[i][i]=1;
        if(i<slen-1 && s[i]==s[i+1]) 
        {
            map[i][i+1] = 1;
            maxLen = 2;
            start = i;
        }
    }
    // dynamical update
    for(int i=3;i<=slen;i++)
    {
        for(int j=0;j<slen-i+1;j++)
        {
            int end=j+i-1;
            if(s[j]==s[end] && map[j+1][end-1])
            {
                map[j][end]=1;
                start = j;
                maxLen = i;
            }
        }
    }
    return s.substr(start, maxLen);
}
int main()
{
    string str;
    cin >> str;
    cout << longestPalindrome(str) << endl;
}
