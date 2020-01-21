#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int maxArea(vector<int>& height) {
    int len = height.size();
    int i=0;
    int j=len-1;
    int max = 0;
    int t;
    while(i!=j)
    {
        t=min(height[i],height[j])*(j-i);
        if(t>max) max=t;
        if(height[i]>=height[j]) j--;
        else i++;
    }
    return max;
}

int main()
{
    vector<int> data;
    int n;
    int temp;
    cin >> n;
    for(int i=0;i<n;i++) 
    {
        cin >> temp;
        data.push_back(temp);
    }
    cout << maxArea(data) << endl;
}