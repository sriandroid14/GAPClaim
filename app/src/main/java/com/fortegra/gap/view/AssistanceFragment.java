package com.fortegra.gap.view;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.fortegra.gap.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssistanceFragment extends Fragment {
    @BindView(R.id.btnAstContinue)
    AppCompatButton btnContinue;
    @BindView(R.id.tvToolBarTitle)
    AppCompatTextView toolBarTitle;
    @BindView(R.id.ivLeftArrow)
    AppCompatImageView ivBackArrow;
    @BindView(R.id.insuranceYesRB)
    AppCompatCheckBox insuranceYesCheckBox;
    @BindView(R.id.insuranceNoRB)
    AppCompatCheckBox insuranceNoCheckBox;
    @BindView(R.id.financeYesRb)
    AppCompatCheckBox financeYesCheckBox;
    @BindView(R.id.financeNoRb)
    AppCompatCheckBox financeNoCheckBox;
    private String insurance="No";
    private String finance="No";

    public static AssistanceFragment newInstance() {
        return new AssistanceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.assistance_fragment, container, false);
        ButterKnife.bind(this,rootView);
        if (toolBarTitle != null){
            toolBarTitle.setText(getString(R.string.app_title));
        }

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 setUIValues(rootView);
                ((MainActivity) Objects.requireNonNull(getActivity())).changeFragment(MileageIncidentFragment.newInstance());
            }
        });
        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) Objects.requireNonNull(getActivity())).changeFragment(WelcomeFragment.newInstance());
            }
        });
        insuranceYesCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    insuranceNoCheckBox.setChecked(false);
                    insurance = "Yes";
                }
            }
        });
        insuranceNoCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    insuranceYesCheckBox.setChecked(false);
                    insurance = "No";
                }
            }
        });
        financeNoCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    financeYesCheckBox.setChecked(false);
                    finance = "No";
                }
            }
        });
        financeYesCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    financeNoCheckBox.setChecked(false);
                    finance = "Yes";
                }
            }
        });
        return rootView;
    }

    private void setUIValues(View v) {

        ((MainActivity) Objects.requireNonNull(getActivity())).getClaimDetails().setVehicleFinanced(finance);
        ((MainActivity) Objects.requireNonNull(getActivity())).getClaimDetails().setSettlementAccepted(insurance);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}
