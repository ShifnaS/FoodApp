package info.apatrix.foodapp.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;

public class ResultSignUp {

    @SerializedName("response")
    private JSONObject response;
    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private boolean status;

    public JSONObject getResponse() {
        return response;
    }

    public void setResponse(JSONObject response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
