package com.app.template;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.app.foodmenu.R;

public class SplashActivity extends Activity {

    private final Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        init();
    }

    private void init() {
        TextView text = (TextView) findViewById(R.id.text);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        text.startAnimation(scale);

        mHandler.sendMessageDelayed(new Message(), 3000);
    }
}
