package appenginex.com.demoook

import android.app.Application
import appenginex.com.demoook.utils.AppLog
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OOKApp: Application(){
    override fun onCreate() {
        super.onCreate()
        AppLog.init()
    }
}