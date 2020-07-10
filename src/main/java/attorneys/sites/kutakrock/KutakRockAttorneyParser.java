package attorneys.sites.kutakrock;

import attorneys.sites.service.AttorneyParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class KutakRockAttorneyParser implements AttorneyParser {
    public static final String BAR_ADMISSIONS = ".fl-rich-text";
    public static final String BIOGRAPHY = "div[data-node=5b06f8b5b3c7c] >div >div >div >div >p";
    public static final String EDUCATION = "";
    public static final String EMAIL = ".email-wrap";
    public static final String LOCATION_BUTTON = ".hero__link.link--white-to-clear.link";
    public static final String LOCATION = ">p[class^=hero__column-p]";
    public static final String NAME = ".hero__name";
    public static final String PHONE = ".hero__link.hero__link--block";
    public static final String PRACTICE_AREA = ".pp-accordion-content.fl-clearfix >p";
    public static final String TITLE = ".hero__subtitle";

    @Override
    public String resolveName(String html) {
        Document document = Jsoup.parse(html);
        return document.select(NAME).text();
    }

    @Override
    public String resolveTitle(String html) {

        Document document = Jsoup.parse(html);
        return document.select(TITLE).text();
    }

    @Override
    public String resolvePhone(String html) {
        Document document = Jsoup.parse(html);
        return document.select(PHONE).attr("href");
    }

    @Override
    public String resolveEmail(String html) {
        Document document = Jsoup.parse(html);
        return document.select(NAME).text();
    }

    @Override
    public String resolveEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(NAME).text();
    }

    @Override
    public String resolveLocation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(LOCATION).text();
    }

    @Override
    public String resolveBarAdmissions(String html) {
        Document document = Jsoup.parse(html);
        return document.select(NAME).text();
    }

    @Override
    public String resolveBiography(String html) {
        Document document = Jsoup.parse(html);
        return document.select(NAME).text();
    }

    @Override
    public String resolveFullBiography(String html) {
        Document document = Jsoup.parse(html);
        return document.select(NAME).text();
    }

    @Override
    public String resolvePracticeArea(String html) {
        return null;
    }

    @Override
    public String resolveRawEducation(String html) {
        return null;
    }

}
