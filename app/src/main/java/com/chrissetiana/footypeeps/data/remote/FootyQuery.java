package com.chrissetiana.footypeeps.data.remote;

import android.util.Log;

import com.chrissetiana.footypeeps.data.model.FootyCompetitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class FootyQuery {
    public static List<FootyCompetitions> fetchData(String source) {
        String data = null;
        URL url = buildUrl(source);

        try {
            assert url != null;
            data = buildHttp(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return FootyApi.getJSONData(data);
    }

    private static URL buildUrl(String source) {
        try {
            return new URL(source);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String buildHttp(URL url) throws IOException {
        String response = null;

        HttpURLConnection connection = null;
        InputStream stream = null;

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.connect();

            int code = connection.getResponseCode();

            if (code == 200) {
                stream = connection.getInputStream();
                response = readStream(stream);
            } else {
                Log.d("Query", "Error code: " + code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }

            if (stream != null) {
                stream.close();
            }
        }

        return response;
    }

    private static String readStream(InputStream stream) {
        try {
            StringBuilder builder = new StringBuilder();

            if (stream != null) {
                InputStreamReader streamReader = new InputStreamReader(stream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(streamReader);
                String line = reader.readLine();

                while (line != null) {
                    builder.append(line);
                    line = reader.readLine();
                }
            }

            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
