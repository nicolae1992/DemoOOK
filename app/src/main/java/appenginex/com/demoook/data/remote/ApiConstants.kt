package appenginex.com.demoook.data.remote

import appenginex.com.demoook.data.remote.ApiConstants.ApiParams.PAGE
import appenginex.com.demoook.data.remote.ApiConstants.ApiParams.PER_PAGE

object ApiConstants {
    const val IMAGE_BASE_URL = "https://cdn.otkritkiok.ru/posts/thumbs/"
    const val GET_CONTENTS = "v0/postcards/page/home"
    object ApiParams{
        const val PAGE = "page"
        const val PER_PAGE = "limit"
        const val PARAM_DEFAULT_PER_PAGE = 30
    }
}