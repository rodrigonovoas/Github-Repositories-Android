package app.rodrigonovoa.githubrepositores

import android.app.Application
import app.rodrigonovoa.githubrepositores.di.networkModules
import app.rodrigonovoa.githubrepositores.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class GithubRepositoriesApp: Application() {
    override fun onCreate() {
        super.onCreate()

        koinSetup()
        timberSetup()
    }

    private fun koinSetup(){
        startKoin {
            androidContext(this@GithubRepositoriesApp)
            modules(listOf(viewModelModules, networkModules))
        }
    }

    private fun timberSetup(){
        Timber.plant(Timber.DebugTree())
    }
}