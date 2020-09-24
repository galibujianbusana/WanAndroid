package com.example.zhexianview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView rvStickyExample = (RecyclerView) findViewById(R.id.rv_sticky_example);
        final TextView tvStickyHeaderView = (TextView) findViewById(R.id.tv_sticky_header_view);

        rvStickyExample.setLayoutManager(new LinearLayoutManager(this));
        rvStickyExample.setAdapter(new StickyExampleAdapter(this, DataUtil.getData()));
        rvStickyExample.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                View stickyInfoView = recyclerView.findChildViewUnder(
                        tvStickyHeaderView.getMeasuredWidth() / 2, 5);

                if (stickyInfoView != null && stickyInfoView.getContentDescription() != null) {
                    tvStickyHeaderView.setText(String.valueOf(stickyInfoView.getContentDescription()));
                }

                View transInfoView = recyclerView.findChildViewUnder(
                        tvStickyHeaderView.getMeasuredWidth() / 2, tvStickyHeaderView.getMeasuredHeight() + 1);

                if (transInfoView != null && transInfoView.getTag() != null) {

                    int transViewStatus = (int) transInfoView.getTag();
                    int dealtY = transInfoView.getTop() - tvStickyHeaderView.getMeasuredHeight();

                    if (transViewStatus == StickyExampleAdapter.HAS_STICKY_VIEW) {
                        if (transInfoView.getTop() > 0) {
                            tvStickyHeaderView.setTranslationY(dealtY);
                        } else {
                            tvStickyHeaderView.setTranslationY(0);
                        }
                    } else if (transViewStatus == StickyExampleAdapter.NONE_STICKY_VIEW) {
                        tvStickyHeaderView.setTranslationY(0);
                    }
                }
            }
        });
    }


}
