package com.fortegra.gap.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fortegra.gap.R;
import com.fortegra.gap.model.Claim;
import com.fortegra.gap.viewmodel.MainViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfirmDetailsFragment extends Fragment {

    private MainViewModel mViewModel;
    @BindView(R.id.btnConfirmSubmit)
    AppCompatButton btnSubmit;
    @BindView(R.id.tvToolBarTitle)
    AppCompatTextView toolBarTitle;
    @BindView(R.id.ivLeftArrow)
    AppCompatImageView ivBackArrow;

    @BindView(R.id.name)
    AppCompatTextView name;
    @BindView(R.id.contactNumber)
    AppCompatTextView contactNumber;
    @BindView(R.id.email)
    AppCompatTextView email;


    @BindView(R.id.mileage)
    AppCompatTextView mileage;
    @BindView(R.id.settlement)
    AppCompatTextView settlement;
    @BindView(R.id.incidentdate)
    AppCompatTextView incidentDate;

    @BindView(R.id.incidentType)
    AppCompatTextView incidentType;
    @BindView(R.id.finace)
    AppCompatTextView finance;

    public static ConfirmDetailsFragment newInstance() {
        return new ConfirmDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.confirmation_details_fragment, container, false);
        ButterKnife.bind(this,rootView);
        if (toolBarTitle != null){
            toolBarTitle.setText(getString(R.string.app_title));
        }
       Claim claim= ((MainActivity) Objects.requireNonNull(getActivity())).getClaimDetails();
        name.setText(claim.getName());
        contactNumber.setText(claim.getContactNumber());
        email.setText(claim.getEmail());
        mileage.setText(claim.getMileage());
        incidentDate.setText(claim.getIncidentDate());
        incidentType.setText(claim.getIncidentType());
        finance.setText(claim.getVehicleFinanced());
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) Objects.requireNonNull(getActivity())).changeFragment(DiPreWelcomeFragment.newInstance());
            }
        });
        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) Objects.requireNonNull(getActivity())).changeFragment(IncidentTypeFragment.newInstance());
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}
