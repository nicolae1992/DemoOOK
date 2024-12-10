package appenginex.com.demoook.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class SupportInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Token", "ookgroup")
            .build()
        return chain.proceed(request)
    }

}