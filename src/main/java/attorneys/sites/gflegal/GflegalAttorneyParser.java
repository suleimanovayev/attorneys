package attorneys.sites.gflegal;

import attorneys.sites.service.AttorneyParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GflegalAttorneyParser implements AttorneyParser {
    public static final String GFLEGAL_URL = "https://www.gflegal.com/Attorneys";
    public static final String BAR_ADMISSIONS = "div[class^=attorneyProfile] >ul >li";
    public static final String BIOGRAPHY = ".attorneyProfileNarrative p:has(:not(strong))";
    public static final String BIOGRAPHY_SECOND_PARAGRAPH = ".attorneyProfileNarrative p:gt(2)";
    public static final String BIOGRAPHY_THIRD_PARAGRAPH = ".attorneyProfileNarrative p";
    public static final String EDUCATION = ".attorneyProfileNarrative p:has(strong:contains(Education:)) + ul li";
    public static final String EMAIL = "div.attorneyProfileFax >a";
    public static final String LOCATION = "div.attorneyProfileLocation >div:nth-child(2)";
    public static final String NAME = "#containerPageTitle";
    public static final String PHONE = "div.attorneyProfilePhone";
    public static final String PRACTICE_AREA = "ul.fl-list.list-level-1 >li";
    public static final String RAW_EDUCATION = ".attorneyProfileNarrative p:has(strong:contains(Education:)) + ul li";
    public static final String TITLE = "div.attorneyProfilePosition";

    @Override
    public String resolveBarAdmissions(String html) {
        Document document = Jsoup.parse(html);
        return document.select(BAR_ADMISSIONS)
                .text();
    }

    @Override
    public String resolveBiography(String html) {
        StringBuilder builder = new StringBuilder();
        Document document = Jsoup.parse(html);
        return builder.append(document.select(BIOGRAPHY).text())
                .append(document.select(BIOGRAPHY_SECOND_PARAGRAPH).text())
                .append(document.select(BIOGRAPHY_THIRD_PARAGRAPH).text()).toString();
    }

    @Override
    public String resolveEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(EDUCATION)
                .text();
    }

    @Override
    public String resolveEmail(String html) {
        Document document = Jsoup.parse(html);
        return document.select(EMAIL).text();
    }

    @Override
    public String resolveFullBiography(String html) {
        StringBuilder builder = new StringBuilder();
        Document document = Jsoup.parse(html);
        return builder.append(document.select(BIOGRAPHY).text())
                .append(document.select(BIOGRAPHY_SECOND_PARAGRAPH).text())
                .append(document.select(BIOGRAPHY_THIRD_PARAGRAPH).text()).toString();
    }

    @Override
    public String resolveLocation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(LOCATION)
                .text();
    }

    @Override
    public String resolveName(String html) {
        Document document = Jsoup.parse(html);
        return document.select(NAME).text();
    }

    @Override
    public String resolvePhone(String html) {
        Document document = Jsoup.parse(html);
        return document.select(PHONE)
                .text();
    }

    @Override
    public String resolvePracticeArea(String html) {
        Document document = Jsoup.parse(html);
        return document.select(PRACTICE_AREA).text();
    }

    @Override
    public String resolveRawEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(RAW_EDUCATION)
                .text();
    }

    @Override
    public String resolveTitle(String html) {
        Document document = Jsoup.parse(html);
        return document.select(TITLE).text();
    }
}
