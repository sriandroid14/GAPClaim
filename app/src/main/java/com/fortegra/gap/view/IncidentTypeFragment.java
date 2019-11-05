package com.fortegra.gap.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fortegra.gap.R;
import com.fortegra.gap.viewmodel.MainViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Date;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IncidentTypeFragment extends Fragment {

    private MainViewModel mViewModel;
    @BindView(R.id.btnIncidentTypeSubmit)
    AppCompatButton btnSubmit;
    @BindView(R.id.tvToolBarTitle)
    AppCompatTextView toolBarTitle;
    @BindView(R.id.ivLeftArrow)
    AppCompatImageView ivBackArrow;
    @BindView(R.id.btnTheft)
    AppCompatButton btnTheft;
    @BindView(R.id.btnFire)
    AppCompatButton btnFire;
    @BindView(R.id.btnVandalism)
    AppCompatButton btnVandalism;
    @BindView(R.id.btnRoadAccident)
    AppCompatButton btnRoadAccident;
    @BindView(R.id.btnFlood)
    AppCompatButton btnFlood;

    String incidentType;

    public static IncidentTypeFragment newInstance() {
        return new IncidentTypeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.incident_type_fragment, container, false);
        ButterKnife.bind(this, rootView);
        if (toolBarTitle != null) {
            toolBarTitle.setText(getString(R.string.app_title));
        }
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 setUiValues();
                ((MainActivity) Objects.requireNonNull(getActivity())).changeFragment(ConfirmDetailsFragment.newInstance());
            }
        });
        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) Objects.requireNonNull(getActivity())).changeFragment(MileageIncidentFragment.newInstance());
            }
        });


        return rootView;
    }

    @OnClick(R.id.btnTheft)
    void OnClick1(View view) {
        btnTheft.setBackground(getResources().getDrawable(R.drawable.border_background_green));
        btnTheft.setTextColor(getResources().getColor(R.color.lightGreen));
        btnFire.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnFire.setTextColor(getResources().getColor(R.color.black));
        btnVandalism.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnVandalism.setTextColor(getResources().getColor(R.color.black));
        btnRoadAccident.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnRoadAccident.setTextColor(getResources().getColor(R.color.black));
        btnFlood.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnFlood.setTextColor(getResources().getColor(R.color.black));
        incidentType = "Theft";

    }

    @OnClick(R.id.btnFire)
    void OnClick2(View view) {
        btnTheft.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnTheft.setTextColor(getResources().getColor(R.color.black));
        btnFire.setBackground(getResources().getDrawable(R.drawable.border_background_green));
        btnFire.setTextColor(getResources().getColor(R.color.lightGreen));
        btnVandalism.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnVandalism.setTextColor(getResources().getColor(R.color.black));
        btnRoadAccident.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnRoadAccident.setTextColor(getResources().getColor(R.color.black));
        btnFlood.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnFlood.setTextColor(getResources().getColor(R.color.black));
        incidentType = "Fire";

    }

    @OnClick(R.id.btnVandalism)
    void OnClick3(View view) {
        btnTheft.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnTheft.setTextColor(getResources().getColor(R.color.black));
        btnFire.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnFire.setTextColor(getResources().getColor(R.color.black));
        btnVandalism.setBackground(getResources().getDrawable(R.drawable.border_background_green));
        btnVandalism.setTextColor(getResources().getColor(R.color.lightGreen));
        btnRoadAccident.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnRoadAccident.setTextColor(getResources().getColor(R.color.black));
        btnFlood.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnFlood.setTextColor(getResources().getColor(R.color.black));
        incidentType = "Vandalism";

    }

    @OnClick(R.id.btnRoadAccident)
    void OnClick4(View view) {
        btnTheft.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnTheft.setTextColor(getResources().getColor(R.color.black));
        btnFire.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnFire.setTextColor(getResources().getColor(R.color.black));
        btnVandalism.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnVandalism.setTextColor(getResources().getColor(R.color.black));
        btnRoadAccident.setBackground(getResources().getDrawable(R.drawable.border_background_green));
        btnRoadAccident.setTextColor(getResources().getColor(R.color.lightGreen));
        btnFlood.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnFlood.setTextColor(getResources().getColor(R.color.black));
        incidentType = "Road accident";

    }

    @OnClick(R.id.btnFlood)
    void OnClick5(View view) {
        btnTheft.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnTheft.setTextColor(getResources().getColor(R.color.black));
        btnFire.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnFire.setTextColor(getResources().getColor(R.color.black));
        btnVandalism.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnVandalism.setTextColor(getResources().getColor(R.color.black));
        btnRoadAccident.setBackground(getResources().getDrawable(R.drawable.border_background));
        btnRoadAccident.setTextColor(getResources().getColor(R.color.black));
        btnFlood.setBackground(getResources().getDrawable(R.drawable.border_background_green));
        btnFlood.setTextColor(getResources().getColor(R.color.lightGreen));
        incidentType = "Flood";
    }

    private void setUiValues() {
        ((MainActivity) Objects.requireNonNull(getActivity())).getClaimDetails().setIncidentType(incidentType);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }
}
