package io.husnikamal.draggableviewimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.husnikamal.draggableviewimplementation.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}