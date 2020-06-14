package com.example.facebookkotlinads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.ads.*
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private var interstitilAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AudienceNetworkAds.initialize(this)
        showBanner()
        showInterstitialAd()
    }

    private fun showBanner() {
        val adView = AdView(this, getString(R.string.banner), AdSize.BANNER_HEIGHT_50)
        banner_container.removeView(adView)
        banner_container.addView(adView)
        adView.loadAd()
    }

    private fun showInterstitialAd() {
        interstitilAd = InterstitialAd(this, getString(R.string.interstitial))
        interstitilAd!!.setAdListener(object : InterstitialAdListener{
            override fun onInterstitialDisplayed(p0: Ad?) {

            }

            override fun onError(p0: Ad?, p1: AdError?) {
            }

            override fun onAdLoaded(p0: Ad?) {
                interstitilAd!!.show()
            }

            override fun onAdClicked(p0: Ad?) {
            }

            override fun onInterstitialDismissed(p0: Ad?) {
            }

            override fun onLoggingImpression(p0: Ad?) {
            }
        })
        interstitilAd!!.loadAd()
    }
}
