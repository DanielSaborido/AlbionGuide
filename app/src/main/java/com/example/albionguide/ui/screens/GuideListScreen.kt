package com.example.albionguide.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.albionguide.datasource.GuideItem
import com.example.albionguide.ui.theme.AlbionFont

@Composable
fun GuideListScreen(
    title: Int,
    description: Int,
    items: List<GuideItem>,
    onItemClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = AlbionFont,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(
                top = 20.dp,
                bottom = 8.dp
            )
        )
        Text(
            text = stringResource(description),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontFamily = AlbionFont,
                fontWeight = FontWeight.Normal
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(items) { index, item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onItemClicked(index)
                        },
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 2.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = stringResource(item.name),
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontFamily = AlbionFont,
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = stringResource(item.description),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontFamily = AlbionFont,
                                fontWeight = FontWeight.Normal
                            ),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(top = 6.dp)
                        )
                    }
                }
            }
        }
    }
}