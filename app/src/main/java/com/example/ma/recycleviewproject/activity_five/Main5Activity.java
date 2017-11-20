package com.example.ma.recycleviewproject.activity_five;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.ma.recycleviewproject.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main5Activity extends Activity {
    private MyRecyclerView55 mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mDatas;
    private ImageView mImg ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            setContentView(R.layout.activity_main5);
            mImg = (ImageView) findViewById(R.id.id_content5);
            mRecyclerView = (MyRecyclerView55) findViewById(R.id.id_recyclerview_horizontal5);
            initdata();
            setListener();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void initdata() {
        mDatas = new ArrayList<Integer>(Arrays.asList( R.mipmap.meinv1, R.mipmap.meinv2, R.mipmap.meinv3,
                R.mipmap.meinv4, R.mipmap.meinv5, R.mipmap.meinv6, R.mipmap.meinv7,
                R.mipmap.meinv8, R.mipmap.meinv9));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new GalleryAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setListener() {
        mRecyclerView.setOnItemScrollChangeListener(new MyRecyclerView55.OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                mImg.setImageResource(mDatas.get(position));
            }

            ;
        });

        mAdapter.setOnItemClickLitener(new GalleryAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
//              Toast.makeText(getApplicationContext(), position + "", Toast.LENGTH_SHORT)
//                      .show();
                mImg.setImageResource(mDatas.get(position));
            }
        });
    }
}
