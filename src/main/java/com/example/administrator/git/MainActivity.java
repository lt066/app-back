package com.example.administrator.git;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private EditText edittext;
    private Button button;
    private Handler mhandler;
    private boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mhandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                exit = false;
            }
        };

        edittext = (EditText)findViewById(R.id.edittext1);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AnotherActivity.class);
                i.putExtra("data",edittext.getText().toString());
                startActivity(i);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.viewstub);
                ViewStub viewStub = (ViewStub) findViewById(R.id.viewstub_text2);
                viewStub.inflate();
                TextView text2 = (TextView) findViewById(R.id.textView2);
                text2.setText("anotherActivity");
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.viewstub);
                ViewStub viewStub = (ViewStub) findViewById(R.id.viewstub_text);
                viewStub.inflate();
                TextView text1 = (TextView) findViewById(R.id.text1);
                text1.setText("输入1");
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
           exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit()
    {
        if(!exit)
        {
            exit = true;
            Toast t = Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT);
            t.show();
            mhandler.sendEmptyMessageDelayed(0,2000);

        }

        else
        {
            finish();
            System.exit(0);
        }
    }
}
