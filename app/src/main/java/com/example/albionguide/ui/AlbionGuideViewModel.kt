package com.example.albionguide.ui

import androidx.lifecycle.ViewModel
import com.example.albionguide.datasource.DataSource
import com.example.albionguide.model.AlbionGuideUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AlbionGuideViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AlbionGuideUiState())
    val uiState: StateFlow<AlbionGuideUiState> = _uiState.asStateFlow()

    fun updateTheme(isDark: Boolean) {
        _uiState.update {
            it.copy(isDarkTheme = isDark)
        }
    }

    fun selectTabletCategory(index: Int?) {
        _uiState.update {
            it.copy(
                tabletCategoryIndex = index,
                tabletSubcategoryIndex =
                    if (index != null &&
                        DataSource.mainCategories[index].subcategories.isNotEmpty()
                    ) 0 else null
            )
        }
    }

    fun selectTabletSubcategory(index: Int) {
        _uiState.update {
            it.copy(tabletSubcategoryIndex = index)
        }
    }

    fun restoreTabletSelection(
        categoryIndex: Int?,
        subcategoryIndex: Int?
    ) {
        _uiState.update {
            it.copy(
                tabletCategoryIndex = categoryIndex,
                tabletSubcategoryIndex = subcategoryIndex
            )
        }
    }
}