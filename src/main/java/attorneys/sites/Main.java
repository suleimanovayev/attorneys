package attorneys.sites;

import attorneys.sites.thread.SitesRunner;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new SitesRunner().runSites();
        String  hash = DigestUtils.md5Hex("Isabella’s practice focuses on business and family immigration law.  She offers complete services to international businesses and individuals whose legal needs involve both immigration law and business law.  She enjoys the creative and detail-oriented aspects of choosing the optimal immigration path for businesses and individuals for their short- and long- term goals.\n" +
                "\n" +
                "Isabella assists businesses and individuals navigate the complexities of U.S. immigration law and business law contemporaneously. For example, she will set up a branch office of a foreign corporation and obtain visas for the executives/managers coming to oversee the branch office. She has many years of experience in commercial closings of asset/stock and real estate purchase and sale transactions.\n" +
                "\n" +
                "Isabella represents foreign corporations establish branch offices in the US, petition for key employee’s non-immigrant visas, provides contemporaneous transactional and immigration planning and green card petitions for employees.\n" +
                "\n" +
                "Isabella provides strategic legal advice to HR and foreign national employees regarding US immigration issues, including H-1B, L-1, TN, PERM labor certification, I-140 immigrant visa petitions (based on PERM certifications, Multinational Managers, Outstanding Researchers and Extraordinary Ability) and Adjustment of Status applications. She teams with HR  departments, helps them develop and implement immigration legal processes to meet with Department of Labor regulations for immigration document requirements and provides strategic direction to HR on workforce planning, job changes and employer obligations.\n" +
                "\n" +
                "Isabella also represents many clients through family-based immigrant petitions, especially navigating through the complex options of foreign nationals marrying or engaged to U.S. Citizens. Advising her clients with their priorities in mind, she will explain the different options clients from multi-factored perspectives and have the clients decide on the best option.\n" +
                "\n" +
                "Isabella has represented many EB-5 individual and regional center investor clients. The biggest challenge with EB-5 investor representation is proving the sources of income. She has communicated with her clients effectively to put together clear and comprehensive documents and illustrations to prove to U.S. Citizenship and Immigration Services (“USCIS”).\n" +
                "\n" +
                "Isabella has over 25 years of experience representing clients in industries from high-tech, professional, accounting, food service, engineering, health, construction, architecture, airline, art, entertainment and sports.  She has extensive experience representing her clients at USCIS, various consular posts, Immigration Board of Appeal and Immigration Court.");
    }
}
