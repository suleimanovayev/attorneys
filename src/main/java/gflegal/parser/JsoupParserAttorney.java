package gflegal.parser;

import gflegal.model.Attorney;

public class JsoupParserAttorney {

    public static Attorney parseAttorney(String html) {
        String name = JsoupNameParser.resolveName(html);
        String title = JsoupTitleParser.resolveTitle(html);
        String[] locations = JsoupLocationParser.resolveLocation(html);
        String phone = JsoupPhoneParser.resolvePhone(html);
        String email = JsoupEmailParser.resolveEmail(html);
        String[] barAdmissions = JsoupBarAdmissionParser.resolveBarAdmissions(html);
        String fullBiography = JsoupFullBiographyParser.resolveFullBiography(html);
        String[] education = JsoupRawEducationParser.resolveRawEducation(html);
        String biography = JsoupBiographyParser.resolveBiography(html);
        return new Attorney(biography, title, locations, email, phone, fullBiography, education, barAdmissions, name);
    }
}
