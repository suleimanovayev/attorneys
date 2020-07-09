
import attorneys.sites.HtmlConverter;
import attorneys.sites.hellsell.HellSellAttorneyParser;
import attorneys.sites.hellsell.HellSellScrapperService;
import attorneys.sites.model.Attorney;
import attorneys.sites.service.AttorneyParser;
import attorneys.sites.service.ScraperService;
import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class HellSellParserTest {
    private ScraperService scraperService = new HellSellScrapperService();

    @Test
    public void testingIsabellaKim() {
        String expName = "Isabella Kim";
        String expEmail = "ikim@helsell.com";
        String expPhones = "(206) 689-2123";
        String expPracticeAreas = "9aea3e46a475070568d4c5fac1ecf18f";
        String expEducation = "3f2ff9016ad322aa3c2996da1b8cd903";
        String expFullBiography = "ef23be1dcdd8cfdb7c4ff2a6f683c0b0";
        
        String expBarAdmission = "dd54e458becc383104daffa173a7f65e";

        Attorney actual = new Attorney();
        String filePath = "/home/user/IdeaProjects/attorneys/hellsellIsabellaKim.html";
        Attorney expected = null;
        try {
            expected = scraperService.getAttorney(getHtml(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String expectedBiography = getHash(expected.getBiography());
        String actualBiography = getHash(actual.getBiography());
        String expectedFullBiography = getHash(expected.getFullBiography());
        String actualFullBiography = getHash(actual.getFullBiography());
        String expectedBar = getHash(expected.getBarAdmissions());
        String actualBar = getHash(actual.getBarAdmissions());

        Assert.assertEquals(actual.getName(), expected.getName());
        Assert.assertEquals(actual.getEmail(), expected.getEmail());
        Assert.assertEquals(actual.getPhone(), expected.getPhone());
        Assert.assertEquals(actual.getTitle(), expected.getTitle());
        Assert.assertEquals(actualBiography, expectedBiography);
        Assert.assertEquals(actualFullBiography, expectedFullBiography);
        Assert.assertEquals(actualBar, expectedBar);
    }

    private String getHash(String attribute) {
        return DigestUtils.md5Hex(attribute);
    }

    private String getHtml(String filePath) {
        String html = "";
        try {
            html = Jsoup.parse(new File(filePath), "UTF-8").text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }
}