package com.xpx.demo;

/**
 * @author xpxstar@gmail.com
 */
public class RotatedSearch {
	int[] nums = {4,5,6,7,8,9,10,11,12,13,0,1,2,3};
	int[] nums2 = {1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1};
	/**
	 * @param nums
	 * @param target
	 * @return
	 * @author xpxstar@gmail.com
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * You are given a target value to search. If found in the array return its index, otherwise return -1.
	 * You may assume no duplicate exists in the array.
 	 */
	public int searchNoDuplicate(int[] nums, int target) {
		/*˼·�� ��ȡnums����l�����֣��õ�mid=l/2,
		 * �����������
		 * 1.start~mid��������target�ڸö�
		 * 2.start~mid�ǵ�������target�ڸö�		
		 * 3.mid~end��������target��
		 * 4.mid~end�ǵ�������target��
		 * ����������4��������������ֲ���
		 * �������ϣ�����false
		 * ����ʹ��ѭ�����ߵݹ�ʵ��
		 * ʱ�临�Ӷ�O(lgN)
		 */
		int len = nums.length;
        return binarySearch(0,len-1,nums,target);
    }
		private int binarySearch(int start,int end,int[] nums,int target){
			if (start == end) {
				return nums[start] == target?start:-1;
			}
			int middle = (start+end)/2;
			if(nums[start] <= nums[middle] && nums[start] <= target && nums[middle] >= target){//������target��
				return binarySearch(start,middle,nums,target);
			}else if (nums[start] >nums[middle] && !(nums[start] > target && nums[middle] < target)) {//�ǵ�����target������
				return binarySearch(start,middle,nums,target);
			}else if(nums[middle+1] <= nums[end] && nums[middle+1] <= target && nums[end] >= target){//������target��
				return binarySearch(middle+1,end,nums,target);
			}else if(nums[middle+1] > nums[end] && !(nums[middle+1] > target && nums[end] < target)){//�ǵ�����target������
				return binarySearch(middle+1,end,nums,target);
			}else{
				return -1;
			}
		}
	/**
	 * @param nums
	 * @param target
	 * @return
	 * @author xpxstar@gmail.com
	 * Follow up for "Search in Rotated Sorted Array":
	 * What if duplicates are allowed?
	 * Would this affect the run-time complexity? How and why?
	 * Write a function to determine if a given target is in the array.
	 */
	public boolean searchDuplicate(int[] nums, int target) {
		/*˼·.����˼��ͬ���ظ����飬��������������Ҫ���⴦��
		 * 1.����ֵ�����ڣ�����true������false
		 * 2.�ظ�������������β��ͬ�����ｫ��ʼ��ǰ�ƣ��ų��ظ���
		 * ʱ�临�Ӷȣ�ƽ��O(lgN)���O(N)
		 */
		int len = nums.length;
        return binaryBiSearch(0,len-1,nums,target);
    }
		private boolean binaryBiSearch(int start,int end,int[] nums,int target){
			if (start == end) {
				return nums[start] == target?true:false;
			}
			if (nums[start]==nums[end]){start++;return binaryBiSearch(start,end,nums,target);};
			int middle = (start+end)/2;
			if(nums[start] <= nums[middle] && nums[start] <= target && nums[middle] >= target){//�ǵݼ���target��
				return binaryBiSearch(start,middle,nums,target);
			}else if (nums[start] >nums[middle] && !(nums[start] > target && nums[middle] < target)) {//�ǵ�����target������
				return binaryBiSearch(start,middle,nums,target);
			}else if(nums[middle+1] <= nums[end] && nums[middle+1] <= target && nums[end] >= target){//������target��
				return binaryBiSearch(middle+1,end,nums,target);
			}else if(nums[middle+1] > nums[end] && !(nums[middle+1] > target && nums[end] < target)){//�ǵ�����target������
				return binaryBiSearch(middle+1,end,nums,target);
			}else{
				return false;
			}
		}
	public static void main(String args[]) {
		RotatedSearch rs = new RotatedSearch();
		System.out.println(rs.searchNoDuplicate(rs.nums, 11));
		System.out.println(rs.searchDuplicate(rs.nums2, 3));
	}
}
