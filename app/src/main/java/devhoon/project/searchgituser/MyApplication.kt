package devhoon.project.searchgituser

import android.app.Application
import org.koin.core.context.startKoin
import devhoon.project.searchgituser.di.*

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    githubApiModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}