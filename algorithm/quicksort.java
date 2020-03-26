package algorithm;

public class quicksort {
    public static void main(String[] args) {
        int arr[] = {72,6,57,88,60,42,83,73,48,85};
        quicksort a = new quicksort();
        a.revsort(arr, 0, arr.length-1);
        // output
        for(int i:arr) {
            System.out.print(i+" ");
        }
    }
    // small to big
    public void sort(int[] arr, int l, int r) {
        if(l<r) {
            int i=l;
            int j=r;
            int x=arr[l];
            while(i<j) {
                while(i<j && arr[j]>=x) j--;
                if(i<j) {
                    arr[i]=arr[j];
                    i++;
                }
                while(i<j && arr[i]<=x) i++;
                if(i<j) {
                    arr[j]=arr[i];
                    j--;
                } 
            }
            arr[i]=x;
            sort(arr, l, i-1);
            sort(arr, i+1, r);
        }
    }
    // big to small
    public void revsort(int[] arr, int l, int r) {
        if(l<r) {
            int i=l;
            int j=r;
            int x=arr[l];
            while(i<j) {
                while(i<j && arr[j]<=x) j--;
                if(i<j) {
                    arr[i]=arr[j];
                    i++;
                }
                while(i<j && arr[i]>=x) i++;
                if(i<j) {
                    arr[j]=arr[i];
                    j--;
                } 
            }
            arr[i]=x;
            revsort(arr, l, i-1);
            revsort(arr, i+1, r);
        }
    }
}