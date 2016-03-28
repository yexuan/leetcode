/**
 * Created by qq on 2016/3/28.
 */
public class CountingBits {

    public static int[] countBits(int num) {

        int[] res = new int[num+1];


        int bits = (int)Math.ceil(Math.log(num)/Math.log(2));


        res[0] = 0;
        for (int i = 0;i<bits;i++){

            for (int j=(int)Math.pow(2,i);j<Math.min(num+1,(int)Math.pow(2,i+1));j++){
                res[j] = res[j-(int)Math.pow(2,i)]+1;
            }

        }
        if (res[num]==0){
            res[num] = 1;
        }
        return res;
    }

    public static void main(String[] args){
        int[] x = countBits(0);

        x = countBits(2);

        x = countBits(1);
        System.out.println();
    }
}
