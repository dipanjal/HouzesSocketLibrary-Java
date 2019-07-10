package com.glitchstudios.dipanjal.houzessocketlib.socket;

import com.google.gson.JsonObject;

import org.json.JSONObject;

public interface HouzesSocketEventListener {
    void onConnect();
    void onConnected(String userEmail);
    void onError(Exception error);
    void onLocationUpdateSuccess(JSONObject userLocation);
    void onLocationUpdateError(String errorMessage);
    void onLocationReceived(JSONObject driverLocation);
    void onLocationShareError(String errorMessage);
    void onUserDisconnected(JSONObject disconnectedUser);
    void onDisconnect();
}
