package attorneys.sites.hellsell;

import attorneys.sites.hellsell.constant.HellSellConstants;
import attorneys.sites.service.AttorneyParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HellSellAttorneyParser implements AttorneyParser {

    @Override
    public String resolveName(String html) {
        Document document = Jsoup.parse(html);
        return document.selectFirst(HellSellConstants.NAME).ownText();
    }

    @Override
    public String resolveTitle(String html) {
        Document document = Jsoup.parse(html);
        return document.select(HellSellConstants.TITLE).text();
    }

    @Override
    public String resolvePhone(String html) {
        Document document = Jsoup.parse(html);
        String phone = document.selectFirst(HellSellConstants.PHONE).ownText();
        return phone.replaceAll("\\D+", "");
    }

    @Override
    public String resolveEmail(String html) {
        Document document = Jsoup.parse(html);
        return document.select(HellSellConstants.MAIL).text();
    }

    @Override
    public String resolveEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(HellSellConstants.EDUCATION).text();
    }

    @Override
    public String resolveLocation(String html) {
        Document document = Jsoup.parse(html);
        String vCard = document.select(HellSellConstants.LOCATION).attr("href");
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
        return document.select(HellSellConstants.BAR_ADMISSION).text();

    }

    @Override
    public String resolveBiography(String html) {
        Document document = Jsoup.parse(html);
        return document.select(HellSellConstants.BIOGRAPHY).text();
    }

    @Override
    public String resolveFullBiography(String html) {
        Document document = Jsoup.parse(html);
        return document.select(HellSellConstants.FULL_BIOGRAPHY).text();
    }

    @Override
    public String[] resolvePracticeArea(String html) {
        Document document = Jsoup.parse(html);
        return document.select(HellSellConstants.PRACTICE_AREA)
                .stream().map(Element::text).toArray(String[]::new);
    }

    @Override
    public String resolveRawEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(HellSellConstants.EDUCATION).text();
    }
}
