import java.util.Arrays;

/**
 There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {


    private static double findKth(int[] nums1,int[] nums2,int m,int n,int k){

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
            if(pa==m){
                return findKth(null,nums2,0,n,k-pa);
            }
            return findKth(Arrays.copyOfRange(nums1,pa,m),nums2,m-pa,n,k-pa);
        }else if (nums1[pa-1]>nums2[pb-1]){
            if (pb==n){
                return findKth(nums1,null,m,0,pa);
            }
            return findKth(nums1,Arrays.copyOfRange(nums2,pb,n),m,n-pb,pa);
        }else {
            return nums1[pa-1];
        }

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalLength = nums1.length+nums2.length;

        int k = totalLength/2+(totalLength&1);

        if ((totalLength&1)==1){
            return findKth(nums1,nums2,nums1.length,nums2.length,k);
        }else{
            return 0.5*(findKth(nums1,nums2,nums1.length,nums2.length,k)+findKth(nums1,nums2,nums1.length,nums2.length,k+1));
        }


    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6};

        int[] b = {34,26,40,51};

        int m = a.length;


        double x = findMedianSortedArrays(a,b);

        System.out.println(x);

        a = new int[]{};
        //b = new int[1];
        b[0]=1;

        x = findMedianSortedArrays(a,b);

        System.out.println(x);

    }


}
