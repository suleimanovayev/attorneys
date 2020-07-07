package gflegal.parser;

import gflegal.model.Attorney;
import org.jsoup.Jsoup;

import java.io.IOException;

public class JsoupParserHelper {

    public static Attorney parse(String html) {
        String title = JsoupTitleParser.resolveTitle(html);
        String biography = JsoupBiographyParser.resolveBiography(html);
        String[] locations = JsoupLocationParser.resolveLocation(html);
        String email = JsoupEmailParser.resolveEmail(html);
        String[] phones = JsoupPhonesParser.resolvePhone(html);
        String fullBiography = JsoupFullBiographyParser.resolveFullBiography(html);
        String[] Education= JsoupRawEducationParser.resolveRawEducation(html);
        String[] barAdmissions = JsoupBarAdmissionParser.resolveBarAdmissions(html);
        String name = JsoupNameParser.resolveName(html);
        return new Attorney();
    }
}
