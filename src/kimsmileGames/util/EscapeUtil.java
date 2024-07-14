package kimsmileGames.util;

public class EscapeUtil {


    public static String escapeT (int count) {
        String t = "";
        for (int i = 0 ; i < count ; i++ ) {
            t += "\t";
        }
        return t;
    }
}
