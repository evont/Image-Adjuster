package com.vain.evontwu.imageadjust;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnImageAdjust(View view){
        Intent i = new Intent(this,ImageAdjust.class);
        startActivity(i);
    }
    public void btnColorMatrix(View view){
        Intent i = new Intent(this,ColorMatrix.class);
        startActivity(i);
    }

}
