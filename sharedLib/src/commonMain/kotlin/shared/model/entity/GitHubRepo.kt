package shared.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubRepo(val id: Int,
                      @SerialName("full_name") val fullName: String,
                      val description: String)
