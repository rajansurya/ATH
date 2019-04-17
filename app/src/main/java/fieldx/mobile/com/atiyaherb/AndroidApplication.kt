package fieldx.mobile.com.atiyaherb

import android.app.Activity
import android.app.Application
import com.dagger.inject.DaggerAppATHComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AndroidApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppATHComponent.builder().applicationATH(this).buildATH().injectAppcationContext(this)
    }

    /*companion object {
        fun getAppContext() = this
    }*/
}