package attorneys.sites.service;

import java.io.IOException;

public interface AttorneyParser {

    String resolveName(String html);

    String resolveTitle(String html);

    String resolvePhone(String html);

    String resolveEmail(String html);

    String resolveEducation(String html);

    String resolveLocation(String html) throws IOException;

    String resolveBarAdmissions(String html);

    String resolveBiography(String html);

    String resolveFullBiography(String html);

    String resolvePracticeArea(String html);

    String resolveRawEducation(String html);
}
