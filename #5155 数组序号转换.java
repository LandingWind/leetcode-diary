class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int len = arr.length;
        
        HashSet<Integer> hashSet = new HashSet<Integer>(); 
        for (int i = 0; i < len; i++){
            hashSet.add(arr[i]);
        }
        Set<Integer> set = new TreeSet(hashSet);           
        Integer[] integers = set.toArray(new Integer[]{});

        int[] arr2 = new int[integers.length];           
        for (int i = 0; i < integers.length; i++){
            arr2[i] = integers[i].intValue();
        }
        
        int res[] = new int[len];
        // for(int i=0;i<len;i++) {
        //     System.out.println(arr2[i]);
        // }
        
        for(int i=0;i<len;i++) {
            res[i] = Arrays.binarySearch(arr2, arr[i])+1;
        }
        return res;
    }
}