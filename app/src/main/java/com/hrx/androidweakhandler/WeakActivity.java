package com.hrx.androidweakhandler;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hrx.libhandler.IHandlerMsg;
import com.hrx.libhandler.WeakHandlerMsg;

/**
 * Created by hrx on 2018/5/28.
 *
 */
public class WeakActivity extends AppCompatActivity implements View.OnClickListener {

    private final int handlerTip = 1000;

    private WeakHandlerMsg<IHandlerMsg> mHandler;
    private IHandlerMsg mIMsg = new IHandlerMsg() {
        @Override
        public void handlerMsg(Message msg) {
            switch (msg.what) {
                case handlerTip:

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weak);

        mHandler = new WeakHandlerMsg<>(mIMsg);

        this.findViewById(R.id.btn_send_msg).setOnClickListener(this);
        this.findViewById(R.id.btn_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_send_msg:
                mHandler.sendEmptyMessageDelayed(handlerTip, 6000 * 1000);
                break;
            case R.id.btn_back:
                this.finish();
                break;
        }
    }
}
