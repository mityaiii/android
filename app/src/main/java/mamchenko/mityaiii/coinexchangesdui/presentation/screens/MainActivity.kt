package mamchenko.mityaiii.coinexchangesdui.presentation.screens

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mamchenko.mityaiii.coinexchangesdui.data.factories.UIComponentMapperFactory
import mamchenko.mityaiii.coinexchangesdui.data.network.RetrofitClient
import mamchenko.mityaiii.coinexchangesdui.data.repositories.UIComponentRepositoryImpl
import mamchenko.mityaiii.coinexchangesdui.domain.usecases.GetUIComponentUseCaseImpl
import mamchenko.mityaiii.coinexchangesdui.presentation.mappers.DomainToViewMapper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        }
        setContentView(rootLayout)

        val apiService = RetrofitClient.apiService
        val factory = UIComponentMapperFactory()
        val uiComponentRepository = UIComponentRepositoryImpl(
            factory,
            apiService
        )
        val getUIComponentUseCase = GetUIComponentUseCaseImpl(uiComponentRepository)
        val domainToViewMapper = DomainToViewMapper()

        lifecycleScope.launch {
            val uiComponent = withContext(Dispatchers.IO) {
                getUIComponentUseCase.execute()
            }
            val generatedView = domainToViewMapper.mapToView(this@MainActivity, uiComponent)
            rootLayout.addView(generatedView)
        }
    }
}