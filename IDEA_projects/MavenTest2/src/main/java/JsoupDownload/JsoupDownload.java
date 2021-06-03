package JsoupDownload;
import org.jsoup.*;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupDownload {
    public static void main(String[] args) {
        Document doc;
        try {
            doc = Jsoup.connect("http://google.com/").get();
            String title = doc.title();

            System.out.println("Jsoup Can read HTML page from URL, title : " + title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
