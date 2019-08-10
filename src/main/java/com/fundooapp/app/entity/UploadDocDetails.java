package com.fundooapp.app.entity;

public class UploadDocDetails {

    private String documentNm;
    private String userId;
    private String location;
    private String mimeType;

    public UploadDocDetails() {
    }

    public String getDocumentNm() {
        return documentNm;
    }

    public void setDocumentNm(String documentNm) {
        this.documentNm = documentNm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
