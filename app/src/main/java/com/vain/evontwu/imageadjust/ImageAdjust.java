package com.vain.evontwu.imageadjust;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class ImageAdjust extends Activity implements SeekBar.OnSeekBarChangeListener{

    private ImageView iv;
    private SeekBar seekHue,seekSatraution,seekLum;
    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;
    private float iHue,iSatruation,iLum;
    private Bitmap bmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageadjust);
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.s1);
        seekHue = (SeekBar) findViewById(R.id.seekHue);
        seekSatraution = (SeekBar) findViewById(R.id.seekSatraution);
        seekLum = (SeekBar) findViewById(R.id.seekLum);
        iv= (ImageView) findViewById(R.id.imV);
        seekHue.setOnSeekBarChangeListener(this);
        seekLum.setOnSeekBarChangeListener(this);
        seekSatraution.setOnSeekBarChangeListener(this);
seekLum.setMax(MAX_VALUE);seekHue.setMax(MAX_VALUE);seekSatraution.setMax(MAX_VALUE);
        seekSatraution.setProgress(MID_VALUE);seekHue.setProgress(MID_VALUE);
        seekLum.setProgress(MID_VALUE);
        iv.setImageBitmap(bmp);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
switch (seekBar.getId()){
    case R.id.seekHue:
        iHue = (progress - MID_VALUE) * 1.0F/MID_VALUE * 100;
        break;
    case R.id.seekSatraution:
        iSatruation = progress *1.0F / MID_VALUE;
        break;
    case R.id.seekLum:
        iLum =  progress *1.0F / MID_VALUE;
        break;
}
        iv.setImageBitmap(ImageHandler.effectHandler(bmp, iHue, iLum, iSatruation));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
