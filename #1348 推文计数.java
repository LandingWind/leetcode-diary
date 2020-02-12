class TweetCounts {
    HashMap<String,ArrayList<Integer>> hm;
    int minute = 60;
    int hour = 3600;
    int day = 3600*24;
    public TweetCounts() {
        this.hm=new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        if(!hm.containsKey(tweetName)) {
            hm.put(tweetName, new ArrayList<Integer>());
        }
        ArrayList<Integer> tmp = hm.get(tweetName);
        tmp.add(time);
        hm.put(tweetName, tmp);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int delta=0;
        if(freq.equals("minute")) delta=this.minute;
        else if(freq.equals("hour")) delta=this.hour;
        else if(freq.equals("day")) delta=this.day;
        else System.out.println("freq error!");

        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> arr = this.hm.get(tweetName);
        int pos=startTime;
        // int arrpos=0;
        while(pos<=endTime) {
            int count=0;
            int endpos=pos+delta;
            // int temparrpos=arrpos;
            for(int k=0;k<arr.size();k++) {
                int temp=arr.get(k);
                // System.out.println(temp);
                if(temp>=pos && temp<endpos && temp<=endTime) count++;
                // else if(temp>=endpos) break;
                // temparrpos++;
            }
            res.add(count);
            pos=endpos;
            // arrpos=temparrpos;
        }
        return res;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */