package com.example.androidevenhandling.callbackeventtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;
import android.annotation.SuppressLint;

@SuppressLint("AppCompatCustomView")
public class MyButton extends Button {
    private Context context;
    public MyButton(Context context, AttributeSet attrs){
        super(context,attrs);
        this.context=context;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            /*Toast.makeText(context,"按钮被单击了",Toast.LENGTH_SHORT).show()*/
            System.out.println("MyButton中的事件触发了");
        }
        return false;
    }
}
