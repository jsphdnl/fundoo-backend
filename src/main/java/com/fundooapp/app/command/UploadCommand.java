package com.fundooapp.app.command;

import java.util.List;

public class UploadCommand {

    private String uuid;

    private String documentNm;

    private String issuerId;

    private String location;

    private String mimeType;

    private List<String> beneficiarIds;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDocumentNm() {
        return documentNm;
    }

    public void setDocumentNm(String documentNm) {
        this.documentNm = documentNm;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
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

    public List<String> getBeneficiarIds() {
        return beneficiarIds;
    }

    public void setBeneficiarIds(List<String> beneficiarIds) {
        this.beneficiarIds = beneficiarIds;
    }
}
