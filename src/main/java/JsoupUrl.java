import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class JsoupUrl {


    public static void getUrlLink() {
        final  String url = "https://www.otodom.pl/sprzedaz/mieszkanie/sopot/";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            List <Element> elementList =  doc.select("header.offer-item-header >h3 > a[href]");
            System.out.println(elementList.size());
            Set<String> hrefSet = new TreeSet<>();
            for (Element element : elementList){
            hrefSet.add(element.attr("href"));
            }

            hrefSet.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
