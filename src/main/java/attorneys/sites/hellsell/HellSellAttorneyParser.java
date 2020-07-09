package attorneys.sites.hellsell;

import attorneys.sites.service.AttorneyParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HellSellAttorneyParser implements AttorneyParser {

    public static final String HELL_SELL_URL = "https://www.helsell.com/our-team/";
    public final static String NAME = "h1.entry-title";
    public final static String TITLE = ".large-9.columns >h1 >small";
    public final static String PHONE = ".meta";
    public final static String MAIL = ".meta >a[class=confidentialEmail]";
    public final static String LOCATION = ".meta >a:nth-child(2)";
    public final static String EDUCATION = "#sidebar >article:nth-child(3) >ul";
    public final static String BIOGRAPHY = "#english-language-content >p:first-of-type";
    public final static String FULL_BIOGRAPHY = "#english-language-content >p";
    public final static String PRACTICE_AREA = "#sidebar >article:nth-child(1) >ul >li";
    public final static String BAR_ADMISSION = "#english-language-content >ul:first-of-type";

    @Override
    public String resolveName(String html) {
        Document document = Jsoup.parse(html);
        return document.selectFirst(NAME).ownText();
    }

    @Override
    public String resolveTitle(String html) {
        Document document = Jsoup.parse(html);
        return document.select(TITLE).text();
    }

    @Override
    public String resolvePhone(String html) {
        Document document = Jsoup.parse(html);
        String phone = document.selectFirst(PHONE).ownText();
        return phone.replaceAll("\\D+", "");
    }

    @Override
    public String resolveEmail(String html) {
        Document document = Jsoup.parse(html);
        return document.select(MAIL).text();
    }

    @Override
    public String resolveEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(EDUCATION).text();
    }

    @Override
    public String resolveLocation(String html) {
        Document document = Jsoup.parse(html);
        String vCard = document.select(LOCATION).attr("href");
        String body = "";
//        try {
//            body = Jsoup.connect(vCard).get().text();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return StringUtils.substringBetween(body, ":;;", ";WA;98154");
        return body;
    }

    @Override
    public String resolveBarAdmissions(String html) {
        Document document = Jsoup.parse(html);
        return document.select(BAR_ADMISSION).text();

    }

    @Override
    public String resolveBiography(String html) {
        Document document = Jsoup.parse(html);
        return document.select(BIOGRAPHY).text();
    }

    @Override
    public String resolveFullBiography(String html) {
        Document document = Jsoup.parse(html);
        return document.select(FULL_BIOGRAPHY).text();
    }

    @Override
    public String[] resolvePracticeArea(String html) {
        Document document = Jsoup.parse(html);
        return document.select(PRACTICE_AREA)
                .stream().map(Element::text).toArray(String[]::new);
    }

    @Override
    public String resolveRawEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(EDUCATION).text();
    }
}
