package com.fortegra.gap.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.fortegra.gap.R;
import com.fortegra.gap.model.Claim;

import java.util.Objects;

public class    MainActivity extends AppCompatActivity {
    public Claim claim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            Objects.requireNonNull(getSupportActionBar()).hide();
            changeFragment(WelcomeFragment.newInstance());
        }
        claim=new Claim();
        claim.setName("Ashok.D");
        claim.setContactNumber("+447587869898");
        claim.setEmail("ashok_d@gamil.com");
    }
   // @Override
    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment);
        transaction.commitNow();

    }
    public Claim getClaimDetails(){
        return claim;
    }
}
