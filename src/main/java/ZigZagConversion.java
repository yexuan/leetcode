/**
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {

        if (numRows<=1){
            return s;
        }

        String res = "";
        String[] resVec = new String[numRows];

        for (int i=0;i<numRows;i++){
            resVec[i]="";
        }

        int index = 0;
        int increment = 1;

        for (int i =0;i<s.length();i++){
            resVec[index] = resVec[index]+s.charAt(i);
            if (index>=numRows-1||(index<=0&&i>0)){
                increment = increment*(-1);
            }
            index = index+increment;
        }

        for (int j = 0;j<numRows;j++){
            res = res + resVec[j];
        }

        return res;

    }

    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
