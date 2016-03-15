import java.util.*;

/**
 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:
 [["ate", "eat","tea"],["nat","tan"],["bat"]]

 Note:
 For the return value, each inner list's elements must follow the lexicographic order.
 All inputs will be in lower-case.
 */
public class GroupAnagrams {


    private boolean isGroup(String src,String des){
        byte[] srcByte = src.getBytes();
        byte[] desByte = des.getBytes();
        Set<Byte> union = new HashSet<Byte>();

        return false;

    }


    private String strSortByLexicographicOrder(String str){
        List<Character> strList = new ArrayList<Character>();
        StringBuilder resStr = new StringBuilder();
        for (int i=0;i<str.length();i++){
            strList.add(str.charAt(i));
        }
        Collections.sort(strList);

        for (Character i:strList){
            resStr.append(i);
        }
        return  resStr.toString();

    }

    private void sortStringList(List<String> input){
        Collections.sort(input);
    }


    public List<List<String>> versionOne(List<String> input){
        Map<String,List> tmpMap = new HashMap<String, List>();
        for (String element:input){
            String key = strSortByLexicographicOrder(element);
            if (tmpMap.containsKey(key)){
                tmpMap.get(key).add(element);
            }else {
                tmpMap.put(key,new ArrayList());
                tmpMap.get(key).add(element);
            }
        }

        List<List<String>> res = new ArrayList<List<String>>();


        for (String key:tmpMap.keySet()){
            sortStringList(tmpMap.get(key));
            res.add(tmpMap.get(key));
        }

        return res;



    }

    public List<List<String>> versionTwo(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            // 将单词按字母排序
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String key = new String(carr);
            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<String>();
            }
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        // 将列表按单词排序
        for(String key : map.keySet()){
            List<String> curr = map.get(key);
            Collections.sort(curr);
            res.add(curr);
        }
        return res;
    }



    public static void main(String[] args){

        String[] testStrArray = {"eat", "tea", "tan", "ate", "nat", "bat"};

        GroupAnagrams groupAnagrams = new GroupAnagrams();

        List<List<String>> output = groupAnagrams.versionOne(Arrays.asList(testStrArray));

        int[] x = {0,1};
        int[] y = {0,1};

        boolean z = x.equals(y);

        String b = "a"+1;

        System.out.println();
    }

}
