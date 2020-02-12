class Solution {
    public boolean checkIfExist(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        int arr2[] = new int[len];
        for(int i=0;i<len;i++) arr2[i]=arr[i]*2;
        // get set cross
        int i=0,j=0;
        ArrayList<Integer> hs = new ArrayList<>();
        while(i<len && j<len) {
            if(arr[i]<arr2[j]) i++;
            else if(arr[i]>arr2[j]) j++;
            else {
                hs.add(arr[i]);
                i++;j++;
            }
        }
        if(hs.size()>=1) {
            if(hs.size()>1) return true;
            if(hs.get(0) != 0) return true;
        }
        return false;
    }
}

// better
class Solution {
    public boolean checkIfExist(int[] arr) {
        int len = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        int count0=0;
        for(int i:arr) {
            if(i==0) count0++;
            if(i<<1>>1 == i) hs.add(i);
        }
        if(count0>1) {
            for(int i:arr) {
                if(hs.contains(i*2)) return true;
            }
        }
        else {
            for(int i:arr) {
                if(hs.contains(i*2) && i!=0) return true;
            }
        }
        return false;
    }
}