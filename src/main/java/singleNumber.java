/**
 Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Subscribe to see which companies asked this question
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {

        if (nums.length==1){
            return nums[0];
        }

        int res = nums[0];

        for (int i = 1;i<nums.length;i++){
            res = res^nums[i];
        }

        return res;

    }
}
