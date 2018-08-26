
package com.mentors.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("hot_line")
    @Expose
    private String hotLine;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("face_account")
    @Expose
    private String faceAccount;
    @SerializedName("googleplus")
    @Expose
    private String googleplus;
    @SerializedName("twitter")
    @Expose
    private String twitter;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHotLine() {
        return hotLine;
    }

    public void setHotLine(String hotLine) {
        this.hotLine = hotLine;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFaceAccount() {
        return faceAccount;
    }

    public void setFaceAccount(String faceAccount) {
        this.faceAccount = faceAccount;
    }

    public String getGoogleplus() {
        return googleplus;
    }

    public void setGoogleplus(String googleplus) {
        this.googleplus = googleplus;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

}
