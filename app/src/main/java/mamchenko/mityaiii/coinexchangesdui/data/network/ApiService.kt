package mamchenko.mityaiii.coinexchangesdui.data.network

import retrofit2.http.GET

interface ApiService {
    @GET("server/v1/storage/user-settings")
    suspend fun getUIComponents(): String
}