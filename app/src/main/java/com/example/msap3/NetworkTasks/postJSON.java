package com.example.msap3.NetworkTasks;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class postJSON {
    public static final String URL ="http://10.0.2.2:5000/postresults";

    public static void postBackendJson(String pingResult) throws IOException {
        String result = "result";
        String response = null;
        java.net.URL url = new URL(URL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonString = "{ \"result\": " + "\"" + pingResult + "\"}";

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder responseString = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                responseString.append(responseLine.trim());
            }
            response = responseString.toString();
            Log.i("MAKE_PING","post result" + response);
        }



    }
}
