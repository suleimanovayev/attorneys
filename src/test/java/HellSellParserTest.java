
import attorneys.sites.HtmlConverter;
import attorneys.sites.hellsell.HellSellAttorneyParser;
import attorneys.sites.hellsell.HellSellScrapperService;
import attorneys.sites.model.Attorney;
import attorneys.sites.service.AttorneyParser;
import attorneys.sites.service.ScraperService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class HellSellParserTest {
    private AttorneyParser parser = new HellSellAttorneyParser();
    private ScraperService scraperService = new HellSellScrapperService();

    @Test
    public void testingIsabellaKim() throws IOException {

        String filePath = "/home/user/IdeaProjects/attorneys/hellsellIsabellaKim.txt";
        String link = "https://www.helsell.com/helsell-attorney/isabella-kim/";

        String actualHtml = HtmlConverter.getHtmlPage(link);
        Attorney actual = scraperService.getAttorney(actualHtml);

        Attorney expected = scraperService.getAttorney(readFile(filePath));

        String expectedBiography = DigestUtils.md5Hex(expected.getBiography());
        String actualBiography = DigestUtils.md5Hex(actual.getBiography());
        String expectedFullBiography = DigestUtils.md5Hex(expected.getFullBiography());
        String actualFullBiography = DigestUtils.md5Hex(actual.getFullBiography());
        String expectedBar = DigestUtils.md5Hex(expected.getBarAdmissions());
        String actualBar = DigestUtils.md5Hex(actual.getBarAdmissions());

        Assert.assertEquals(actual.getName(), expected.getName());
        Assert.assertEquals(actual.getEmail(), expected.getEmail());
        Assert.assertEquals(actual.getPhone(), expected.getPhone());
        Assert.assertEquals(actual.getTitle(), expected.getTitle());
        Assert.assertEquals(actualBiography, expectedBiography);
        Assert.assertEquals(actualFullBiography, expectedFullBiography);
        Assert.assertEquals(actualBar, expectedBar);
    }

    private String readFile(String fileName) {
        try (FileInputStream stream = new FileInputStream(fileName)) {
            return IOUtils.toString(stream, String.valueOf(StandardCharsets.UTF_8));
        } catch (IOException e) {
            return "";
        }
    }
}