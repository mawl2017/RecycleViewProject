package com.example.ma.recycleviewproject.activity_two;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.ma.recycleviewproject.R;
import com.example.ma.recycleviewproject.adapter.RecycleViewAdapter;
import com.example.ma.recycleviewproject.bean.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2Activity extends Activity {
    private RecyclerView rcv2;
    private RecycleViewAdapter adapter2;
    private List<Message> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        rcv2= (RecyclerView) findViewById(R.id.rc_lv2);
        //获取数据
        initData();
        // 1，这里必须写这一句，不然View显示不出来，也是这一句话可以控制布局为LinearLayout或者是GridView或者是瀑布流布局
//        rcv.setLayoutManager(new LinearLayoutManager(this));


        //2,效果2 瀑布流
//        rcv.setLayoutManager(new GridLayoutManager(this,2));


        //效果3 值需要 添加的两行代码即可
        rcv2.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));


        //为RecycleView绑定触摸事件
        helper.attachToRecyclerView(rcv2);
//
//
//            //设置Item增加、移除动画
        rcv2.setItemAnimator(new DefaultItemAnimator());
//
//
        adapter2 = new RecycleViewAdapter(list2);
        rcv2.setAdapter(adapter2);

        setListener();

    }

    private void setListener() {
//        rcv2.addOnItemTouchListener(new ItemTouchHelper(rcv2) {
//            @Override
//            public void onItemClick(RecyclerView.ViewHolder viewHolder) {
//                //TODO:点击事件
//            }
//
//            @Override
//            public void onLongClick(RecyclerView.ViewHolder viewHolder) {
//                //当 item 被长按且不是第一个时，开始拖曳这个 item
//                if (viewHolder.getLayoutPosition() != 0) {
//                    helper.startDrag(viewHolder);
//                }
//            }
//        });

    }


    /**
     * 获取数据
     */
    private void initData() {
        list2 = new ArrayList<>();
        list2.add(new Message("Hensen", "下午1:meinv8", "老板：哈哈哈", R.mipmap.head_1));
        list2.add(new Message("流年不利", "早上10:31", "美女：呵呵哒", R.mipmap.head_2));
        list2.add(new Message("1402", "下午1:55", "嘻嘻哈哈", R.mipmap.head_3));
        list2.add(new Message("Unstoppable", "下午4:32", "美美哒", R.mipmap.head_1));
        list2.add(new Message("流年不利", "晚上7:meinv8", "萌萌哒", R.mipmap.head_2));
        list2.add(new Message("Hensen", "下午1:meinv8", "哈哈哈", R.mipmap.head_4));
        list2.add(new Message("nihao", "下午1:meinv8", "哈哈哈", R.mipmap.head_1));
        list2.add(new Message("buzhidao", "下午1:meinv8", "是啊哈", R.mipmap.head_2));
        list2.add(new Message("流年不利", "晚上7:meinv8", "萌萌哒", R.mipmap.head_2));
        list2.add(new Message("1402", "下午1:55", "嘻嘻哈", R.mipmap.head_3));
        list2.add(new Message("流年不利", "早上10:31", "美女：呵呵哒", R.mipmap.head_2));
        list2.add(new Message("Unstoppable", "下午4:32", "美美哒", R.mipmap.head_1));
        list2.add(new Message("流年不利", "晚上7:meinv8", "萌萌哒", R.mipmap.head_2));
        list2.add(new Message("Hensen", "下午1:meinv8", "哈哈哈", R.mipmap.head_4));
    }



    /**
     *  为RecycleView绑定触摸事件
     */
    ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            Log.d("info", "getMovementFlags");
            //   首先回调的方法 返回int表示是否监听该方向
            //如果是 Grid样式
//            swipeFlags 都设置为0，暂时不考虑滑动相关操作。

            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                //首先回调的方法 返回int表示是否监听该方向
                //2，效果2 瀑布流
                int dragFlags = ItemTouchHelper.UP|ItemTouchHelper.DOWN|ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;//拖拽
//                int swipeFlags = 0;//侧滑 不 删除
                int swipeFlags = ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;//侧滑删除
                return makeMovementFlags(dragFlags,swipeFlags);
            }else{
                //1,效果1
                int dragFlags = ItemTouchHelper.UP|ItemTouchHelper.DOWN;//拖拽
                int swipeFlags = ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;//侧滑删除
                //   int swipeFlags = 0;//侧滑 不 删除

                //注意：和拖曳的区别就是在这里
//                int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                return makeMovementFlags(dragFlags,swipeFlags);
            }


        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            Log.d("info","onMove");
            //滑动事件  交换数据 方法1
            //这里判断如果目标 item 是首个 item，那么就直接返回false，表示不响应此次拖曳移动
            if(target.getAdapterPosition()==0){
                return false;
            }
            Collections.swap(list2, viewHolder.getAdapterPosition(), target.getAdapterPosition());
            adapter2.notifyItemMoved(viewHolder.getAdapterPosition(),target.getAdapterPosition());
            return true;

            //滑动数据 交换海事局 方法 2
            //拖动的 item 的下标
//            int fromPosition = viewHolder.getAdapterPosition();
//            //目标 item 的下标，目标 item 就是当拖曳过程中，不断和拖动的 item 做位置交换的条目。
//            int toPosition = target.getAdapterPosition();
//            if (fromPosition < toPosition) {
//                for (int i = fromPosition; i < toPosition; i++) {
//                    Collections.swap(((RecycleViewAdapter) adapter).getDataList(), i, i + 1);
//                }
//            } else {
//                for (int i = fromPosition; i > toPosition; i--) {
//                    Collections.swap(((RecycleViewAdapter) adapter).getDataList(), i, i - 1);
//                }
//            }
//            adapter.notifyItemMoved(fromPosition, toPosition);
//            return true;

        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            Log.d("info","onSwiped");
            //侧滑事件
            list2.remove(viewHolder.getAdapterPosition());
            adapter2.notifyItemRemoved(viewHolder.getAdapterPosition());
        }

        @Override
        public boolean isLongPressDragEnabled() {
            Log.d("info","isLongPressDragEnabled");
            //是否可拖拽
            return true;
        }

        //当长按 item 刚开始拖曳的时候调用
        @Override
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            Log.d("info", "onSelectedChanged-----长按 item 开始退拽");
            //当 item 被长按且不是第一个时，开始拖曳这个 item

            if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                //给被拖曳的 item 设置一个深颜色背景
                viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
            }

            super.onSelectedChanged(viewHolder, actionState);
        }

        //当完成拖曳手指松开的时候调用
        @Override
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            Log.d("info", "clearView---完成退拽 ");
            Toast.makeText(Main2Activity.this,"你摸我干嘛，流氓。。。",Toast.LENGTH_SHORT).show();
            //给已经完成拖曳的 item 恢复开始的背景。
            //这里我们设置的颜色尽量和你 item 在 xml 中设置的颜色保持一致
            viewHolder.itemView.setBackgroundColor(Color.GRAY);

        }



    });




}
