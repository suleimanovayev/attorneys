package attorneys.sites.gflegal.constant;

public class GflegalConstants {
    public static final String GFLEGAL_URL = "https://www.gflegal.com/Attorneys";
    public static final String BAR_ADMISSIONS = "div[class^=attorneyProfile] >ul >li";
    public static final String BIOGRAPHY = ".attorneyProfileNarrative p:has(:not(strong))";
    public static final String BIOGRAPHY_SECOND_PARAGRAPH = ".attorneyProfileNarrative p:gt(2)";
    public static final String BIOGRAPHY_THIRD_PARAGRAPH = ".attorneyProfileNarrative p";
    public static final String EDUCATION = ".attorneyProfileNarrative p:has(strong:contains(Education:)) + ul li";
    public static final String EMPTY_EDUCATION = "div.attorneyProfileNarrative, strong:contains(Education:) + ul li";
    public static final String EMAIL = "div.attorneyProfileFax >a";
    public static final String LOCATION = "div.attorneyProfileLocation >div:nth-child(2)";
    public static final String NAME = "#containerPageTitle";
    public static final String PHONE = "div.attorneyProfilePhone";
    public static final String PRACTICE_AREA = "ul.fl-list.list-level-1 >li";
    public static final String RAW_EDUCATION =  ".attorneyProfileNarrative p:has(strong:contains(Education:)) + ul li";
    public static final String TITLE = "div.attorneyProfilePosition";
    public static final String ALL_ATTORNEYS_LINKS = "ul >li[itemtype='http://schema.org/Person'] >a";

}
