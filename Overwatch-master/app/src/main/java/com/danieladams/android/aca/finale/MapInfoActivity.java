package com.danieladams.android.aca.finale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MapInfoActivity extends AppCompatActivity {

    private int mPosition;
    private View mDecorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_info);
        mDecorView = getWindow().getDecorView();
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        mPosition = getIntent().getIntExtra("position", -1);
        String str = MainActivity.mapNames.get(mPosition).toLowerCase().replace(" ", "").replace(":", "").replace("'", "");
        TouchImageView img = (TouchImageView)findViewById(R.id.img_map);
        int resId = getResources().getIdentifier("map_" + str, "drawable", MainActivity.PACKAGE_NAME);
        img.setImageResource(resId);
    }
}
