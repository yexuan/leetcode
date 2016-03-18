import java.util.*;

/**
 Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {

    /*
    复杂度太高，最坏的情况（就是各个回文相互重叠的时候。例如"aaaaaaaaaa"和" cabcbabcbabcba"）cost太高
    */
    public static String longestPalindromeV0(String s) {

        if (s.length()<=1){
            return s;
        }

        if ((s.length()&1)==1){
            if (s.substring(0,s.length()/2).equals(s.substring(s.length()/2+1,s.length()))){
                return s;
            }
        }else{
            if (s.substring(0,s.length()/2).equals(s.substring(s.length()/2,s.length()))){
                return s;
            }
        }

        String res = "";

        Map<String,List<Integer>> sIndexMap = new HashMap<String, List<Integer>>();

        for (int i = 0;i<s.length();i++){
            String key = String.valueOf(s.charAt(i));
            if (sIndexMap.containsKey(key)){
                sIndexMap.get(key).add(i);
            }else{
                sIndexMap.put(key,new ArrayList<Integer>());
                sIndexMap.get(key).add(i);
            }
        }

        Map<Double,Integer> blackIndex = new HashMap<Double, Integer>();

        int maxLength = 1;


        for (String key:sIndexMap.keySet()){
            if (sIndexMap.get(key).size()>1){
                for (int i = 0;i<sIndexMap.get(key).size();i++){
                    for (int j = sIndexMap.get(key).size()-1;j>i;j--){
                        int sbegin = sIndexMap.get(key).get(i);
                        int send = sIndexMap.get(key).get(j);

                        int curLength = send-sbegin+1;

                        if (send-sbegin+1<=maxLength){
                            break;
                        }

                        double mid;

                        if ((curLength&1)==1){
                            mid = curLength/2+1;
                        }else {
                            mid = (curLength-1)/2;
                        }

                        if (blackIndex.containsKey(mid)){
                            if (blackIndex.get(mid)<=curLength){
                                continue;
                            }
                        }

                        if ((isPalindrome(s.substring(sbegin,send+1)))){
                            maxLength = curLength;
                            res = s.substring(sbegin,send+1);
                        }else {
                             blackIndex.put(mid,curLength);
                        }
                    }
                }
            }
        }


        return res;
    }

    public static String longestPalindromeV1(String s){
        return null;
    }

    private static boolean isPalindrome(String s){

        int left = 0;
        int right = s.length()-1;

        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length()==0)
            return "";
        boolean[][] palin = new boolean[s.length()][s.length()];
        String res = "";
        int maxLen = 0;
        for(int i=s.length()-1;i>=0;i--)
        {
            for(int j=i;j<s.length();j++)
            {
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || palin[i+1][j-1]))
                {
                    palin[i][j] = true;
                    if(maxLen<j-i+1)
                    {
                        maxLen=j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){

        String testStr = "abajdifuehheudnslaiedhf";

        testStr = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(longestPalindromeV0(testStr));


    }
}
