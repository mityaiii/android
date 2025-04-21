package mamchenko.mityaiii.coinexchangesdui.data.repositories

import com.google.gson.GsonBuilder
import mamchenko.mityaiii.coinexchangesdui.data.factories.UIComponentMapperFactory
import mamchenko.mityaiii.coinexchangesdui.data.network.ApiService
import mamchenko.mityaiii.coinexchangesdui.domain.repositories.UIComponentRepository
import mamchenko.mityaiii.coinexchangesdui.infrastructure.uicomponents.UIComponent

class UIComponentRepositoryImpl(
    private val factory: UIComponentMapperFactory,
    private val apiService: ApiService
) : UIComponentRepository {
    override suspend fun getUIComponent(): UIComponent {
        val componentJson = apiService.getUIComponents()
        val gson = GsonBuilder()
            .registerTypeAdapter(UIComponent::class.java, factory)
            .create()

        return gson.fromJson(componentJson, UIComponent::class.java)
    }
}