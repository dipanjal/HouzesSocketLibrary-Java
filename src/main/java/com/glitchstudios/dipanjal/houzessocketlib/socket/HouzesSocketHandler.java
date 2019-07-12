package com.glitchstudios.dipanjal.houzessocketlib.socket;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;

import org.json.JSONObject;


public class HouzesSocketHandler {

    private static final String TAG = "HouzesSocketHandler";

    private static Socket houzesSocket;

    public static void listen(String host, String accessToken, final HouzesSocketEventListener houzesSocketEventListener) throws Exception {
        houzesSocket = HouzesSocketFactory.getSocket(host, accessToken);

        houzesSocket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                houzesSocketEventListener.onConnect();
            }
        }).on(HouzesSocketEvents.SOCKET_CONNECTED, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                houzesSocketEventListener.onConnected((String) args[0]);
            }
        }).on(Socket.EVENT_ERROR, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                houzesSocketEventListener.onError((Exception) args[0]);
            }

        }).on(HouzesSocketEvents.LOCATION_RECEIVE, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                houzesSocketEventListener.onLocationReceived((JSONObject) args[0]);
            }

        }).on(HouzesSocketEvents.LOCATION_SHARE_SUCCESS, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                houzesSocketEventListener.onLocationShareSuccess((JSONObject) args[0]);
            }

        }).on(HouzesSocketEvents.LOCATION_SHARE_ERROR, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                houzesSocketEventListener.onLocationShareError((String) args[0]);
            }

        }).on(HouzesSocketEvents.LOCATION_UPDATE_SUCCESS, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                houzesSocketEventListener.onLocationUpdateSuccess((JSONObject) args[0]);
            }

        }).on(HouzesSocketEvents.LOCATION_UPDATE_ERROR, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                houzesSocketEventListener.onLocationUpdateError((String) args[0]);
            }

        }).on(HouzesSocketEvents.DRIVING_STOPPED, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                houzesSocketEventListener.onStopDriving((JSONObject) args[0]);
            }

        }).on(HouzesSocketEvents.USER_DISCONNECTED, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                houzesSocketEventListener.onUserDisconnected((JSONObject) args[0]);
            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                houzesSocketEventListener.onDisconnect();
            }

        });

        houzesSocket.connect();
    }

    public static void updateUserLocation(Object jsonObject) throws Exception {
        String data = "";
        if (jsonObject.getClass().getSimpleName().equals(String.class.getSimpleName())) {
            data = String.valueOf(jsonObject);
        } else {
            data = new Gson().toJson(jsonObject);
        }
        houzesSocket.emit(HouzesSocketEvents.LOCATION_UPDATE, data);
    }

    public static void shareLocation(Object jsonObject) throws Exception {
        String data = "";
        if (jsonObject.getClass().getSimpleName().equals(String.class.getSimpleName())) {
            data = String.valueOf(jsonObject);
        } else {
            data = new Gson().toJson(jsonObject);
        }
        houzesSocket.emit(HouzesSocketEvents.LOCATION_SHARE, data);
    }

    public static void stopDriving() throws Exception {
        houzesSocket.emit(HouzesSocketEvents.STOP_DRIVING);
    }

    public static void disconnectSocket() throws Exception {
        houzesSocket.disconnect();
    }
}