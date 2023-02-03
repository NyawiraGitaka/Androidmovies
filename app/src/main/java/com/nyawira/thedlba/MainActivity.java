package com.nyawira.thedlba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://jsonplaceholder.typicode.com/posts/1";
        Ion.with(MainActivity.this)
                .load(url)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if (e != null){
                            return;
                        }
                        int userId = result.get("userId").getAsInt();
                        int id = result.get("id").getAsInt();
                        String title = result.get("title").getAsString();
                        String body = result.get("body").getAsString();
                        // do stuff with the result or error
                        System.out.println("Object  " + result);
                        System.out.println("Error   " + e);
                    }
                });
    }
}