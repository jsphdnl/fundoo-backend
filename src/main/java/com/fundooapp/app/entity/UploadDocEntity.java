package com.fundooapp.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;
import java.util.UUID;

@UserDefinedType("type_uploadDocument")
public class UploadDocEntity implements Entity{

    @Id
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

    public UploadDocEntity(String documentNm, String userId, String location, String type){
        this.documentNm = documentNm;
        this.issuerId = userId;
        this.location = location;
        this.mimeType = type;
        this.uuid = UUID.randomUUID().toString();
    }


    @Override
    public String getId() {
        return this.uuid;
    }
}
