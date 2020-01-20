#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int trap(vector<int>& height) {
    int len = height.size();
    int t,m;
    int rain=0;
    vector<int> mheight; // mheight: height with rain
    for(int i=0;i<len;i++) mheight.push_back(height[i]);
    for(int i=1;i<len-1;i++)
    {
        if(height[i]<height[i+1])
        {
            t = height[i+1];
            int j,maxV=0,maxP=0;
            for(j=i;j>=0;j--)
            {
                if(height[j]>=t) {
                    maxV = t;
                    maxP = j;
                    break;
                }
                if(height[j]>maxV)
                {
                    maxV = height[j];
                    maxP = j;
                }
            }
            for(int k=maxP+1;k<=i;k++) mheight[k] = maxV;
        }
    }
    for(int i=0;i<len;i++) 
    {
        cout << mheight[i] << " ";
        rain += mheight[i]-height[i];
    }
    cout << endl;
    return rain;
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
    cout << trap(data) << endl;
}