package com.glitchstudios.dipanjal.houzessocketlib.socket;

import org.json.JSONObject;

public interface HouzesSocketEventListener {
    void onConnect();
    void onConnected(String userEmail);
    void onError(Exception error);
    void onLocationUpdateSuccess(JSONObject userLocation);
    void onLocationUpdateError(String errorMessage);
    void onLocationReceived(JSONObject driverLocation);
    void onLocationShareSuccess(JSONObject driverLocation);
    void onLocationShareError(String errorMessage);
    void onStopDriving(JSONObject leftUser);
    void onUserDisconnected(JSONObject disconnectedUser);
    void onDisconnect();
}
