package com.xpx.demo;

/**
 * @author xpxstar@gmail.com
 *
 */
public class DuplicateRemove {
	int[] nums = {1,1,1,1,1,1,2,2,2,2,3,3,4,5,5};
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	 * Do not allocate extra space for another array, you must do this in place with constant memory.
	 * For example,Given input array nums = [1,1,2],
	 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
	 * It doesn't matter what you leave beyond the new length.
	 */
	public int removeDuplicates(int[] nums){
		/*˼·������ָ��i��j. jָ��i����һ����ͬ������
		 * count��ʾ���ҵ��Ĳ�ͬ�������ҵ��µĲ�ͬ��nums[j]��nums[j]���Ƶ�nums[count],count+1
		 * i������lenth-2��j��i+1��ʼѰ���µĲ�ͬ�������ҵ�����j����i������Ѱ�ҡ�
		 * j���ʵ�ĩβ����ʾѰ�ҽ�����
		 * ʱ�临�Ӷ�O(N)
		 */
		int count = 1;
		int i=0,j=0;
		while(i < nums.length-1) {
			j=i+1;
			while(j < nums.length && nums[i]==nums[j]){	
				j++;
			}
			if (j >= nums.length) {
				break;
			}
			nums[count++] = nums[j];
			i=j;
		}
		return count;
	}
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 */
	public int removeDuplicatesII(int[] nums){
		/*˼·ͬ���ظ�����Ҫ����ı�
		 * 1.ͨ����������first�ж��Ƿ��ǵ�һ���ظ���������ǣ���count++�����ƣ����iָ����ǰ�ƣ���first��false
		 * 2.ÿ�ҵ���������Ҫ���³�ʼ��firstΪtrue
		 * ʱ�临�Ӷ�O(N)
		 */
		int count = 1;
		int i=0,j=0;
		boolean first = true;
		while(i < nums.length-1) {
			j=i+1;
			while(j < nums.length && nums[i]==nums[j]){	
				if (first) {
					nums[count++] = nums[j];
					i++;
					first = false;
				}
				j++;
			}
			if (j >= nums.length) {
				break;
			}
			nums[count++] = nums[j];
			i=j;
			first = true;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuplicateRemove dr = new DuplicateRemove();
		System.out.println(dr.removeDuplicates(dr.nums));
		System.out.println(dr.removeDuplicatesII(dr.nums));
	}

}
