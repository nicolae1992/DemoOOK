package appenginex.com.demoook.domain.usecase

import appenginex.com.demoook.data.repository.ContentsRepositoryImpl
import javax.inject.Inject

class GetContentUseCase @Inject constructor(private val repository: ContentsRepositoryImpl) {
    suspend operator fun invoke(page: Int, perPage: Int?) =
        repository.getContent(page = page, perPage = perPage)
}