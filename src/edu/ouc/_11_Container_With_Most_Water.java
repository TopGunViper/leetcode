package edu.ouc;

/**
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines,  * which together with x-axis forms a container, such that the container 
 * contains the most water.
 * 
 * Note: You may not slant the container. 
 * @author wqx
 *In this problem, the smart scan way is to set two pointers initialized at both ends of the array. Every time move the smaller value pointer to inner array. Then after the two pointers meet, all possible max cases have been scanned and the max situation is 100% reached somewhere in the scan. Following is a brief prove of this.

Given a1,a2,a3.....an as input array. Lets assume a10 and a20 are the max area situation. We need to prove that a10 can be reached by left pointer and during the time left pointer stays at a10, a20 can be reached by right pointer. That is to say, the core problem is to prove: when left pointer is at a10 and right pointer is at a21, the next move must be right pointer to a20.

Since we are always moving the pointer with the smaller value, i.e. if a10 > a21,
 we should move pointer at a21 to a20, as we hope. Why a10 >a21? 
 Because if a21>a10, then area of a10 and a20 must be less than area of a10 and a21. 
 Because the area of a10 and a21 is at least height[a10] * (21-10) while the area of 
 a10 and a20 is at most height[a10] * (20-10). So there is a contradiction of assumption 
 a10 and a20 has the max area. So, a10 must be greater than a21, then next move a21 has 
 to be move to a20. The max cases must be reached. 
 */
public class _11_Container_With_Most_Water {
	/**
	 * max{(height[i] + height[j]) * (j-i)/2}
	 * @param height
	 * @return
	 * 
	 *  O(n^2) Time Limit Exceeded
	 */
    public int maxArea(int[] height) {
    	int len = height.length;
    	int max = 0;
        for(int i = 0; i < len; i++){
        	for(int j = i + 1; j < len;j++){
        		int h = Math.min(height[i], height[j]);
        		if(max < h * (j-i)){
        			max = h * (j-i);
        		}
        	}
        }
        return max;
    }
    public int maxAreaTLE(int[] height) {
    	int len = height.length;
    	int low = 0; int high = len - 1;
    	
    	int max = 0;
    	while(low < high){
    		max = Math.max(max, (high - low)* Math.min(height[low], height[high]));
    		if(height[low] < height[high]){
    			low++;
    		}else{
    			high--;
    		}
    	}
        return max;
    }
    public int maxArea2(int[] height) {
        int len = height.length, low = 0, high = len -1 ;  
        int maxArea = 0;  
        while (low < high) {  
         maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));  
         if (height[low] < height[high]) {  
           low++;  
         } else {  
           high--;  
         }  
        }  
        return maxArea;  
    }
}
