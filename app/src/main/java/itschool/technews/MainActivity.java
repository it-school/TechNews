package itschool.technews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadNewsClick(View view) {
        Toast.makeText(getApplicationContext(), R.string.loadStart, Toast.LENGTH_SHORT).show();
        HTMLgetter page = new HTMLgetter();
/*
        Document doc = null;
        try {
            doc = Jsoup.connect("http://en.wikipedia.org/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            Toast.makeText(getApplicationContext(), "%s\n\t%s " + headline.attr("title") + headline.absUrl("href"), Toast.LENGTH_SHORT).show();
        }
        */
    }
}
