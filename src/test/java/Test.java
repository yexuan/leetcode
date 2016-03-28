import sun.misc.resources.Messages_sv;

import java.util.Map;

/**
 * Created by shuqi.qin on 2016/3/15.
 */
public class Test {

    public static void main(String[] args){

        int x = 4&3;

        x = Integer.MAX_VALUE;



        int y = (int)Math.ceil(Math.log(x)/Math.log(2));

        double b = Math.pow(2,y);



        System.out.println(b>y);
    }

}
