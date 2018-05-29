package com.hrx.libhandler;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

public class WeakHandlerMsg<T extends IHandlerMsg> extends Handler {
    private WeakReference<T> mIMsg;

    public WeakHandlerMsg(T t) {
        mIMsg = new WeakReference<>(t);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        IHandlerMsg t = mIMsg.get();
        t.handlerMsg(msg);
    }

}
