package appenginex.com.demoook.data.remote

import appenginex.com.demoook.data.remote.ApiConstants.ApiParams.PAGE
import appenginex.com.demoook.data.remote.ApiConstants.ApiParams.PARAM_DEFAULT_PER_PAGE
import appenginex.com.demoook.data.remote.ApiConstants.ApiParams.PER_PAGE
import appenginex.com.demoook.data.remote.ApiConstants.GET_CONTENTS
import appenginex.com.demoook.domain.models.ItemCard
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET(GET_CONTENTS)
    suspend fun getContents(
        @Query(PAGE) page: Int = 1,
        @Query(PER_PAGE) limit: Int = PARAM_DEFAULT_PER_PAGE
    ): Response<ItemCard>
}