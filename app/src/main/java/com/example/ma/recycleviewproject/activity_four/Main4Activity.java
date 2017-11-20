package com.example.ma.recycleviewproject.activity_four;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.ma.recycleviewproject.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main4Activity extends Activity {

    private MyHorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter mAdapter;
    private ImageView mImg;
    private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(
            R.mipmap.meinv1, R.mipmap.meinv2, R.mipmap.meinv3,
            R.mipmap.meinv4, R.mipmap.meinv5, R.mipmap.meinv6, R.mipmap.meinv7,
            R.mipmap.meinv8, R.mipmap.meinv9));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mImg = (ImageView) findViewById(R.id.id_content_four);

        mHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.id_horizontalScrollView_four);



        mAdapter = new HorizontalScrollViewAdapter(this, mDatas);
        //添加滚动回调
        mHorizontalScrollView
                .setCurrentImageChangeListener(new MyHorizontalScrollView.CurrentImageChangeListener() {
                    @Override
                    public void onCurrentImgChanged(int position,
                                                    View viewIndicator) {
                        mImg.setImageResource(mDatas.get(position));
                        viewIndicator.setBackgroundColor(Color
                                .parseColor("#AA024DA4"));
                        Log.d("info","选择了谁");
                    }
                });
        //添加点击回调
        mHorizontalScrollView.setOnItemClickListener(new MyHorizontalScrollView.OnItemClickListener()
        {

            @Override
            public void onClick(View view, int position)
            {
                mImg.setImageResource(mDatas.get(position));
                view.setBackgroundColor(Color.parseColor("#AA024DA4"));
                Log.d("info","点击了我");
            }
        });
        //设置适配器
        mHorizontalScrollView.initDatas(mAdapter);


    }
}
