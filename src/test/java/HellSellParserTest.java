//
//import attorneys.sites.HtmlConverter;
//import attorneys.sites.hellsell.HellSellAttorneyParser;
//import attorneys.sites.hellsell.HellSellScrapperService;
//import attorneys.sites.model.Attorney;
//import attorneys.sites.service.AttorneyParser;
//import attorneys.sites.service.ScraperService;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.junit.Assert;
//import org.junit.Test;
//import org.apache.commons.io.IOUtils;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//
//public class HellSellParserTest {
//    private ScraperService scraperService = new HellSellScrapperService();
//
//    @Test
//    public void testingIsabellaKim() {
//       Attorney actual = new Attorney();
//        String filePath = "/home/user/IdeaProjects/attorneys/hellsellIsabellaKim.txt";
//        Attorney expected = null;
//        try {
//            expected = scraperService.getAttorney(getHtml(filePath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String expectedBiography = DigestUtils.md5Hex(expected.getBiography());
//        String actualBiography = DigestUtils.md5Hex(actual.getBiography());
//        String expectedFullBiography = DigestUtils.md5Hex(expected.getFullBiography());
//        String actualFullBiography = DigestUtils.md5Hex(actual.getFullBiography());
//        String expectedBar = DigestUtils.md5Hex(expected.getBarAdmissions());
//        String actualBar = DigestUtils.md5Hex(actual.getBarAdmissions());
//
//        Assert.assertEquals(actual.getName(), expected.getName());
//        Assert.assertEquals(actual.getEmail(), expected.getEmail());
//        Assert.assertEquals(actual.getPhone(), expected.getPhone());
//        Assert.assertEquals(actual.getTitle(), expected.getTitle());
//        Assert.assertEquals(actualBiography, expectedBiography);
//        Assert.assertEquals(actualFullBiography, expectedFullBiography);
//        Assert.assertEquals(actualBar, expectedBar);
//    }
//
//    private String getHtml(String filePath) {
//        String html = "";
//        try {
//            html = Jsoup.parse(new File(filePath), "UTF-8").text();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return html;
//    }
//}