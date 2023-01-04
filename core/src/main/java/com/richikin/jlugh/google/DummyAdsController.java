package com.richikin.jlugh.google;

import com.richikin.jlugh.logging.Trace;

public class DummyAdsController implements AdsController
{
    @Override
    public void showBannerAd()
    {
        Trace.checkPoint();
    }

    @Override
    public void hideBannerAd()
    {
        Trace.checkPoint();
    }

    @Override
    public boolean isWifiConnected()
    {
        Trace.checkPoint();

        return false;
    }

    @Override
    public void showInterstitialAd( Runnable then )
    {
        Trace.checkPoint();

        if ( then == null )
        {
            Trace.dbg( "Runnable parameter is NULL" );
        }
    }
}
