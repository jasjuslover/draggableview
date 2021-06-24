package io.husnikamal.draggableviewimplementation;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import io.github.hyuwah.draggableviewlib.DraggableView;

public class MasterActivity extends AppCompatActivity {

    private boolean isScrolled = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView ivDrag = (ImageView) findViewById(R.id.iv_drag);
        DraggableView someDraggable = new DraggableView.Builder<ImageView>(ivDrag)
                .setStickyMode(DraggableView.Mode.STICKY_X)
                .build();

        NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.scroll);
        scrollView.setOnTouchListener((view, motionEvent) -> {
            Handler handler = new Handler();


            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_SCROLL:
                case MotionEvent.ACTION_DOWN:
                    Log.d("HUWIW", "ACTION_MOVE/ACTION_SCROLL");
                    handler.removeCallbacksAndMessages(null);
                    isScrolled = true;
                    someDraggable.hide(500);
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.d("HUWIW", "ACTION_DOWN");
                    handler.removeCallbacksAndMessages(null);
                    if (!isScrolled) {
                        someDraggable.hide(500);
                        isScrolled = true;
                    }
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    Log.d("HUWIW", "ACTION_CANCEL/ACTION_UP");
                    handler.postDelayed(() -> {
                        someDraggable.show(500);
                        isScrolled = false;
                    }, 500);
                    break;
            }
            return false;
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}