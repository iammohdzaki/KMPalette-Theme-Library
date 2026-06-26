package com.zaki.dynamic.core.themes

import com.zaki.dynamic.core.themes.palettes.DeepSpacePalette
import com.zaki.dynamic.core.themes.palettes.GoldenAmberPalette
import com.zaki.dynamic.core.themes.palettes.LavenderPurplePalette
import com.zaki.dynamic.core.themes.palettes.LeafGreenPalette
import com.zaki.dynamic.core.themes.palettes.MintFreshPalette
import com.zaki.dynamic.core.themes.palettes.OceanBluePalette
import com.zaki.dynamic.core.themes.palettes.RedFlamePalette
import com.zaki.dynamic.core.themes.palettes.SunsetPinkPalette
import com.zaki.dynamic.core.themes.palettes.TreeBrownPalette

object DefaultMaterial3Themes {

    fun getFamilies() = listOf(
        TreeBrownPalette.treeBrownFamily,
        LeafGreenPalette.leafGreenFamily,
        RedFlamePalette.redFLameFamily,
        OceanBluePalette.oceanBlueFamily,
        SunsetPinkPalette.sunsetPinkFamily,
        LavenderPurplePalette.lavenderPurpleFamily,
        MintFreshPalette.mintFreshFamily,
        DeepSpacePalette.deepSpaceFamily,
        GoldenAmberPalette.goldenAmberFamily
    )

    fun getDefaults() = getFamilies().flatMap { listOf(it.light, it.dark) }
}