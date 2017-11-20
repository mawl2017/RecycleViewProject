package com.example.ma.recycleviewproject.activity_threen;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ma.recycleviewproject.R;

public class Main3Activity extends Activity {

    private LinearLayout mGallery;
    private int[] mImgIds;
    private LayoutInflater mInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mInflater = LayoutInflater.from(this);
        initData();
        initView();

    }

    private void initView() {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);

        for (int i = 0; i < mImgIds.length; i++)
        {
            View view = mInflater.inflate(R.layout.activity_index_gallery_item,
                    mGallery, false);
            ImageView img = (ImageView) view
                    .findViewById(R.id.id_index_gallery_item_image);
            img.setImageResource(mImgIds[i]);
            TextView txt = (TextView) view
                    .findViewById(R.id.id_index_gallery_item_text);
            txt.setText("第"+i+"张");
            mGallery.addView(view);
        }
    }

    private void initData() {
        mImgIds = new int[] { R.mipmap.meinv1, R.mipmap.meinv2, R.mipmap.meinv3,
                R.mipmap.meinv4, R.mipmap.meinv5, R.mipmap.meinv6, R.mipmap.meinv7,
                R.mipmap.meinv8, R.mipmap.meinv9 };
    }


}
