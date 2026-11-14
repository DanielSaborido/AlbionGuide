package com.example.albionguide.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.albionguide.R
import com.example.albionguide.datasource.DataSource

@Composable
fun StartScreen(
    onCategoryClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    GuideListScreen(
        title = R.string.home_title,
        description = R.string.home_description,
        items = DataSource.mainCategories,
        onItemClicked = { index ->
            onCategoryClicked(index)
        },
        modifier = modifier
    )
}