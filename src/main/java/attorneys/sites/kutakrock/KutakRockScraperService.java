package attorneys.sites.kutakrock;

import attorneys.sites.service.AttorneyParser;
import attorneys.sites.service.ScraperService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class KutakRockScraperService extends ScraperService {
    public static final String ALL_ATTORNEYS_LINKS = "https://www.kutakrock.com/sitecore/api/ssc/webapi/peoplesearch/1/search?page=60";
    public static final String KUTAK_ROCK_URL = "https://www.kutakrock.com";

    public KutakRockScraperService(AttorneyParser parser) {
        super(parser);
    }

    @Override
    public List<String> findAllAttorneysLinks(String linkOfSite) {
        List<String> attorneysUrl = new LinkedList<>();
        Iterator<JSONObject> iterator = getJsonArray().iterator();

        while (iterator.hasNext()) {
            String url = iterator.next().get("url").toString();
            attorneysUrl.add(KUTAK_ROCK_URL + url);
        }
        return attorneysUrl;
    }

    private Response getResponse() throws IOException {
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(ALL_ATTORNEYS_LINKS)
                .method("GET", null)
                .build();
        return client.newCall(request).execute();
    }

    private JSONArray getJsonArray() {
        JSONArray jsonArray = new JSONArray();
        try {
            String jsonString = getResponse().body().string();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            ;
            jsonArray = (JSONArray) jsonObject.get("results");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
