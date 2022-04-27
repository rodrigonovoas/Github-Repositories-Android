package app.rodrigonovoa.githubrepositores

import android.app.Application
import app.rodrigonovoa.githubrepositores.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class GithubRepositoriesApp: Application() {
    override fun onCreate() {
        super.onCreate()

        koinSetup()
    }

    private fun koinSetup(){
        startKoin {
            androidContext(this@GithubRepositoriesApp)
            modules(viewModelModules)
        }
    }
}