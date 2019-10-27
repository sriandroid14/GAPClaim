package com.fortegra.gap.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Claim {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contactnumber")
    @Expose
    private String contactNumber;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mileage")
    @Expose
    private String mileage;
    @SerializedName("incidentate")
    @Expose
    private String incidentDate;
    @SerializedName("incidenttype")
    @Expose
    private String incidentType;
    @SerializedName("vehiclefinanced")
    @Expose
    private String vehicleFinanced;
    @SerializedName("settlementaccepted")
    @Expose
    private String settlementAccepted;
    @SerializedName("insurerlossdate")
    @Expose
    private String insurerLossDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(String incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getVehicleFinanced() {
        return vehicleFinanced;
    }

    public void setVehicleFinanced(String vehicleFinanced) {
        this.vehicleFinanced = vehicleFinanced;
    }

    public String getSettlementAccepted() {
        return settlementAccepted;
    }

    public void setSettlementAccepted(String settlementAccepted) {
        this.settlementAccepted = settlementAccepted;
    }

    public String getInsurerLossDate() {
        return insurerLossDate;
    }

    public void setInsurerLossDate(String insurerLossDate) {
        this.insurerLossDate = insurerLossDate;
    }





}
