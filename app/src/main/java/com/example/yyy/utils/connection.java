package com.example.yyy.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class connection {
    Context context;
        public connection(Context context){
            this.context= context;

        }
        public boolean isConnected(){
            ConnectivityManager connectivityManager;
            connectivityManager = (ConnectivityManager)context.getSystemService(CONNECTIVITY_SERVICE);
            if (connectivityManager!= null){
                NetworkInfo info=connectivityManager.getActiveNetworkInfo();
                if(info !=null){
                    if(info.getState()==NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }

            }
            return false;
        }

    }

