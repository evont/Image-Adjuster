package com.vain.evontwu.imageadjust;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

/**
 * Created by EvontWu on 2015/8/24.
 */
public class ColorMatrix extends Activity {
    private ImageView imc;
    private GridLayout igroup;
    private Bitmap bmp;
    private int iETwidth;
    private int iETheight;
    private EditText[] iEts = new EditText[20];
    private float[] iColorMatrix = new float[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colormatrix);
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.s2);
        imc = (ImageView) findViewById(R.id.ivc);
        igroup = (GridLayout) findViewById(R.id.group);
        imc.setImageBitmap(bmp);
        igroup.post(new Runnable() {
            @Override
            public void run() {
                iETheight = igroup.getHeight() / 4;
                iETwidth = igroup.getWidth() / 5 ;
                addEts();
                initMatrix();
            }
        });
    }

    private void getMatrix(){
        for (int i = 0; i < 20; i++) {
            iColorMatrix[i]=Float.valueOf(iEts[i].getText().toString());
        }
    }
    private void setImageMatrix(){
        Bitmap bp = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), Bitmap.Config.ARGB_8888);
        android.graphics.ColorMatrix colormatrix = new android.graphics.ColorMatrix();
        colormatrix.set(iColorMatrix);
        Canvas canvas = new Canvas(bp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new ColorMatrixColorFilter(colormatrix));
        canvas.drawBitmap(bmp,0,0,paint);
        imc.setImageBitmap(bp);
    }

    public void btnChange(View view){
        getMatrix();
        setImageMatrix();
    }

    public void btnReset(View view){
        initMatrix();
        getMatrix();
        setImageMatrix();
    }

    private void addEts(){
        for (int i = 0; i < 20; i++) {
            EditText edittext = new EditText(ColorMatrix.this);
            iEts[i] = edittext;
            igroup.addView(edittext,iETwidth,iETheight);
        }
    }
    private void initMatrix(){
        for (int i = 0; i < 20; i++) {
            if(i % 6 == 0){
                iEts[i].setText(String.valueOf(1));
            }else{
                iEts[i].setText(String.valueOf(0));
            }
        }

    }
}
