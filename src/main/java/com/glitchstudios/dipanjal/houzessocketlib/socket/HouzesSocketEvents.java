package com.glitchstudios.dipanjal.houzessocketlib.socket;

class HouzesSocketEvents {
    static final String SOCKET_CONNECTED = "connected";
    static final String USER_DISCONNECTED = "user::disconnected";

    static final String LOCATION_UPDATE = "location::update";
    static final String LOCATION_UPDATE_SUCCESS = "location::update.success";
    static final String LOCATION_UPDATE_ERROR = "location::update.error";

    static final String LOCATION_SHARE = "location::share";
    static final String LOCATION_RECEIVE = "location::receive";
    static final String LOCATION_SHARE_SUCCESS = "location::share.success";
    static final String LOCATION_SHARE_ERROR = "location::share.error";

    static final String STOP_DRIVING = "driver::leave";
    static final String DRIVING_STOPPED = "driver::left";
}