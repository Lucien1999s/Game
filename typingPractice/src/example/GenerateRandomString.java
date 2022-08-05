package example;

import java.nio.charset.Charset;
import java.util.Random;

public class GenerateRandomString {
    public static String getRandomString(int i)
    {
        byte[] bytearray;
        bytearray = new byte[256];
        String mystring;
        StringBuffer thebuffer;
        String theAlphaNumericS;

        new Random().nextBytes(bytearray);
        mystring = new String(bytearray, Charset.forName("UTF-8"));

        thebuffer = new StringBuffer();
        theAlphaNumericS = mystring.replaceAll("[^A-Z0-9]", "");

        for (int m = 0; m < theAlphaNumericS.length(); m++) {

            if (Character.isLetter(theAlphaNumericS.charAt(m)) && (i > 0) ||
                    Character.isDigit(theAlphaNumericS.charAt(m)) && (i > 0)) {
                thebuffer.append(theAlphaNumericS.charAt(m));
                i--;
            }
        }
        return thebuffer.toString();
    }
}
