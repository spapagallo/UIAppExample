package com.example.telematica.uiappexample.connection;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by franciscocabezas on 12/4/15.
 */
public class HttpConection {

    private static final String DEBUG_TAG = "ConnectionManager";

    public String getContentFromUrl(String myurl, int readTimeOut, int connectTimeOut, String requestMethod) throws IOException {
        InputStream is = null;
        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(readTimeOut /* milisegundos */);
            conn.setConnectTimeout(connectTimeOut /* milisegundos */);
            conn.setRequestMethod(requestMethod);
            conn.setDoInput(true);
            // Comienza la query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d(DEBUG_TAG, "El código de la respuesta es: " + response);
            is = conn.getInputStream();

            // Se convierte el InputStream en string
            String contentAsString = readIt(is);
            return contentAsString;

            // Nos aseguramos de que el InputStream queda cerrado despues
            // de terminar de usarlo.
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    // Se lee un InputStream y se convierte en String.
    private String readIt(InputStream stream) throws IOException {
        Reader reader = null;
        StringBuilder inputStringBuilder = new StringBuilder();
        reader = new InputStreamReader(stream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while(line != null){
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }
        return inputStringBuilder.toString();
    }

}
