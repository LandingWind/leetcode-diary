// 有点取巧 但是双100了不是吗hh

class Solution {
    public int maxJumps(int[] arr, int d) {
        int len = arr.length;
        int max=0;
        int []tt = new int[len];
        for(int i=0;i<len;i++) tt[i]=1;
        boolean flag=true;
        while(flag) {
            flag=false;
            // 顺着更新一次
            for(int j=0;j<len;j++) {
                int temp = 0;
                for(int k=j+1;k<=j+d;k++) {
                    if(k>=len) break;
                    if(arr[j]<=arr[k]) break;
                    temp = Math.max(temp, 1+tt[k]);
                }
                for(int k=j-1;k>=j-d;k--) {
                    if(k<0) break;
                    if(arr[j]<=arr[k]) break;
                    temp = Math.max(temp, 1+tt[k]);
                }
                if(tt[j]<temp) {
                    tt[j] = temp;
                    flag = true;
                }
            }
            // 倒着更新一次
            for(int j=len-1;j>=0;j--) {
                int temp = 0;
                for(int k=j+1;k<=j+d;k++) {
                    if(k>=len) break;
                    if(arr[j]<=arr[k]) break;
                    temp = Math.max(temp, 1+tt[k]);
                }
                for(int k=j-1;k>=j-d;k--) {
                    if(k<0) break;
                    if(arr[j]<=arr[k]) break;
                    temp = Math.max(temp, 1+tt[k]);
                }
                if(tt[j]<temp) {
                    tt[j] = temp;
                    flag = true;
                }
            }
            // debug print
            // for(int j=0;j<len;j++) {
            //     System.out.print(tt[j]+" ");
            // }
            // System.out.println();
        }
        for(int i=0;i<len;i++) {
            max = Math.max(max, tt[i]);
        }
        return max;
    }
}