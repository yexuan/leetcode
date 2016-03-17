/**
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 */
public class ReverseInteger {

    public static int reverse(int x) {

        if (x>=-9&&x<=9){
            return x;
        }
        String xStr = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder();

        String flag = "";

        int beginIndex = 0;

        if (xStr.startsWith("-")){
            flag = "-";
            beginIndex++;
        }

        for (int i = xStr.length()-1;i>=beginIndex;i--){
            stringBuilder.append(xStr.charAt(i));
        }

        String res = "";

        for (int i=0;i<stringBuilder.toString().length();i++){
            if (stringBuilder.charAt(i)!='0'){
                res = stringBuilder.toString().substring(i);
                break;
            }
        }

        try {
            return Integer.parseInt(flag+res);
        }catch (Exception e){
            return Integer.MAX_VALUE;
        }

    }

    public static int reverseNew(int x) {

        double res = 0;


        while (x != 0){
            int tmp = x%10;

            res = res*10 + tmp;

            if (res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
                return 0;
            }

            x = x/10;
        }

        return (int)res;

    }

    public static void main(String[] args){
        System.out.println(reverseNew(1534236469));
        System.out.println(reverse(-321));
    }

}
