package org.lrhsd.storm.user16;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

import net.glxn.qrgen.android.QRCode;

import java.io.ByteArrayOutputStream;

import de.greenrobot.event.EventBus;

public class QrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        String output = EventBus.getDefault().removeStickyEvent(String.class);
        Display disp = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        ByteArrayOutputStream code = QRCode.from(output).withSize(size.x-10,size.x-10).stream();
        byte[] byteArray = code.toByteArray();
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView myImage = (ImageView) findViewById(R.id.qrImg);

        myImage.setMinimumHeight(size.y-10);
        myImage.setMinimumWidth(size.x-10);
        myImage.setMaxHeight(size.y-10);
        myImage.setMaxWidth(size.x-10);
        myImage.setImageBitmap(bmp);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void deleteAndExit(View v){
        //Back to main screen code
    }
}
