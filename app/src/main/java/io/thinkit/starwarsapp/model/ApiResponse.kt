package io.thinkit.starwarsapp.model


data class SwApiResponse(
    val count: Int,
    val results: List<Film>
)


data class Film(
    val title: String,
    val episode_id: Int,
    val director: String,
    val producer: String,
    var opening_crawl: String,
    var release_date: String,
    var created: String,
    var edited: String,
    val url: String
)



