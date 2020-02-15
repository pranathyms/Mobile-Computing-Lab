package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.jar.Attributes;


public class DrawView extends View {

    Paint p1 = new Paint();
    Paint p2 = new Paint();
    Paint p3 = new Paint();
    Paint p4 = new Paint();
    static boolean Flag=false;

    private void init() {
        p1.setColor(Color.BLUE);
        p2.setColor(Color.BLACK);
        p3.setColor(Color.YELLOW);
        p4.setColor(Color.GREEN);
    }

    public DrawView(Context context) {
        super(context);
        init();
    }

    public static void activateFlag(){
        Flag =true;
    }

    public static void deactivateFlag(){
        Flag =false;
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas) {
       if(Flag){
           //canvas.drawLine(0, 0, 300, 300, p1);
           canvas.drawCircle(450, 400, 50, p2);
           canvas.drawCircle(600, 400, 50, p2);
           canvas.drawRect(350, 200, 700, 350, p3);
           //canvas.drawArc(219F, 269F, 169F, 69F, 0F, 69F, false, p4);
           Toast toast=Toast.makeText(getContext(),"true",Toast.LENGTH_LONG);
           toast.show();
       }
       else{
           canvas.drawLine(0, 0, 300, 300, p1);
           canvas.drawCircle(500, 500, 50, p2);
           //canvas.drawCircle(600, 400, 50, p2);
           canvas.drawRect(350, 200, 700, 350, p3);
           Paint p = new Paint();
           RectF rectF = new RectF(10, 10, 510, 510);
           p.setColor(Color.BLACK);
           canvas.drawArc (rectF, 90, 45, true, p);
           Toast toast=Toast.makeText(getContext(),"false",Toast.LENGTH_LONG);
           toast.show();
       }

    }
}
