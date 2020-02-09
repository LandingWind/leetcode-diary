class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        int count=0;
        int sum=0;
        int temp=0;
        for(int i=0;i<k;i++) sum=sum+arr[i];
        if(sum >= threshold*k) count++;
        for(int i=k;i<len;i++) {
            sum = sum+arr[i];
            sum = sum-arr[i-k];
            if(sum >= threshold*k) count++;
        }
        return count;
    }
}