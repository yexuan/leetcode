/**
 * Created by shuqi.qin on 2016/3/15.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMinVersion0(int[] nums) {

        int min = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]<min){
                min = nums[i];
                break;
            }
        }

        return min;

    }

    public static int findMinVersion1(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int mid;

        int min = Integer.MAX_VALUE;

        while (left<=right){
            mid = left+(right-left)/2;
            if (nums[left]<=nums[right]) return Math.min(nums[left],min);
            if (nums[mid]>=nums[left]){
                left = mid+1;
            }else {
                min = Math.min(min,nums[mid]);
                right = mid-1;
            }
        }

        return min;

    }

    public static void main(String[] args){
        int[] test = {3,1,2};
        findMinVersion1(test);
    }
}
