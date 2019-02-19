package itschool.technews;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;

public class HTMLgetter extends AsyncTask<Void, Void, Void> {
    String url;
    Document page;

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        page = null;
        url = "https://news.sky.com/technology";
        try {
            page = Jsoup.parse(new URL(url), 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            page = Jsoup.connect(url).get();// Connect to the web site
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("", page.title());

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        Elements news = page.select("span[class=sdc-site-tile__headline-text]");

        for (Element neww : news) {
            Log.d("news: ", neww.text());
        }
    }
}

