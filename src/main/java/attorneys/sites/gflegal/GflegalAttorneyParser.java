package attorneys.sites.gflegal;

import attorneys.sites.gflegal.constant.GflegalConstants;
import attorneys.sites.service.AttorneyParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GflegalAttorneyParser implements AttorneyParser {
    @Override
    public String resolveBarAdmissions(String html) {
        Document document = Jsoup.parse(html);
        return document.select(GflegalConstants.BAR_ADMISSIONS)
                .text();
    }

    @Override
    public String resolveBiography(String html) {
        StringBuilder builder = new StringBuilder();
        Document document = Jsoup.parse(html);
        return builder.append(document.select(GflegalConstants.BIOGRAPHY).text())
                .append(document.select(GflegalConstants.BIOGRAPHY_SECOND_PARAGRAPH).text())
                .append(document.select(GflegalConstants.BIOGRAPHY_THIRD_PARAGRAPH).text()).toString();
    }

    @Override
    public String resolveEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(GflegalConstants.EDUCATION)
                .text();
    }

    @Override
    public String resolveEmail(String html) {
        Document document = Jsoup.parse(html);
        return document.select(GflegalConstants.EMAIL).text();
    }

    @Override
    public String resolveFullBiography(String html) {
        StringBuilder builder = new StringBuilder();
        Document document = Jsoup.parse(html);
        return builder.append(document.select(GflegalConstants.BIOGRAPHY).text())
                .append(document.select(GflegalConstants.BIOGRAPHY_SECOND_PARAGRAPH).text())
                .append(document.select(GflegalConstants.BIOGRAPHY_THIRD_PARAGRAPH).text()).toString();
    }

    @Override
    public String resolveLocation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(GflegalConstants.LOCATION)
                .text();
    }

    @Override
    public String resolveName(String html) {
        Document document = Jsoup.parse(html);
        String j = document.select(GflegalConstants.NAME).text();
        return document.select(GflegalConstants.NAME).text();
    }

    @Override
    public String resolvePhone(String html) {
        Document document = Jsoup.parse(html);
        return document.select(GflegalConstants.PHONE)
                .text();
    }

    @Override
    public String[] resolvePracticeArea(String html) {
        Document document = Jsoup.parse(html);
        Elements areas = document.select(GflegalConstants.PRACTICE_AREA);
        return areas.stream().map(Element::text).toArray(String[]::new);
    }

    @Override
    public String resolveRawEducation(String html) {
        Document document = Jsoup.parse(html);
        return document.select(GflegalConstants.RAW_EDUCATION)
                .text();
    }

    @Override
    public String resolveTitle(String html) {
        Document document = Jsoup.parse(html);
        return document.select(GflegalConstants.TITLE).text();
    }
}
