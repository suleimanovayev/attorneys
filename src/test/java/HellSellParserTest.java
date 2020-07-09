import attorneys.sites.factory.ScraperServiceFactory;
import attorneys.sites.model.Attorney;
import attorneys.sites.service.ScraperService;
import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Jsoup;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class HellSellParserTest {
    public static final String HELL_SELL_URL = "https://www.helsell.com/our-team/";
    private ScraperService scraperService = ScraperServiceFactory.getScrapperServiceInstance(HELL_SELL_URL);

    @Test
    public void testingIsabellaKim() {
        String expName = "Isabella Kim";
        String expTitle = "Of Counsel";
        String expEmail = "ikim@helsell.com";
        String expPhone = "2066892123";
        String expEducation = "484bfb24cc33eb15720f8c476a39dba1";
        String expFullBiography = "ee6d81564a036cfb7f20f8d9a784c4a2";
        String expBarAdmission = "22faab79dd33596d52d3184720400864";

        String filePath = "/home/user/IdeaProjects/attorneys/src/test/resources/hellshell/hellsellIsabellaKim.html";
        Attorney actual = null;
        try {
            actual = scraperService.getAttorney(getHtml(filePath));
        } catch (IOException e) {
            System.out.println("ARRRRRARA");
            e.printStackTrace();
        }

        String actualFullBiography = getHash(actual.getFullBiography());
        String actualBar = getHash(actual.getBarAdmissions());
        String actualEducation = getHash(actual.getEducation());

        Assert.assertEquals(actual.getName(), expName);
        Assert.assertEquals(actual.getEmail(), expEmail);
        Assert.assertEquals(actual.getPhone(), expPhone);
        Assert.assertEquals(actual.getTitle(), expTitle);
        Assert.assertEquals(actualFullBiography, expFullBiography);
        Assert.assertEquals(actualEducation, expEducation);
        Assert.assertEquals(actualBar, expBarAdmission);
    }


    @Test
    public void testingKatharineBrindley() {
        String expName = "Katharine Brindley";
        String expTitle = "Of Counsel";
        String expEmail = "kbrindley@helsell.com";
        String expPhone = "2066892145";
        String expEducation = "59e1ba665f05b92a2ae9b27d992f2f0a";
        String expFullBiography = "6b5e5a4216946d655ef05fdc5a6d8379";
        String expBarAdmission = "27c6ab6512649f2649ecf97f4f7b2d65";

        String filePath = "/home/user/IdeaProjects/attorneys/src/test/resources/hellshell/hellsellKatharineBrindley.html";
        Attorney actual = null;
        try {
            actual = scraperService.getAttorney(getHtml(filePath));
        } catch (IOException e) {
            System.out.println("ARRRRRARA");
            e.printStackTrace();
        }

        String actualFullBiography = getHash(actual.getFullBiography());
        String actualBar = getHash(actual.getBarAdmissions());
        String actualEducation = getHash(actual.getEducation());

        Assert.assertEquals(actual.getName(), expName);
        Assert.assertEquals(actual.getEmail(), expEmail);
        Assert.assertEquals(actual.getPhone(), expPhone);
        Assert.assertEquals(actual.getTitle(), expTitle);
        Assert.assertEquals(actualFullBiography, expFullBiography);
        Assert.assertEquals(actualEducation, expEducation);
        Assert.assertEquals(actualBar, expBarAdmission);
    }

    @Test
    public void testingSamuelJacobs() {
        String expName = "Samuel Jacobs";
        String expTitle = "Partner";
        String expEmail = "sjacobs@helsell.com";
        String expPhone = "2066892121";
        String expEducation = "f800738ae9bc83162ddfdcb1c251878b";
        String expFullBiography = "2600713574aa5d3a8356c4e34ea80297";
        String expBarAdmission = "e23708d3902bcf583fcfb02b679e4348";

        String filePath = "/home/user/IdeaProjects/attorneys/src/test/resources/hellshell/hellsellSamuelJacobs.html";
        Attorney actual = null;
        try {
            actual = scraperService.getAttorney(getHtml(filePath));
        } catch (IOException e) {
            System.out.println("ARRRRRARA");
            e.printStackTrace();
        }

        String actualFullBiography = getHash(actual.getFullBiography());
        String actualBar = getHash(actual.getBarAdmissions());
        String actualEducation = getHash(actual.getEducation());

        Assert.assertEquals(actual.getName(), expName);
        Assert.assertEquals(actual.getEmail(), expEmail);
        Assert.assertEquals(actual.getPhone(), expPhone);
        Assert.assertEquals(actual.getTitle(), expTitle);
        Assert.assertEquals(actualFullBiography, expFullBiography);
        Assert.assertEquals(actualEducation, expEducation);
        Assert.assertEquals(actualBar, expBarAdmission);
    }

    private String getHash(String attribute) {
        return DigestUtils.md5Hex(attribute);
    }

    private String getHtml(String filePath) {
        String html = "";
        try {
            html = Jsoup.parse(new File(filePath), "UTF-8").html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }
}