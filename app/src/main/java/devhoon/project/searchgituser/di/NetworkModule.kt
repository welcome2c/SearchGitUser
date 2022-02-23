package devhoon.project.searchgituser.di

import android.util.Log
import devhoon.project.searchgituser.data.GitHubApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val TIME_OUT = 10L

val debugInterceptor = HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Log.d("API", message)
    }
}).apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val authInterceptor = object : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.newBuilder()
        builder.addHeader("Authorization", "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")
        request = builder.build()

        return chain.proceed(request)
    }
}

val httpClientModule = module {
    single {
        OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(debugInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }
}

val githubApiModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(GitHubApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .create(GitHubApi::class.java)
    }
}