package appenginex.com.demoook.data.remote

import appenginex.com.demoook.utils.AppLog
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import okhttp3.internal.ignoreIoExceptions
import javax.inject.Inject


class SupportAuthenticator @Inject constructor() : Authenticator {

    val TAG = AppLog.tagFor(this.javaClass)

    override fun authenticate(route: Route?, response: Response): Request {

        val requestBuilder: Request.Builder = response.request.newBuilder()
        requestBuilder.addHeader("Accept", "Accept: application/json")
        try {
            requestBuilder.addHeader("Token", "ookgroup")
            return requestBuilder.build()
        } catch (ex: Exception) {
            ignoreIoExceptions {
                AppLog.showDebug(TAG, ex.message.toString())
            }
        }
        return requestBuilder.build()

    }
}