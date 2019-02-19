package itschool.technews;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    public static boolean state;
    static TextView textView;
    static HTMLgetter page;
    Button loadButton;

    static void showNews() {
//        try {
//            Thread.sleep(3000l);

        if (page.page != null) {
            textView.setTextSize(16);
            textView.setTextColor(Color.BLACK);
            textView.setMovementMethod(new ScrollingMovementMethod());

            Elements newses = page.page.select("a[class=sdc-site-tile__headline-link]");
            String stringnews = "<ol>";
            for (Element news : newses)
                stringnews += "<li><a href='" + news.baseUri().substring(0, news.baseUri().lastIndexOf("/")) + news.attr("href") + "'>" + news.text() + "</a></li>";
            stringnews += "</ol>";

            textView.setText(Html.fromHtml(page.page.title() + "\n\n" + stringnews));
            textView.setMovementMethod(LinkMovementMethod.getInstance());

        }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadButton = findViewById(R.id.buttonLoad);
        textView = findViewById(R.id.textView);
        state = false;
    }

    public void loadNewsClick(View view) {
        page = new HTMLgetter("https://news.sky.com/technology");
        Toast.makeText(getApplicationContext(), R.string.loadStart, Toast.LENGTH_LONG).show();
        page.execute();
    }
}
