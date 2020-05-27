package com.runup.retrobois;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelSuccess {
    @SerializedName("success")
    @Expose
    private Success success;

    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }
}
