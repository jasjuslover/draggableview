package io.husnikamal.draggableviewimplementation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import io.github.hyuwah.draggableviewlib.DraggableView;
import io.husnikamal.draggableviewimplementation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initVars();
        initListeners();
    }

    private void initVars() {
        new DraggableView.Builder<ImageView>(binding.ivDrag)
                .setStickyMode(DraggableView.Mode.STICKY_X)
                .build();
    }

    private void initListeners() {
        binding.ivDrag.setOnClickListener((View.OnClickListener) view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, (View) binding.ivDrag, "button");
            startActivity(intent, options.toBundle());
        });
    }
}