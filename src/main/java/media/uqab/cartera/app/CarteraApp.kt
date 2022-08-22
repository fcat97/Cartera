package media.uqab.cartera.app

import android.app.Application
import media.uqab.libAuth.di.authModule
import media.uqab.libCartera.di.dataStoreModule
import media.uqab.libCartera.di.walletModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class CarteraApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CarteraApp)
            loadKoinModules(
                listOf(
                    walletModule,
                    authModule,
                    dataStoreModule
                )
            )
        }
    }
}