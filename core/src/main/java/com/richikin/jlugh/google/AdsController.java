package com.richikin.jlugh.google;

@SuppressWarnings( { "SameReturnValue" } )
public interface AdsController
{
    void showBannerAd();

    void hideBannerAd();

    void showInterstitialAd( Runnable runnable );

    boolean isWifiConnected();
}
