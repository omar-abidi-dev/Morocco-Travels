package com.Visiting_Morocco.Guide;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Data_six extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_six);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-9365753898529237/2699389682", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });
    }


    public <guide> void guide(View view) {
        switch (view.getId()) {
            case R.id.btn6_1:
                Intent intent = new Intent(Data_six.this, Data_six_one.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Data_six.this);
                }


                break;
            case R.id.btn6_2:
                intent = new Intent(Data_six.this, Data_six_two.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Data_six.this);
                }


                break;
            case R.id.btn6_3:
                intent = new Intent(Data_six.this, Data_six_three.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Data_six.this);
                }

        }

        }
}