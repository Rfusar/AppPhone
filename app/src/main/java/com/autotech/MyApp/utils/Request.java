package com.autotech.MyApp.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.widget.Toast;;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;



public class Request extends AsyncTask<String, Void, String> {
    private static final int TIMEOUT = 3000;
    private final Context context;
    public Request(Context c){this.context = c;}

    @Override
    protected String doInBackground(String... params){
        String url_str = params[0];
        StringBuilder res_str = new StringBuilder();
        HttpURLConnection conn = null;
        InputStream res = null;
        try{
            URL url = new URL(url_str);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(TIMEOUT);
            conn.setReadTimeout(TIMEOUT);

            int resCode = conn.getResponseCode();
            if(resCode == HttpURLConnection.HTTP_OK){
                res = conn.getInputStream();
                try(JsonReader reader = new JsonReader(new InputStreamReader(res))){
                    reader.beginObject();
                    while(reader.hasNext()){
                        String Key = reader.nextName();
                        if(Key.equals("Id") || Key.equals("message")){
                            res_str.append(reader.nextString()).append(", ");
                        }
                        else{reader.skipValue();}
                    }
                    reader.endObject();
                }
                return res_str.toString();
            }
            else{
                return "Errore nella richiesta HTTP, codice di risposta: " + resCode;
            }
        }
        catch(Exception e){
            return "Errore durante la richiesta: "+e.getMessage();
        }
        finally{
            if (res != null){
                try{res.close();}catch(Exception ignore){}
            }
            if (conn != null){ conn.disconnect(); }
        }
    }
    

    @Override
    protected void onPostExecute(String result){
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
    }

}
