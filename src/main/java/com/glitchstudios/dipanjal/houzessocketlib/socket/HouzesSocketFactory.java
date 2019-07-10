package com.glitchstudios.dipanjal.houzessocketlib.socket;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

class HouzesSocketFactory {

    static Socket getSocket(String host, String token) throws URISyntaxException{
        IO.Options opts = new IO.Options();
        opts.query = "token="+token;
        return IO.socket(host,opts);
    }
}