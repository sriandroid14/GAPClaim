package com.fortegra.gap.view;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

public class MileageIncidentFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    public static String TAG = MileageIncidentFragment.class.getSimpleName();

    private MainViewModel mViewModel;
    @BindView(R.id.btnMileageSubmit)
    AppCompatButton btnSubmit;
    @BindView(R.id.tvToolBarTitle)
    AppCompatTextView toolBarTitle;
    @BindView(R.id.ivLeftArrow)
    AppCompatImageView ivBackArrow;
    @BindView(R.id.edtDate)
    AppCompatEditText edtDate;
    @BindView(R.id.edtMileage)
    AppCompatEditText edtMileage;
    @BindView(R.id.btnToday)
    AppCompatButton btnToday;
    @BindView(R.id.btnYesterday)
    AppCompatButton btnYesterDay;
    @BindView(R.id.btnWeek)
    AppCompatButton btnWeek;
    private String finalDate;

    public static MileageIncidentFragment newInstance() {
        return new MileageIncidentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mileage_incident_fragment, container, false);
        ButterKnife.bind(this, rootView);
        if (toolBarTitle != null) {
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
        ((MainActivity) Objects.requireNonNull(getActivity())).getClaimDetails().setIncidentDate(edtDate.getText().toString());

    }


    @OnClick(R.id.imgDate)
    void setDate() {
        DatePiker();
    }
    @OnClick(R.id.btnToday)
    void setTodayDate() {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        String formattedDate = df.format(c);
        edtDate.setText(formattedDate);
    }
    @OnClick(R.id.btnYesterday)
    void setYesterdayDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        String formattedDate = df.format(cal.getTime());
        edtDate.setText(formattedDate);

    }
    @OnClick(R.id.btnWeek)
    void setWeekDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        String formattedDate = df.format(cal.getTime());
        edtDate.setText(formattedDate);
    }


    public void DatePiker() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                MileageIncidentFragment.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(Objects.requireNonNull(getActivity()).getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String inputDate = "" + dayOfMonth + "/" + (++monthOfYear) + "/" + year;
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd MMM yyyy");
        try {
            Date date = inputDateFormat.parse(inputDate);
            finalDate = outputDateFormat.format(date);

        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
        edtDate.setText(finalDate);
    }

}
