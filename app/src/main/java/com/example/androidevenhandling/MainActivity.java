package com.example.androidevenhandling;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button red, blue, green, bigger, smaller, bold, italic, normal,mybutton,mBtn;
    private TextView testtext;
    private boolean isbold = false, isitalic = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testtext = (TextView) findViewById(R.id.testText);
        red = (Button) findViewById(R.id.red);
        green = (Button) findViewById(R.id.green);
        blue = (Button) findViewById(R.id.blue);
        smaller = (Button) findViewById(R.id.smaller);
        bigger = (Button) findViewById(R.id.bigger);
        bold=(Button) findViewById(R.id.bold);
        italic=(Button)findViewById(R.id.italics);
        normal=(Button)findViewById(R.id.normal);
        mybutton=(Button)findViewById(R.id.mybutton);
        mBtn=(Button)findViewById(R.id.mBtn) ;
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("监听事件被触发了");
            }
        });
        mybutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    System.out.println("监听器的事件被触发了");
                }
                return false;
            }
        });
        ColorListner myColorListner = new ColorListner();
        SizeListner mySizeListtner = new SizeListner(testtext);
        bigger.setOnClickListener(mySizeListtner);
        smaller.setOnClickListener(mySizeListtner);
        red.setOnClickListener(myColorListner);
        green.setOnClickListener(myColorListner);
        blue.setOnClickListener(myColorListner);
        italic.setOnClickListener(this);
        bold.setOnClickListener(this);
        normal.setOnClickListener(this);
        testtext.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请输入新的内容");
                builder.setIcon(R.mipmap.ic_launcher);
                final EditText contentTest = new EditText(MainActivity.this);
                builder.setView(contentTest);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        testtext.setText(contentTest.getText().toString());
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.create().show();
                return  false;
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bold:
                isbold = !isbold;
                break;
            case R.id.italics:
                isitalic = !isitalic;
                break;
            case R.id.normal:
                isitalic = false;
                isbold = false;
                break;
            default:
                break;

        }
        if (isitalic){
            if(isbold){
                testtext.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
            }
            else {
                testtext.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);
            }
        }
        else {
            if(isbold){

                testtext.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
            }
            else {
                testtext.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
            }
        }

    }

    public void clickEventHandler(View view){
        Toast.makeText(this,"直接绑定到标签的事件被触发了",Toast.LENGTH_LONG).show();
    }

    private class ColorListner implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.red: {
                    testtext.setTextColor(Color.RED);
                    break;
                }
                case R.id.green: {
                    testtext.setTextColor(Color.GREEN);
                    break;
                }
                case R.id.blue: {
                    testtext.setTextColor(Color.BLUE);
                    break;
                }
                default:
                    break;

            }

        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            System.out.println("Activity中的事件被触发了");
        }
        return false;
    }

}
