import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qq on 2016/3/17.
 */
public class Regex {


    public static void main(String[] args){


        String testStr = "gogogo gogogo yuuioooii";

        String regex = "\\b(\\w+)\\b\\s+\\1\\b";
        Pattern p= Pattern.compile(regex);

        Matcher m=p.matcher(testStr);
        while(m.find()) {
            System.out.println(m.group());
        }


        testStr = "I'm singing while you're dancing.";

        regex = "\\b\\w+(?=ing\\b)";

        regex = "(?<=')([\\w\\s]+)(?=')";

        p= Pattern.compile(regex);

        String test = p.pattern();

        m=p.matcher(testStr);
        while(m.find()) {
            System.out.println(m.group());
        }
    }
}
