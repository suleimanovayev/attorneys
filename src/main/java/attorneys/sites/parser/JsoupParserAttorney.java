package attorneys.sites.parser;

import attorneys.sites.model.Attorney;
import attorneys.sites.service.AttorneyAttributesParser;

public class JsoupParserAttorney {
    private AttorneyAttributesParser parser;

    public JsoupParserAttorney(AttorneyAttributesParser attorneyAttributesParser) {
        this.parser = attorneyAttributesParser;
    }

    public Attorney getAttorney(String html, Attorney attorney) {
        attorney.setName(parser.resolveName(html));
        attorney.setTitle(parser.resolveTitle(html));
        attorney.setLocations(parser.resolveLocation(html));
        attorney.setPhone(parser.resolvePhone(html));
        attorney.setEmail(parser.resolveEmail(html));
        attorney.setBarAdmissions(parser.resolveBarAdmissions(html));
        attorney.setFullBiography(parser.resolveFullBiography(html));
        attorney.setBiography(parser.resolveBiography(html));
        String education = parser.resolveEducation(html);
        attorney.setEducation(education);
        return attorney;
    }

//    private void checkEducation(String education, String html) {
////        if (education.isEmpty()) {
////            education = parser.resolveEmptyEducation(html);
////        }
//    }
}
