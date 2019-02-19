package itschool.technews;

import android.os.AsyncTask;

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
        String jsonIn = "";
        Document page = null;
        url = "https://news.sky.com/technology";
        try {
            page = Jsoup.parse(new URL(url), 10000);
            jsonIn = "| " + page.text() + " |";
        } catch (IOException e) {
            e.printStackTrace();
        }

        //textView.setText(textView.getText()+"In2\n");
        try {
            page = Jsoup.connect(url).get();// Connect to the web site
            jsonIn = page.text();           // Get the html document title

            //textView.setText(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        Element tableWth = page.select("table").first();
        Elements dates = tableWth.select("th[colspan=4]"); // даты дней недели для прогноза (их 3)
        Elements rows = tableWth.select("tr");

        // извлекаем даты
        String date = "";
        for (Element d : dates)
            date += "\t\t\t" + d.text();

        // извлекаем температуру и темп. по ощущениям
        int i = 0;
        int r = 2;
        Elements temperatures = tableWth.select("span[class=value m_temp c]");
        for (Element t : temperatures) {
        }
    }
}

