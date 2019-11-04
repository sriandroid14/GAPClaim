package com.fortegra.gap.view;

import androidx.appcompat.widget.AppCompatButton;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
    @BindView(R.id.rgInsurance)
    RadioGroup rgInsurance;
    @BindView(R.id.rgFinance)
    RadioGroup rgFinance;

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
                 setUIValues(v);
                ((MainActivity) Objects.requireNonNull(getActivity())).changeFragment(MileageIncidentFragment.newInstance());
            }
        });
        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) Objects.requireNonNull(getActivity())).changeFragment(WelcomeFragment.newInstance());
            }
        });
        return rootView;
    }

    private void setUIValues(View v) {
        int selectedInsuranceId = rgInsurance.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        RadioButton insuranceRB = (RadioButton)v. findViewById(selectedInsuranceId);
        int selectedFinaceId = rgFinance.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        RadioButton financeRB = (RadioButton)v. findViewById(selectedFinaceId);


        ((MainActivity) Objects.requireNonNull(getActivity())).getClaimDetails().setVehicleFinanced(insuranceRB.getText().toString());
        ((MainActivity) Objects.requireNonNull(getActivity())).getClaimDetails().setSettlementAccepted(financeRB.getText().toString());

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}
