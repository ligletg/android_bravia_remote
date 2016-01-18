package com.example.liglet_g.bravia_remote_control;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

private class SendCommand extends AsyncTask<URL, Integer, Long> {
    protected Long doInBackground(URL url) {
        try {
            InputStream response = new URL("http://stackoverflow.com").openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void onProgressUpdate(Integer... progress) {
//        setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
//        showDialog("Downloaded " + result + " bytes");
    }
};

public class MainActivity extends AppCompatActivity {

    private static String logtag = "TwoButtonApp";//for use as the tag when logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(startListener); // Register the onClick listener with the implementation above

        Button buttonStop = (Button)findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(stopListener); // Register the onClick listener with the implementation above

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    //Create an anonymous implementation of OnClickListener
    private OnClickListener startListener = new OnClickListener() {
        public void onClick(View v) {
            Log.d(logtag,"onClick() called - start button");
            Toast.makeText(MainActivity.this, "The Start button was clicked.", Toast.LENGTH_LONG).show();
            Log.d(logtag,"onClick() ended - start button");

//            String stringUrl = "http://192.168.1.16/sony/IRCC";
//            URL url = null;
//            try {
//                url = new URL(stringUrl);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            URLConnection uc = null;
//            try {
//                uc = url.openConnection();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            uc.setRequestProperty("X-Requested-With", "Curl");
//
//            String userpass = "username" + ":" + "password";
//            byte[] data = null;
//            try {
//                data = userpass.getBytes("UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            String basicAuth = "Basic " + Base64.encodeToString(data, Base64.DEFAULT);
//            uc.setRequestProperty("Authorization", basicAuth);
//
//            try {
//                InputStreamReader inputStreamReader = new InputStreamReader(uc.getInputStream());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }



//            String url = "http://192.168.1.16/sony/IRCC";
//
//            URL obj = null;
//            try {
//                obj = new URL(url);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            HttpURLConnection conn = null;
//            try {
//                conn = (HttpURLConnection) obj.openConnection();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            conn.setRequestProperty("Content-Type", "application/json");
//            conn.setDoOutput(true);
//
//            try {
//                conn.setRequestMethod("POST");
//            } catch (ProtocolException e) {
//                e.printStackTrace();
//            }
//
////build it this way
//            Uri.Builder builder = new Uri.Builder()
//                    .appendQueryParameter("firstParam", "1")
//                    .appendQueryParameter("secondParam", "2")
//                    .appendQueryParameter("thirdParam", "3");
//            String query = builder.build().getEncodedQuery();
//
//            OutputStream os = null;
//            try {
//                os = conn.getOutputStream();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            BufferedWriter writer = null;
//            try {
//                writer = new BufferedWriter(
//                        new OutputStreamWriter(os, "UTF-8"));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            try {
//                writer.write(query);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                writer.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            try {
                new SendCommand().execute(new URL("http://stackoverflow.com"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

//            try {
//                InputStream response = new URL("http://stackoverflow.com").openStream();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    };

    // Create an anonymous implementation of OnClickListener
    private OnClickListener stopListener = new OnClickListener() {
        public void onClick(View v) {
            Log.d(logtag,"onClick() called - stop button");
            Toast.makeText(MainActivity.this, "The Stop button was clicked.", Toast.LENGTH_LONG).show();
            Log.d(logtag,"onClick() ended - stop button");
        }
    };
}
