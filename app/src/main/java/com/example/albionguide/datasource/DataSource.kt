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

package com.example.albionguide.datasource

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.albionguide.R

/**
 * Represents a category, subcategory or activity
 * displayed in the Albion Guide.
 */
data class GuideItem(
    @StringRes val name: Int,
    @StringRes val description: Int,
    //@DrawableRes val image: Int,
    val subcategories: List<GuideItem> = emptyList()
)

/**
 * Map of available categories and subcategories
 * to be displayed in the Albion Guide.
 */
object DataSource {
    val mainCategories = listOf(
        GuideItem(
            name = R.string.category_gathering,
            description = R.string.category_gathering_desc,
            //image = R.drawable.category_gathering,
            subcategories = listOf(
                GuideItem(
                    name = R.string.gathering_basics,
                    description = R.string.gathering_basics_desc,
                    //image = R.drawable.gathering_basics
                ),
                GuideItem(
                    name = R.string.gathering_tips,
                    description = R.string.gathering_tips_desc,
                    //image = R.drawable.gathering_tips
                ),
                GuideItem(
                    name = R.string.gathering_specialization,
                    description = R.string.gathering_specialization_desc,
                    //image = R.drawable.gathering_specialization
                ),
                GuideItem(
                    name = R.string.gathering_danger_zones,
                    description = R.string.gathering_danger_zones_desc,
                    //image = R.drawable.gathering_danger_zones
                )
            )
        ),

        GuideItem(
            name = R.string.category_crafting,
            description = R.string.category_crafting_desc,
            //image = R.drawable.category_crafting,
            subcategories = listOf(
                GuideItem(
                    name = R.string.crafting_basics,
                    description = R.string.crafting_basics_desc,
                    //image = R.drawable.crafting_basics
                ),
                GuideItem(
                    name = R.string.crafting_refining,
                    description = R.string.crafting_refining_desc,
                    //image = R.drawable.crafting_refining
                ),
                GuideItem(
                    name = R.string.crafting_focus,
                    description = R.string.crafting_focus_desc,
                    //image = R.drawable.crafting_focus
                ),
                GuideItem(
                    name = R.string.crafting_specialization,
                    description = R.string.crafting_specialization_desc,
                    //image = R.drawable.crafting_specialization
                )
            )
        ),

        GuideItem(
            name = R.string.category_pve,
            description = R.string.category_pve_desc,
            //image = R.drawable.category_pve,
            subcategories = listOf(
                GuideItem(
                    name = R.string.pve_open_world,
                    description = R.string.pve_open_world_desc,
                    //image = R.drawable.pve_open_world
                ),
                GuideItem(
                    name = R.string.pve_solo_dungeons,
                    description = R.string.pve_solo_dungeons_desc,
                    //image = R.drawable.pve_solo_dungeons
                ),
                GuideItem(
                    name = R.string.pve_group_dungeons,
                    description = R.string.pve_group_dungeons_desc,
                    //image = R.drawable.pve_group_dungeons
                ),
                GuideItem(
                    name = R.string.pve_avalonian,
                    description = R.string.pve_avalonian_desc,
                    //image = R.drawable.pve_avalonian
                ),
                GuideItem(
                    name = R.string.pve_hellgates,
                    description = R.string.pve_hellgates_desc,
                    //image = R.drawable.pve_hellgates
                )
            )
        ),

        GuideItem(
            name = R.string.category_solo_pvp,
            description = R.string.category_solo_pvp_desc,
            //image = R.drawable.category_solo_pvp,
            subcategories = listOf(
                GuideItem(
                    name = R.string.solo_pvp_open_world,
                    description = R.string.solo_pvp_open_world_desc,
                    //image = R.drawable.solo_pvp_open_world
                ),
                GuideItem(
                    name = R.string.solo_pvp_corrupted,
                    description = R.string.solo_pvp_corrupted_desc,
                    //image = R.drawable.solo_pvp_corrupted
                ),
                GuideItem(
                    name = R.string.solo_pvp_builds,
                    description = R.string.solo_pvp_builds_desc,
                    //image = R.drawable.solo_pvp_builds
                ),
                GuideItem(
                    name = R.string.solo_pvp_tips,
                    description = R.string.solo_pvp_tips_desc,
                    //image = R.drawable.solo_pvp_tips
                )
            )
        ),

        GuideItem(
            name = R.string.category_group_pvp,
            description = R.string.category_group_pvp_desc,
            //image = R.drawable.category_group_pvp,
            subcategories = listOf(
                GuideItem(
                    name = R.string.group_pvp_small_scale,
                    description = R.string.group_pvp_small_scale_desc,
                    //image = R.drawable.group_pvp_small_scale
                ),
                GuideItem(
                    name = R.string.group_pvp_ganking,
                    description = R.string.group_pvp_ganking_desc,
                    //image = R.drawable.group_pvp_ganking
                ),
                GuideItem(
                    name = R.string.group_pvp_hellgates,
                    description = R.string.group_pvp_hellgates_desc,
                    //image = R.drawable.group_pvp_hellgates
                ),
                GuideItem(
                    name = R.string.group_pvp_builds,
                    description = R.string.group_pvp_builds_desc,
                    //image = R.drawable.group_pvp_builds
                )
            )
        ),

        GuideItem(
            name = R.string.category_camps,
            description = R.string.category_camps_desc,
            //image = R.drawable.category_camps,
            subcategories = listOf(
                GuideItem(
                    name = R.string.camps_open_world,
                    description = R.string.camps_open_world_desc,
                    //image = R.drawable.camps_open_world
                ),
                GuideItem(
                    name = R.string.camps_outposts,
                    description = R.string.camps_outposts_desc,
                    //image = R.drawable.camps_outposts
                ),
                GuideItem(
                    name = R.string.camps_objectives,
                    description = R.string.camps_objectives_desc,
                    //image = R.drawable.camps_objectives
                )
            )
        ),

        GuideItem(
            name = R.string.category_wars,
            description = R.string.category_wars_desc,
            //image = R.drawable.category_wars,
            subcategories = listOf(
                GuideItem(
                    name = R.string.wars_guild,
                    description = R.string.wars_guild_desc,
                    //image = R.drawable.wars_guild
                ),
                GuideItem(
                    name = R.string.wars_territories,
                    description = R.string.wars_territories_desc,
                    //image = R.drawable.wars_territories
                ),
                GuideItem(
                    name = R.string.wars_castles,
                    description = R.string.wars_castles_desc,
                    //image = R.drawable.wars_castles
                ),
                GuideItem(
                    name = R.string.wars_faction,
                    description = R.string.wars_faction_desc,
                    //image = R.drawable.wars_faction
                ),
                GuideItem(
                    name = R.string.wars_crystal,
                    description = R.string.wars_crystal_desc,
                    //image = R.drawable.wars_crystal
                )
            )
        ),

        GuideItem(
            name = R.string.category_economy,
            description = R.string.category_economy_desc,
            //image = R.drawable.category_economy,
            subcategories = listOf(
                GuideItem(
                    name = R.string.economy_market,
                    description = R.string.economy_market_desc,
                    //image = R.drawable.economy_market
                ),
                GuideItem(
                    name = R.string.economy_transport,
                    description = R.string.economy_transport_desc,
                    //image = R.drawable.economy_transport
                ),
                GuideItem(
                    name = R.string.economy_islands,
                    description = R.string.economy_islands_desc,
                    //image = R.drawable.economy_islands
                ),
                GuideItem(
                    name = R.string.economy_silver,
                    description = R.string.economy_silver_desc,
                    //image = R.drawable.economy_silver
                )
            )
        )
    )
}