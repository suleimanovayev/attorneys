package attorneys.sites.kmcllaw;

import attorneys.sites.service.AttorneyParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class KmcllawAttorneyParser implements AttorneyParser {
    public static final String KMCLLAW_URL = "https://www.kmcllaw.com/attorneys/";
    public static final String BAR_ADMISSIONS = ".fl-rich-text";
    public static final String BIOGRAPHY = "div[data-node=5b06f8b5b3c7c] >div >div >div >div >p";
    public static final String EDUCATION = ".fl-rich-text";
    public static final String EMAIL = ".email-wrap";
    public static final String LOCATION = ".uabb-second-heading-text";
    public static final String NAME = ".fl-heading-text";
    public static final String PHONE = ".phone-wrap";
    public static final String PRACTICE_AREA = ".pp-accordion-content.fl-clearfix >p";
    public static final String TITLE = NAME;

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
        return document.select(PHONE).text();
    }

    @Override
    public String resolveEmail(String html) {
        Document document = Jsoup.parse(html);
        return document.select(EMAIL).text();
    }

    @Override
    public String resolveEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(EDUCATION).text();
    }

    @Override
    public String resolveLocation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(LOCATION).text();
    }

    @Override
    public String resolveBarAdmissions(String html) {
        Document document = Jsoup.parse(html);
        return document.select(BAR_ADMISSIONS).text();
    }

    @Override
    public String resolveBiography(String html) {
        Document document = Jsoup.parse(html);
        return document.select(BIOGRAPHY).text();
    }

    @Override
    public String resolveFullBiography(String html) {
        Document document = Jsoup.parse(html);
        return document.select(BIOGRAPHY).text();
    }

    @Override
    public String resolvePracticeArea(String html) {
        Document document = Jsoup.parse(html);
        return document.select(PRACTICE_AREA).text();
    }

    @Override
    public String resolveRawEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(EDUCATION).text();
    }
}
