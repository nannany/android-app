package com.example.android_app;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.example.androidsdk.WidgetClient;
import com.example.androidsdk.WidgetsCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final WidgetClient client = new WidgetClient();

        View widgetListButton = findViewById(R.id.widgetListButton);
        widgetListButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                client.getWidgets(new WidgetsCallback() {
                    @Override
                    public void onSuccess(okhttp3.Response response) {
                        Log.d("test", response.toString());
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.d("test", e.toString());
                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
