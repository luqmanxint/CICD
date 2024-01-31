package com.myfirstcompose

import android.app.Application
import android.content.Context
//import com.chuckerteam.chucker.api.ChuckerCollector
//import com.chuckerteam.chucker.api.ChuckerInterceptor
//import com.chuckerteam.chucker.api.RetentionManager
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import timber.log.Timber
import timber.log.Timber.Forest.plant
import com.myfirstcompose.BuildConfig


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
            val context: Context = this
            Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                    .enableDumpapp {
                        Stetho.DefaultDumperPluginsBuilder(context)
                            .provide(MyDumperPlugin())
                            .finish()
                    }
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
                    .build()
            )


// Create the Collector
//            val chuckerCollector = ChuckerCollector(
//                context = this,
//                // Toggles visibility of the notification
//                showNotification = true,
//                // Allows to customize the retention period of collected data
//                retentionPeriod = RetentionManager.Period.ONE_HOUR
//            )
//
//// Create the Interceptor
//            val chuckerInterceptor = ChuckerInterceptor.Builder(this)
//                // The previously created Collector
//                .collector(chuckerCollector)
//                // The max body content length in bytes, after this responses will be truncated.
//                .maxContentLength(250_000L)
//                // List of headers to replace with ** in the Chucker UI
//                .redactHeaders("Auth-Token", "Bearer")
//                // Read the whole response body even when the client does not consume the response completely.
//                // This is useful in case of parsing errors or when the response body
//                // is closed before being read like in Retrofit with Void and Unit types.
//                .alwaysReadResponseBody(true)
//                // Use decoder when processing request and response bodies. When multiple decoders are installed they
//                // are applied in an order they were added.
////                .addBodyDecoder(decoder)
//                // Controls Android shortcut creation.
//                .createShortcut(true)
//                .build()
//
//// Don't forget to plug the ChuckerInterceptor inside the OkHttpClient
//            val client = OkHttpClient.Builder()
//                .addInterceptor(chuckerInterceptor)
//                .build()

            val client2 = OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()


        }


    }
}