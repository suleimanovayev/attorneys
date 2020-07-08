package attorneys.sites.hellsell;

import attorneys.sites.service.AttorneyParser;

public class HellSellAttorneyParser implements AttorneyParser {
    @Override
    public String resolveName(String html) {
        return null;
    }

    @Override
    public String resolveTitle(String html) {
        return null;
    }

    @Override
    public String resolvePhone(String html) {
        return null;
    }

    @Override
    public String resolveEmail(String html) {
        return null;
    }

    @Override
    public String resolveEducation(String html) {
        return null;
    }

    @Override
    public String[] resolveLocation(String html) {
        return new String[0];
    }

    @Override
    public String resolveBarAdmissions(String html) {
        return null;
    }

    @Override
    public String resolveBiography(String html) {
        return null;
    }

    @Override
    public String resolveFullBiography(String html) {
        return null;
    }

    @Override
    public String[] resolvePracticeArea(String html) {
        return new String[0];
    }

    @Override
    public String resolveRawEducation(String html) {
        return null;
    }
}
