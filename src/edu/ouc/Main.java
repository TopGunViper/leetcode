package edu.ouc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//_283_MoveZeroes_Easy test = new _283_MoveZeroes_Easy();
		_1_TwoSum_Medium test = new _1_TwoSum_Medium(); 
		int[] nums = {0,4,3,0};
		int [] result = new int[2];
		int target = 0;
		result = test.twoSum2(nums, target);
		for(Integer a : result){
			System.out.println(a + ",");
		}
	}

}
