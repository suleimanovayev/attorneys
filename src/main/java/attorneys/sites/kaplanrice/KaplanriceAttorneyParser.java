package attorneys.sites.kaplanrice;

import attorneys.sites.service.AttorneyParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;

public class KaplanriceAttorneyParser implements AttorneyParser {
    public static final String BAR_ADMISSIONS = ".fl-rich-text";
    public static final String BIOGRAPHY = "div[data-node=5b06f8b5b3c7c] >div >div >div >div >p";
    public static final String EDUCATION = ".fl-rich-text";
    public static final String EMAIL = ".email-wrap";
    public static final String LOCATION = ".uabb-second-heading-text";
    public static final String NAME = "#interior-text h2";
    public static final String PHONE = ".sidebar-small >br" ;
    public static final String PRACTICE_AREA = ".pp-accordion-content.fl-clearfix >p";
    public static final String TITLE = NAME;

    @Override
    public String resolveName(String html) {
        Document document = Jsoup.parse(html);
        return document.select(NAME).text();
    }

    @Override
    public String resolveTitle(String html) {
        return "";
    }

    @Override
    public String resolvePhone(String html) {
        Document document = Jsoup.parse(html);
        Elements elements = document.select(PHONE);
        String s = elements.get(1).text();
        return s;
    }

    @Override
    public String resolveEmail(String html) {
        return "";
    }

    @Override
    public String resolveEducation(String html) {
        return "";
    }

    @Override
    public String resolveLocation(String html)  {
        return "";
    }

    @Override
    public String resolveBarAdmissions(String html) {
        return "";
    }

    @Override
    public String resolveBiography(String html) {
        return "";
    }

    @Override
    public String resolveFullBiography(String html) {
        return "";
    }

    @Override
    public String resolvePracticeArea(String html) {
        return "";
    }

    @Override
    public String resolveRawEducation(String html) {
        return "";
    }


//    private VcfParser getVcfParser(String html) {
//
//        if (vcfParser != null) {
//            return vcfParser;
//        } else
//            vcfParser = new VcfParser(getVcfUrl(html));
//
//        return vcfParser;
//    }
}
