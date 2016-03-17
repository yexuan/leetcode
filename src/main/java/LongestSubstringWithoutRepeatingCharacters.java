import java.util.*;

/**
 Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> lastShownIndex = new HashMap<Character, Integer>();

        int maxLength = 0;

        String currentMaxSubstring = "";

        int beginIndex = 0;

        for (int i =0;i<s.length();i++){



            if (!lastShownIndex.containsKey(s.charAt(i))||lastShownIndex.get(s.charAt(i))<beginIndex){
                currentMaxSubstring = currentMaxSubstring+s.charAt(i);
                lastShownIndex.put(s.charAt(i),i);
            }else {
                beginIndex = lastShownIndex.get(s.charAt(i))+1;
                currentMaxSubstring = s.substring(beginIndex,i+1);
                lastShownIndex.put(s.charAt(i),i);
            }

            if (currentMaxSubstring.length()>maxLength){
                maxLength = currentMaxSubstring.length();
            }

        }

        return maxLength;

    }
}
