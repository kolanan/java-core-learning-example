package org.javacore.jsoup;


import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import java.io.InputStream;

/**
 * Created by nan on 2018/4/2 8:26
 */
public class Main {
    private void getMeizitu() {
        RequestConfig globalConfig =
            RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).setConnectionRequestTimeout(6000).setConnectTimeout(6000).build();

        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();

        System.out.println("爬虫开始");
        for (int i = 1; i < 40; i++) {
            try {
                HttpGet get = new HttpGet("http://www.mmjpg.com/mm/1277/" + i);
                get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0");
                CloseableHttpResponse response = httpClient.execute(get);
                InputStream in = response.getEntity().getContent();
                String html = org.javacore.jsoup.Utils.convertStreamToString(in);
                new Thread(
                    new MeiZiImageCreator(html,i)).start();
            }catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


    public static void main(String[] args) {
        Main main = new Main();
        main.getMeizitu();
    }
}
