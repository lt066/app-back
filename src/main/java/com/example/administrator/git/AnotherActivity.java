package com.example.administrator.git;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ViewStub;
import android.widget.TextView;

public class AnotherActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewstub);
        Intent i = getIntent();
        String text = i.getStringExtra("data");
        System.out.println(text);
        if(text.equals("1"))
        {
            ViewStub viewStub = (ViewStub) findViewById(R.id.viewstub_text);
            viewStub.inflate();
            TextView text1 = (TextView) findViewById(R.id.text1);
            text1.setText("输入1");
        }
        else if(text.equals("2"))
        {
            ViewStub viewStub = (ViewStub)findViewById(R.id.viewstub_text2);
            viewStub.inflate();
            TextView text2 = (TextView) findViewById(R.id.textView2);
            text2.setText("anotherActivity");
        }
        else
        {
            ViewStub viewStub = (ViewStub) findViewById(R.id.viewstub_text);
            viewStub.inflate();
            TextView text1 = (TextView) findViewById(R.id.text1);
            text1.setText("输入其他");
        }
    }

}
