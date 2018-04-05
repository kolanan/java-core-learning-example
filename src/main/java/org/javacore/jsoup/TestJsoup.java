package org.javacore.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by nan on 2018/4/3 14:32
 */
public class TestJsoup {
    public static void main(String[] args) throws IOException{
        Document doc = Jsoup.connect("http://xinjinqiao.tprtc.com/admin/main/flrpro.do").get();
        System.out.println(doc);
    }
}
