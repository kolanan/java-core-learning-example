package org.javacore.jsoup;

import java.io.*;

/**
 * Created by nan on 2018/4/2 8:59
 */
public class Utils {
    public static String convertStreamToString(InputStream in) throws UnsupportedEncodingException{
        BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            while (null!=(line=br.readLine())) {
                sb.append(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            }catch (IOException e2) {
                e2.printStackTrace();
            }

        }
        return sb.toString();
    }
}
