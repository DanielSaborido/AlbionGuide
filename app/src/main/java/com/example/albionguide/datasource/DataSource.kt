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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.albionguide.R

data class GuideItem(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int = 0,
    @DrawableRes val icon: Int = R.drawable.icon_house,
    val subcategories: List<GuideItem> = emptyList(),
    @StringRes val howItWorks: Int = 0,
    @StringRes val tips: Int = 0
)

object DataSource {
    val mainCategories = listOf(
        // GATHERING
        GuideItem(
            name = R.string.category_gathering,
            description = R.string.category_gathering_desc,
            image = R.drawable.main_gather,
            icon = R.drawable.icon_gatherer,
            subcategories = listOf(
                GuideItem(
                    name = R.string.gathering_basics,
                    description = R.string.gathering_basics_desc,
                    image = R.drawable.gath_basics,
                    howItWorks = R.string.gathering_basics_how,
                    tips = R.string.gathering_basics_tips
                ),
                GuideItem(
                    name = R.string.gathering_tips,
                    description = R.string.gathering_tips_desc,
                    howItWorks = R.string.gathering_tips_how,
                    tips = R.string.gathering_tips_tips
                ),
                GuideItem(
                    name = R.string.gathering_specialization,
                    description = R.string.gathering_specialization_desc,
                    image = R.drawable.gath_specialitation,
                    howItWorks = R.string.gathering_specialization_how,
                    tips = R.string.gathering_specialization_tips
                ),
                GuideItem(
                    name = R.string.gathering_danger_zones,
                    description = R.string.gathering_danger_zones_desc,
                    image = R.drawable.gath_black,
                    howItWorks = R.string.gathering_danger_zones_how,
                    tips = R.string.gathering_danger_zones_tips
                )
            )
        ),

        // CRAFTING AND REFINING
        GuideItem(
            name = R.string.category_crafting,
            description = R.string.category_crafting_desc,
            image = R.drawable.craft_basics,
            icon = R.drawable.icon_craftsman,
            subcategories = listOf(
                GuideItem(
                    name = R.string.crafting_basics,
                    description = R.string.crafting_basics_desc,
                    image = R.drawable.craft_basics,
                    howItWorks = R.string.crafting_basics_how,
                    tips = R.string.crafting_basics_tips
                ),
                GuideItem(
                    name = R.string.crafting_refining,
                    description = R.string.crafting_refining_desc,
                    image = R.drawable.craft_refining,
                    howItWorks = R.string.crafting_refining_how,
                    tips = R.string.crafting_refining_tips
                ),
                GuideItem(
                    name = R.string.crafting_focus,
                    description = R.string.crafting_focus_desc,
                    image = R.drawable.craft_focus,
                    howItWorks = R.string.crafting_focus_how,
                    tips = R.string.crafting_focus_tips
                ),
                GuideItem(
                    name = R.string.crafting_specialization,
                    description = R.string.crafting_specialization_desc,
                    image = R.drawable.craft_specialitation,
                    howItWorks = R.string.crafting_specialization_how,
                    tips = R.string.crafting_specialization_tips
                )
            )
        ),

        // PVE AND MOBS
        GuideItem(
            name = R.string.category_pve,
            description = R.string.category_pve_desc,
            image = R.drawable.main_pve,
            icon = R.drawable.icon_fighter,
            subcategories = listOf(
                GuideItem(
                    name = R.string.pve_open_world,
                    description = R.string.pve_open_world_desc,
                    image = R.drawable.pve_open,
                    howItWorks = R.string.pve_open_world_how,
                    tips = R.string.pve_open_world_tips
                ),
                GuideItem(
                    name = R.string.pve_solo_dungeons,
                    description = R.string.pve_solo_dungeons_desc,
                    image = R.drawable.pve_solo,
                    howItWorks = R.string.pve_solo_dungeons_how,
                    tips = R.string.pve_solo_dungeons_tips
                ),
                GuideItem(
                    name = R.string.pve_group_dungeons,
                    description = R.string.pve_group_dungeons_desc,
                    image = R.drawable.pve_group,
                    howItWorks = R.string.pve_group_dungeons_how,
                    tips = R.string.pve_group_dungeons_tips
                ),
                GuideItem(
                    name = R.string.pve_avalonian,
                    description = R.string.pve_avalonian_desc,
                    image = R.drawable.pve_avalonian,
                    howItWorks = R.string.pve_avalonian_how,
                    tips = R.string.pve_avalonian_tips
                ),
                GuideItem(
                    name = R.string.pve_hellgates,
                    description = R.string.pve_hellgates_desc,
                    image = R.drawable.pve_hell,
                    howItWorks = R.string.pve_hellgates_how,
                    tips = R.string.pve_hellgates_tips
                )
            )
        ),

        // SOLO PVP
        GuideItem(
            name = R.string.category_solo_pvp,
            description = R.string.category_solo_pvp_desc,
            image = R.drawable.main_pvp,
            icon = R.drawable.icon_player_one,
            subcategories = listOf(
                GuideItem(
                    name = R.string.solo_pvp_open_world,
                    description = R.string.solo_pvp_open_world_desc,
                    image = R.drawable.solo_pvp,
                    howItWorks = R.string.solo_pvp_open_world_how,
                    tips = R.string.solo_pvp_open_world_tips
                ),
                GuideItem(
                    name = R.string.solo_pvp_corrupted,
                    description = R.string.solo_pvp_corrupted_desc,
                    image = R.drawable.solo_corrup,
                    howItWorks = R.string.solo_pvp_corrupted_how,
                    tips = R.string.solo_pvp_corrupted_tips
                ),
                GuideItem(
                    name = R.string.solo_pvp_builds,
                    description = R.string.solo_pvp_builds_desc,
                    image = R.drawable.solo_build,
                    howItWorks = R.string.solo_pvp_builds_how,
                    tips = R.string.solo_pvp_builds_tips
                ),
                GuideItem(
                    name = R.string.solo_pvp_tips,
                    description = R.string.solo_pvp_tips_desc,
                    howItWorks = R.string.solo_pvp_tips_how,
                    tips = R.string.solo_pvp_tips_tips
                )
            )
        ),

        // GROUP PVP
        GuideItem(
            name = R.string.category_group_pvp,
            description = R.string.category_group_pvp_desc,
            image = R.drawable.main_group,
            icon = R.drawable.icon_player_three,
            subcategories = listOf(
                GuideItem(
                    name = R.string.group_pvp_small_scale,
                    description = R.string.group_pvp_small_scale_desc,
                    image = R.drawable.group_small,
                    howItWorks = R.string.group_pvp_small_scale_how,
                    tips = R.string.group_pvp_small_scale_tips
                ),
                GuideItem(
                    name = R.string.group_pvp_ganking,
                    description = R.string.group_pvp_ganking_desc,
                    image = R.drawable.group_gank,
                    howItWorks = R.string.group_pvp_ganking_how,
                    tips = R.string.group_pvp_ganking_tips
                ),
                GuideItem(
                    name = R.string.group_pvp_hellgates,
                    description = R.string.group_pvp_hellgates_desc,
                    image = R.drawable.group_hell,
                    howItWorks = R.string.group_pvp_hellgates_how,
                    tips = R.string.group_pvp_hellgates_tips
                ),
                GuideItem(
                    name = R.string.group_pvp_builds,
                    description = R.string.group_pvp_builds_desc,
                    image = R.drawable.group_builds,
                    howItWorks = R.string.group_pvp_builds_how,
                    tips = R.string.group_pvp_builds_tips
                )
            )
        ),

        // CAMPS AND OUTPOSTS
        GuideItem(
            name = R.string.category_camps,
            description = R.string.category_camps_desc,
            image = R.drawable.main_outpost,
            icon = R.drawable.icon_tracking,
            subcategories = listOf(
                GuideItem(
                    name = R.string.camps_open_world,
                    description = R.string.camps_open_world_desc,
                    image = R.drawable.camp_open,
                    howItWorks = R.string.camps_open_world_how,
                    tips = R.string.camps_open_world_tips
                ),
                GuideItem(
                    name = R.string.camps_outposts,
                    description = R.string.camps_outposts_desc,
                    image = R.drawable.camp_outpost,
                    howItWorks = R.string.camps_outposts_how,
                    tips = R.string.camps_outposts_tips
                ),
                GuideItem(
                    name = R.string.camps_objectives,
                    description = R.string.camps_objectives_desc,
                    image = R.drawable.camp_objetives,
                    howItWorks = R.string.camps_objectives_how,
                    tips = R.string.camps_objectives_tips
                )
            )
        ),

        // WARS AND TERRITORY
        GuideItem(
            name = R.string.category_wars,
            description = R.string.category_wars_desc,
            image = R.drawable.main_war,
            icon = R.drawable.icon_surrender,
            subcategories = listOf(
                GuideItem(
                    name = R.string.wars_guild,
                    description = R.string.wars_guild_desc,
                    image = R.drawable.war_guild,
                    howItWorks = R.string.wars_guild_how,
                    tips = R.string.wars_guild_tips
                ),
                GuideItem(
                    name = R.string.wars_territories,
                    description = R.string.wars_territories_desc,
                    image = R.drawable.war_territories,
                    howItWorks = R.string.wars_territories_how,
                    tips = R.string.wars_territories_tips
                ),
                GuideItem(
                    name = R.string.wars_castles,
                    description = R.string.wars_castles_desc,
                    image = R.drawable.war_castle,
                    howItWorks = R.string.wars_castles_how,
                    tips = R.string.wars_castles_tips
                ),
                GuideItem(
                    name = R.string.wars_faction,
                    description = R.string.wars_faction_desc,
                    image = R.drawable.war_faction,
                    howItWorks = R.string.wars_faction_how,
                    tips = R.string.wars_faction_tips
                ),
                GuideItem(
                    name = R.string.wars_crystal,
                    description = R.string.wars_crystal_desc,
                    image = R.drawable.war_arena,
                    howItWorks = R.string.wars_crystal_how,
                    tips = R.string.wars_crystal_tips
                )
            )
        ),

        // ECONOMY AND TRADING
        GuideItem(
            name = R.string.category_economy,
            description = R.string.category_economy_desc,
            image = R.drawable.main_market,
            icon = R.drawable.icon_money,
            subcategories = listOf(
                GuideItem(
                    name = R.string.economy_market,
                    description = R.string.economy_market_desc,
                    image = R.drawable.eco_market,
                    howItWorks = R.string.economy_market_how,
                    tips = R.string.economy_market_tips
                ),
                GuideItem(
                    name = R.string.economy_transport,
                    description = R.string.economy_transport_desc,
                    image = R.drawable.eco_transport,
                    howItWorks = R.string.economy_transport_how,
                    tips = R.string.economy_transport_tips
                ),
                GuideItem(
                    name = R.string.economy_islands,
                    description = R.string.economy_islands_desc,
                    image = R.drawable.eco_island,
                    howItWorks = R.string.economy_islands_how,
                    tips = R.string.economy_islands_tips
                ),
                GuideItem(
                    name = R.string.economy_silver,
                    description = R.string.economy_silver_desc,
                    howItWorks = R.string.economy_silver_how,
                    tips = R.string.economy_silver_tips
                )
            )
        )
    )
}