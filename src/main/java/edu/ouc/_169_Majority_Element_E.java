package edu.ouc;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element 
 * that appears more than n/2 times.

You may assume that the array is non-empty and the majority element always exist 
in the array.
 * @author wqx
 * �Լ��Ľⷨ����HashMap��keyΪ�����е�ֵ��valueΪֵ���ֵĴ���
 * ʱ�临�Ӷȣ�O(n),�ռ临�Ӷȣ�O(n)
 * 
 * Moore's voting algorithm��
 * ���㷨˼�룺
 * ÿ���ҳ�һ�Բ�ͬ��Ԫ�أ���������ɾ����ֱ������Ϊ�ջ�ֻʣһ��Ԫ�ء�
 * ����֤�����������Ԫ��e���ִ������룬��ô���ʣ�µ�ֻ������e��
 * ʱ�临�Ӷȣ�O(n),�ռ临�Ӷȣ�O(1)
 */
public class _169_Majority_Element_E {
    public int majorityElement(int[] nums) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	if(nums.length == 1) return nums[0];
    	int threshold = nums.length / 2;
    	for(int i = 0; i < nums.length; i++){
    		Integer size = map.get(nums[i]);
    		if(size == null){
    			map.put(nums[i], 1);
    		}else if(size >= threshold){
    			return nums[i];
    		}else{
    			map.put(nums[i], size+1);
    		}
    	}
        return 0;
    }
    public static void main(String args[]){
        int a[] = {1,3,1,3,1,2,2,1,1,4,4};
        printMajority(a, a.length);
    }
     static void printMajority(int a[],int size)
    {
      /* �ҵ����ܵĺ�ѡԪ�� */
      int cand = findCandidate(a,a.length);
      
      /* �жϸ�Ԫ�س��ִ����Ƿ񳬹�n/2 */
      if(isMajority(a, a.length, cand))
        System.out.println("cand:" + cand);
      else
    	  System.out.println("NO Majority Element");
    }
    /**
     * �ҵ����ܵĺ�ѡԪ��  
     * @param a
     * @param size
     * @return
     */
    static int findCandidate(int a[], int size)
    {
    	/*
    	 * maj_index����ǰ���ִ�������Ԫ���±꣬��ʼΪ0������һ��Ԫ�أ�
    	 * count�����ִ�������Ԫ�صĳ��ִ�������ʼΪ1
    	 */
        int maj_index = 0, count = 1;
        int i;
        for(i = 1; i < size; i++)
        {
            if(a[maj_index] == a[i])
            	count++;
            else 
            	count--;
            if(count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }
      
    /* �жϺ�ѡԪ��can���ִ����Ƿ񳬹�n/2 */
    static boolean isMajority(int a[], int size, int cand)
    {
        int i, count = 0;
        for (i = 0; i < size; i++)
          if(a[i] == cand)
             count++;
        if (count > size/2)
           return true;
        else
           return false;
    }
}
