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

public class Data_nine extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_nine);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-9365753898529237/3820899666", adRequest,
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
            case R.id.btn9_1:
                Intent intent = new Intent(Data_nine.this, Data_nine_one.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Data_nine.this);
                }


                break;
            case R.id.btn9_2:
                intent = new Intent(Data_nine.this, Data_nine_two.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Data_nine.this);
                }


                break;
            case R.id.btn9_3:
                intent = new Intent(Data_nine.this, Data_nine_three.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Data_nine.this);
                }


                break;
            case R.id.btn9_4:
                intent = new Intent(Data_nine.this, Data_nine_four.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Data_nine.this);
                }

        }
    }
}