package com.example.broadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class BroadcastExample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction() == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            int isTurnedOn;
            try {
                isTurnedOn = Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON);
            } catch (Settings.SettingNotFoundException e) {
                throw new RuntimeException(e);
            }
            Toast.makeText(context, "Is Airplane mode enabled? "+ (isTurnedOn == 1 ? "true": "false"), Toast.LENGTH_SHORT).show();
        }
    }
}
