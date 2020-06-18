package com.example.interceptphonecall;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class InterceptPhoneCall extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        /*try{
            Toast.makeText(context,"Ringing", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(context,"No Ringing", Toast.LENGTH_SHORT).show();
        }*/

       try{
           String state=intent.getStringExtra(TelephonyManager.EXTRA_STATE);

           String number=intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
       //    String number = intent.getStringExtra();
           //putString("number", number);
           if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                if(number!=null){
                    Toast.makeText(context, "Ring " + number, Toast.LENGTH_SHORT).show();
                }

           }
           if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK)){
               if(number!=null){
                   Toast.makeText(context, "Answered " + number, Toast.LENGTH_SHORT).show();
               }

           }
           if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE)){
               if(number!=null){
                   Toast.makeText(context, "Idle "+ number, Toast.LENGTH_SHORT).show();
               }

           }


       }catch (Exception  e){
           e.printStackTrace();
       }
    }
}
