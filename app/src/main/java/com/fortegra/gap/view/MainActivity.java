package com.fortegra.gap.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.fortegra.gap.R;

import java.util.Objects;

public class    MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            Objects.requireNonNull(getSupportActionBar()).hide();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, WelcomeFragment.newInstance())
                    .commitNow();
        }
    }
}
