package com.example.albionguide.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.albionguide.datasource.DataSource

@Composable
fun CategoryScreen(
    categoryIndex: Int,
    onSubcategoryClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val category = DataSource.mainCategories.getOrNull(categoryIndex)
    GuideListScreen(
        title = category?.name ?: 0,
        description = category?.description ?: 0,
        items = category?.subcategories ?: emptyList(),
        onItemClicked = onSubcategoryClicked,
        modifier = modifier
    )
}