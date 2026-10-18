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

public class Data_three extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_three);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-9365753898529237/3990073015", adRequest,
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
            case R.id.btn3_1:
                Intent intent = new Intent(Data_three.this, Data_three_one.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Data_three.this);
                }


                break;
            case R.id.btn3_2:
                intent = new Intent(Data_three.this, Data_three_two.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Data_three.this);
                }


                break;
            case R.id.btn3_3:
                intent = new Intent(Data_three.this, Data_three_three.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Data_three.this);
                }


        }

    }
}