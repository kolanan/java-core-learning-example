package org.javacore.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by nan on 2018/4/2 9:21
 */
public class MeiZiImageCreator implements Runnable{
    private static int count = 1;
    private String imageUrl;
    private int page;
    private StringBuffer basePath;

    public MeiZiImageCreator(String imageUrl, int page) {
        // TODO Auto-generated constructor stub
        this.imageUrl = imageUrl;
        this.page = page;
        basePath = new StringBuffer("D:/meizitu/page");
    }

    @Override
    public void run() {
        File file = new File(basePath.toString());
        if(!file.exists()) {
            file.mkdirs();
            System.out.println("图片存放于" + basePath);
        }
        Document document = Jsoup.parse(imageUrl);
        Element div_content = document.select("div.content > a > img").first();
        String link = div_content.attr("src");
        String imageName = link.substring(link.lastIndexOf("/") + 1);
        File filename = new File(basePath + "/" + page + "--" + imageName);
        try {
            OutputStream out = new FileOutputStream(filename);
            URL url = new URL(link);
            InputStream in = url.openStream();
            byte[] bytes = new byte[1024];
            while (true) {
                int readed = in.read(bytes);
                if(readed==-1) {
                    break;
                }
                byte[] temp = new byte[readed];
                System.arraycopy(bytes, 0, temp, 0, readed);//内容复制
                //写入到文件中
                out.write(temp);
            }
            System.out.println("第" + (count++) + "张妹子：" + filename.getAbsolutePath());
            out.close();
            in.close();
        }catch (Exception e) {
            e.printStackTrace();
        }



    }
}
