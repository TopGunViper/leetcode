package edu.ouc;

public class _283_MoveZeroes_Easy {
	 public void moveZeroes(int[] nums) {
		 int start = 0,end = start;
		 int len = nums.length;
		 //start ��0��end�ҷ�0, ��start��ĵ�һ���������end��start����������end��Ϊ0
		 while(end != len){
			 while(start < len && nums[start] != 0) start++;
			 end = start;
			 while(end < len && nums[end] == 0) end++;
			 if(end != len){
				int tmp = nums[start];
				nums[start] = nums[end];
				nums[end] = tmp;
			 }else{
				 break;
			 }
		 }
//		 for(int i = 0 ; i < nums.length ; i++){
//			 System.out.println(nums[i] + ",");
//		 }
	 }
	 public void moveZeroes2(int[] nums) {
		    int i = 0;
		    for (int n : nums) {
		        if (n != 0)
		            nums[i++] = n;
		    }
		    while (i < nums.length) nums[i++] = 0;
	}
}
