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

import android.app.Activity
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.albionguide.ui.screens.ActivityScreen
import com.example.albionguide.ui.screens.CategoryScreen
import com.example.albionguide.ui.screens.StartScreen
import com.example.albionguide.ui.theme.AlbionFont
import com.example.albionguide.ui.theme.AlbionGuideTheme

// Screen enum
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

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AlbionGuideApp(
    navController: NavHostController = rememberNavController()
) {
    val activity = LocalContext.current as Activity
    val windowSizeClass = calculateWindowSizeClass(activity)
    val systemTheme = isSystemInDarkTheme()
    var isDarkTheme by rememberSaveable {
        mutableStateOf(systemTheme)
    }
    AlbionGuideTheme(isDarkTheme) {
        AlbionGuideContent(
            navController = navController,
            windowSizeClass = windowSizeClass,
            isDarkTheme = isDarkTheme,
            onThemeToggle = {isDarkTheme = !isDarkTheme}
        )
    }
}

// App content and navigation
@Composable
private fun AlbionGuideContent(
    navController: NavHostController,
    windowSizeClass: WindowSizeClass,
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val currentScreen = AlbionGuideScreen.entries.firstOrNull {
        it.route == currentRoute
    } ?: AlbionGuideScreen.Start
    val categoryIndex =
        backStackEntry?.arguments?.getInt("categoryIndex")
    val isCompact =
        windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact
    val navigationItems = listOf(
        null
    ) + com.example.albionguide.datasource.DataSource.mainCategories.indices.map { it }

    Scaffold(
        contentWindowInsets = WindowInsets.safeDrawing,
        topBar = {
            AlbionGuideAppBar(
                currentScreen = currentScreen,
                isDarkTheme = isDarkTheme,
                onThemeToggle = onThemeToggle,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        bottomBar = {
            if (isCompact) {
                MobileNavigationBar(
                    items = navigationItems,
                    selectedCategoryIndex = categoryIndex,
                    isHomeSelected = currentRoute == AlbionGuideScreen.Start.route,
                    onItemSelected = { index ->
                        navigateToItem(navController, index)
                    }
                )
            }
        }
    ) { innerPadding ->

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (!isCompact) {
                TabletNavigationRail(
                    items = navigationItems,
                    selectedCategoryIndex = categoryIndex,
                    isHomeSelected = currentRoute == AlbionGuideScreen.Start.route,
                    onItemSelected = { index ->
                        navigateToItem(navController, index)
                    }
                )
            }

            NavHost(
                navController = navController,
                startDestination = AlbionGuideScreen.Start.route,
                modifier = Modifier.weight(1f)
            ) {
                composable(AlbionGuideScreen.Start.route) {
                    StartScreen(
                        onCategoryClicked = { index ->
                            navController.navigate("Category/$index")
                        }
                    )
                }

                composable(
                    route = AlbionGuideScreen.Category.route,
                    arguments = listOf(
                        navArgument("categoryIndex") {
                            type = NavType.IntType
                        }
                    )
                ) { entry ->
                    val index =
                        entry.arguments?.getInt("categoryIndex") ?: 0

                    CategoryScreen(
                        categoryIndex = index,
                        onSubcategoryClicked = { subcategoryIndex ->
                            navController.navigate(
                                "Activity/$index/$subcategoryIndex"
                            )
                        }
                    )
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
                ) { entry ->
                    val index =
                        entry.arguments?.getInt("categoryIndex") ?: 0
                    val subcategoryIndex =
                        entry.arguments?.getInt("subcategoryIndex") ?: 0

                    ActivityScreen(
                        categoryIndex = index,
                        subcategoryIndex = subcategoryIndex
                    )
                }
            }
        }
    }
}

// Navigation destination
private fun navigateToItem(
    navController: NavHostController,
    categoryIndex: Int?
) {
    val route = if (categoryIndex == null) {
        AlbionGuideScreen.Start.route
    } else {
        "Category/$categoryIndex"
    }

    navController.navigate(route) {
        popUpTo(AlbionGuideScreen.Start.route) {
            inclusive = false
        }
        launchSingleTop = true
    }
}

// App bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AlbionGuideAppBar(
    currentScreen: AlbionGuideScreen,
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    var themeMenuExpanded by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {
            Text(
                text = stringResource(currentScreen.title),
                style = MaterialTheme.typography.displayLarge.copy(
                    fontFamily = AlbionFont,
                    fontWeight = FontWeight.ExtraBold
                ),
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.navigation_back),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = onThemeToggle) {
                Icon(
                    imageVector = if (isDarkTheme)
                        Icons.Default.DarkMode
                    else
                        Icons.Default.LightMode,
                    contentDescription = if (isDarkTheme)
                        "Switch to dark theme"
                    else
                        "Switch to light theme",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
    )
}

// Mobile bottom navigation
@Composable
private fun MobileNavigationBar(
    items: List<Int?>,
    selectedCategoryIndex: Int?,
    isHomeSelected: Boolean,
    onItemSelected: (Int?) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 3.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 6.dp)
        ) {
            items.forEach { index ->
                val selected = if (index == null) {
                    isHomeSelected
                } else {
                    selectedCategoryIndex == index
                }
                Column(
                    modifier = Modifier
                        .width(88.dp)
                        .clickable {
                            onItemSelected(index)
                        }
                        .padding(vertical = 6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = if (index == null)
                            Icons.Default.Home
                        else
                            Icons.Default.Category,
                        contentDescription = null,
                        tint = if (selected)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (index == null) {
                            "Home"
                        } else {
                            stringResource(
                                com.example.albionguide.datasource.DataSource
                                    .mainCategories[index].name
                            )
                        },
                        maxLines = 1,
                        style = MaterialTheme.typography.labelSmall,
                        color = if (selected)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

// Tablet side navigation
@Composable
private fun TabletNavigationRail(
    items: List<Int?>,
    selectedCategoryIndex: Int?,
    isHomeSelected: Boolean,
    onItemSelected: (Int?) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(100.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 3.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items.forEach { index ->
                val selected = if (index == null) {
                    isHomeSelected
                } else {
                    selectedCategoryIndex == index
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onItemSelected(index)
                        }
                        .padding(vertical = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = if (index == null)
                            Icons.Default.Home
                        else
                            Icons.Default.Category,
                        contentDescription = null,
                        tint = if (selected)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (index == null) {
                            "Home"
                        } else {
                            stringResource(
                                com.example.albionguide.datasource.DataSource
                                    .mainCategories[index].name
                            )
                        },
                        maxLines = 2,
                        style = MaterialTheme.typography.labelSmall,
                        color = if (selected)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}