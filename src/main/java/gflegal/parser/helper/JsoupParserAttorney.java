package gflegal.parser.helper;

import gflegal.model.Attorney;
import gflegal.parser.*;
import org.apache.commons.lang3.StringUtils;

public class JsoupParserAttorney {

    public static Attorney parseAttorney(String html) {
        String name = JsoupNameParser.resolveName(html);
        String title = JsoupTitleParser.resolveTitle(html);
        String[] locations = JsoupLocationParser.resolveLocation(html);
        String phone = JsoupPhoneParser.resolvePhone(html);
        String email = JsoupEmailParser.resolveEmail(html);
        String barAdmissions = JsoupBarAdmissionParser.resolveBarAdmissions(html);
        String fullBiography = JsoupFullBiographyParser.resolveFullBiography(html);
        StringUtils.substringAfterLast(fullBiography,"Education");
        String education = JsoupEducationParser.resolveEducation(html);
        checkEducation(education, html);
        String biography = JsoupBiographyParser.resolveBiography(html);
        return new Attorney(biography, title, locations, email, phone, fullBiography, education, barAdmissions, name);
    }

    private static void checkEducation(String education, String html ) {
        if(education.isEmpty()) {
            education = JsoupEducationParser.resolveEmptyEducation(html);
        }
    }
}
