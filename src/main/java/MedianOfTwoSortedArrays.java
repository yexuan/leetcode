import java.util.Arrays;

/**
 There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {


    private double findKth(int[] nums1,int[] nums2,int m,int n,int k){

        if (m>n){
            return findKth(nums2,nums1,n,m,k);
        }

        if (m==0){
            return nums2[k-1];
        }
        if (k==1){
            return Math.min(nums1[0],nums2[0]);
        }

        int pa = Math.min(k / 2, m), pb = k - pa;

        if (nums1[pa-1]<nums2[pb-1]){
            return findKth(Arrays.copyOfRange(nums1,pa,m),nums2,m-pa,n,k-pa);
        }else if (nums1[pa-1]>nums2[pb-1]){
            return findKth(Arrays.copyOfRange(nums1,pa,m),nums2,m-pa,n,k-pa);
        }else {
            return nums1[pa-1];
        }

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;

    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6};

        int m = a.length;

        int bp = 2;
        int[] b = Arrays.copyOfRange(a,bp,m);


        System.out.println(b);
        System.out.println(b.length);
        System.out.println(m-bp);
    }


}
