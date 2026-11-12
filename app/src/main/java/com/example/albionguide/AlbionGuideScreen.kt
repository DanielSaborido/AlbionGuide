/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.albionguide

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// TODO: Screen enum
enum class AlbionGuideScreen(
    val route: String,
    @StringRes val title: Int
) {
    Start(
        route = "Start",
        title = R.string.app_name
    ),
    Category(
        route = "Category/{categoryIndex}",
        title = R.string.categories_title
    ),
    Activity(
        route = "Activity/{categoryIndex}/{subcategoryIndex}",
        title = R.string.activity_description
    )
}

// TODO: AppBar
/**
 * Composable that displays the topBar and displays
 * back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbionGuideAppBar(
    currentScreen: AlbionGuideScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(stringResource(id = currentScreen.title))
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.navigation_back)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbionGuideApp(
    navController: NavHostController = rememberNavController()
) {
    // TODO: Create Controller and initialization
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val currentScreen = AlbionGuideScreen.entries.firstOrNull {
        it.route == currentRoute
    } ?: AlbionGuideScreen.Start
    Scaffold(
        topBar = {
            AlbionGuideAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = {
                    navController.navigateUp()
                }
            )
        }
    ) { innerPadding ->
        // TODO: Navigation host
        NavHost(
            navController = navController,
            startDestination = AlbionGuideScreen.Start.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(
                route = AlbionGuideScreen.Start.route
            ) {
                // TODO: Main screen
            }

            composable(
                route = AlbionGuideScreen.Category.route,
                arguments = listOf(
                    navArgument("categoryIndex") {
                        type = NavType.IntType
                    }
                )
            ) {
                // TODO: Category screen
            }

            composable(
                route = AlbionGuideScreen.Activity.route,
                arguments = listOf(
                    navArgument("categoryIndex") {
                        type = NavType.IntType
                    },
                    navArgument("subcategoryIndex") {
                        type = NavType.IntType
                    }
                )
            ) {
                // TODO: Activity screen
            }
        }
    }
}