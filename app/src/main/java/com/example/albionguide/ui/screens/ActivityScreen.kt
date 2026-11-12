
package com.example.albionguide.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.albionguide.datasource.DataSource

@Composable
fun ActivityScreen(
    categoryIndex: Int,
    subcategoryIndex: Int,
    modifier: Modifier = Modifier
) {
    val category = DataSource.mainCategories.getOrNull(categoryIndex)
    val activity = category?.subcategories?.getOrNull(subcategoryIndex)

    if (activity == null) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Activity not found",
                style = MaterialTheme.typography.titleLarge
            )
        }
    } else {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = stringResource(activity.name),
                style = MaterialTheme.typography.headlineMedium
            )
            DetailCard(
                title = stringResource(
                    com.example.albionguide.R.string.activity_description
                ),
                content = stringResource(activity.description)
            )
            DetailCard(
                title = stringResource(
                    com.example.albionguide.R.string.activity_how_it_works
                ),
                content = "Information about how this activity works will go here."
            )
            DetailCard(
                title = stringResource(
                    com.example.albionguide.R.string.activity_requirements
                ),
                content = "Requirements for this activity will go here."
            )
            DetailCard(
                title = stringResource(
                    com.example.albionguide.R.string.activity_tips
                ),
                content = "Tips and useful advice will go here."
            )
            DetailCard(
                title = stringResource(
                    com.example.albionguide.R.string.activity_rewards
                ),
                content = "Rewards from this activity will go here."
            )
            DetailCard(
                title = stringResource(
                    com.example.albionguide.R.string.activity_difficulty
                ),
                content = "Difficulty information will go here."
            )
            DetailCard(
                title = stringResource(
                    com.example.albionguide.R.string.activity_recommended_build
                ),
                content = "Recommended equipment and builds will go here."
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun DetailCard(
    title: String,
    content: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}