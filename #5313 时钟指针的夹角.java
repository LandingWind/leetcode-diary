class Solution {
    public double angleClock(int hour, int minutes) {
        int m = minutes;
        int h = hour;

        double hh,mm;
        if(h==12)
            hh=(h-12+(double)m/60)*30;
        else
            hh=(h+(double)m/60)*30;
        mm=m*6;
        hh=Math.abs(hh-mm);
        if(hh>180)
            hh=360-hh;
        
        return hh;
    }
}