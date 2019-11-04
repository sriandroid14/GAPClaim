package com.fortegra.gap.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.fortegra.gap.R;
import com.fortegra.gap.viewmodel.MainViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MileageIncidentFragment extends Fragment {

    private MainViewModel mViewModel;
    @BindView(R.id.btnMileageSubmit)
    AppCompatButton btnSubmit;
    @BindView(R.id.tvToolBarTitle)
    AppCompatTextView toolBarTitle;
    @BindView(R.id.ivLeftArrow)
    AppCompatImageView ivBackArrow;
    @BindView(R.id.edtDate)
    AppCompatEditText edtDate;
    @BindView(R.id.edtMonth)
    AppCompatEditText edtMonth;
    @BindView(R.id.edtYear)
    AppCompatEditText edtYear;
    @BindView(R.id.edtMileage)
    AppCompatEditText edtMileage;


    public static MileageIncidentFragment newInstance() {
        return new MileageIncidentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mileage_incident_fragment, container, false);
        ButterKnife.bind(this,rootView);
        if (toolBarTitle != null){
            toolBarTitle.setText(getString(R.string.app_title));
        }
        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) Objects.requireNonNull(getActivity())).changeFragment(AssistanceFragment.newInstance());
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUiValues();
                ((MainActivity) Objects.requireNonNull(getActivity())).changeFragment(IncidentTypeFragment.newInstance());
            }
        });



        return rootView;
    }

    private void setUiValues() {
        ((MainActivity) Objects.requireNonNull(getActivity())).getClaimDetails().setMileage(edtMileage.getText().toString());
        ((MainActivity) Objects.requireNonNull(getActivity())).getClaimDetails().setIncidentDate(new Date().toString());

    }

    public void  setDate(){}
    @OnClick(R.id.edtDate)
        void seDate(){
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getFragmentManager(), "datePicker");
        }

        public static class DatePickerFragment extends DialogFragment
                implements DatePickerDialog.OnDateSetListener {

            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(Objects.requireNonNull(getActivity()), this, year, month, day);
                dialog.getDatePicker().setMaxDate(c.getTimeInMillis());
                return  dialog;
            }

            public void onDateSet(DatePicker view, int year, int month, int day) {
                //ConverterDate.ConvertDate(year, month + 1, day);
//                edtDate.setText(day);
//                edtMonth.setText(month);
//                edtYear.setText(year);
            }
        }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }


}
