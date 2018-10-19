package shared.model.network

import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.accept
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import kotlinx.serialization.list
import kotlinx.serialization.serializer
import shared.model.entity.GitHubRepo
import kotlin.reflect.KClass

internal class GitHubApi {
    private val mBaseUrl = "https://api.github.com/"
    private val mHttpClient = HttpClient {
        install(JsonFeature) {
            @Suppress("UNCHECKED_CAST")
            serializer = KotlinxSerializer().apply {
                setMapper(List::class as KClass<List<GitHubRepo>>, GitHubRepo::class.serializer().list)
            }
        }

        defaultRequest {
            accept(ContentType.Application.Json)
        }
    }

    suspend fun getRepoList(): List<GitHubRepo> {
        return mHttpClient.request {
            url(mBaseUrl + "repositories")
            method = HttpMethod.Get
        }
    }
}

