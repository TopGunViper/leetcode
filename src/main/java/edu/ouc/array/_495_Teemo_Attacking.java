package edu.ouc.array;

public class _495_Teemo_Attacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0){
            return 0;
        }
        int totalDuration = 0;
        for(int i = 0; i < timeSeries.length - 1; i++){
            int diff = timeSeries[i+1] - timeSeries[i];
            totalDuration += Math.min(diff, duration);
        }
        totalDuration += duration;
        return totalDuration;
    }
}
