package appenginex.com.demoook.data.repository

import appenginex.com.demoook.data.remote.Resource
import appenginex.com.demoook.domain.models.ItemCard
import kotlinx.coroutines.flow.Flow

interface ContentsRepository {
    fun getContent(page: Int, perPage: Int? = 30): Flow<Resource<ItemCard>>
}