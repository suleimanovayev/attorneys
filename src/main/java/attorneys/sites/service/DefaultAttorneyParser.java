package attorneys.sites.service;

import java.io.IOException;

public class DefaultAttorneyParser implements AttorneyParser {
    @Override
    public String resolveName(String html) {
        return "";
    }

    @Override
    public String resolveTitle(String html) {
        return "";
    }

    @Override
    public String resolvePhone(String html) {
        return "";
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
    public String resolveLocation(String html) throws IOException {
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
    public String[] resolvePracticeArea(String html) {
        return new String[0];
    }

    @Override
    public String resolveRawEducation(String html) {
        return "";
    }
}
