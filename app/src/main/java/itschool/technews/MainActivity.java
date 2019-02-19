package itschool.technews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadNewsClick(View view) {
        Toast.makeText(getApplicationContext(), R.string.loadStart, Toast.LENGTH_SHORT).show();
        HTMLgetter page = new HTMLgetter();
        page.execute();

        try {
            Thread.sleep(1000l);

            textView = findViewById(R.id.textView);
            textView.setText(page.page.title());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
