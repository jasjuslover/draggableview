package io.husnikamal.draggableviewimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import io.github.hyuwah.draggableviewlib.DraggableView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();
    }

    private void initVars() {
        ImageView ivDrag = (ImageView) findViewById(R.id.iv_drag);
        new DraggableView.Builder<ImageView>(ivDrag)
                .setStickyMode(DraggableView.Mode.STICKY_X)
                .build();
    }
}