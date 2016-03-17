/**
 Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x>-1&&x<10){
            return true;
        }else if (x<0){
            return false;
        }

        double absX = Math.abs((double)x);

        int digit = (int)Math.floor(Math.log10(absX));

        int low = 0;
        int high = digit;
        boolean flag = true;

        while (low<high){
            int left = (int)(absX/Math.pow(10,low));
            int right = (int)(absX/Math.pow(10,high));

            if ((left%10)!=(right%10)){
                return false;
            }
            low++;
            high--;
        }


        return flag;

    }


    public static void main(String[] args){


        isPalindrome(11);
    }

}
