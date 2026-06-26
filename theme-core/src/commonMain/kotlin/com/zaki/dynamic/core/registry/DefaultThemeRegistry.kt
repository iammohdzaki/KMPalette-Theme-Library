package com.zaki.dynamic.core.registry

import com.zaki.dynamic.core.model.ThemeDefinition
import com.zaki.dynamic.core.model.ThemeFamily
import com.zaki.dynamic.core.model.ThemeId

/**
 * Default in-memory implementation of [ThemeRegistry].
 *
 * Stores themes and families in ordered maps, preserving registration order.
 * This implementation is lightweight and suitable for most applications.
 */
internal class DefaultThemeRegistry : ThemeRegistry {
    private val lock = PlatformLock()
    private val map = LinkedHashMap<String, ThemeDefinition>()
    private val familyMap = LinkedHashMap<String, ThemeFamily>()

    override fun register(theme: ThemeDefinition) = lock.withLock {
        map[theme.id.value] = theme
    }

    override fun registerAll(themes: List<ThemeDefinition>) = lock.withLock {
        themes.forEach(::register)
    }

    override fun all(): List<ThemeDefinition> = lock.withLock {
        map.values.toList()
    }

    override fun get(id: ThemeId) = lock.withLock {
        map[id.value]
    }

    override fun registerFamily(family: ThemeFamily) = lock.withLock {
        register(family.light)
        register(family.dark)
        familyMap[family.id.value] = family
    }

    override fun registerFamily(vararg families: ThemeFamily) = lock.withLock {
        families.forEach(::registerFamily)
    }

    override fun registerFamilies(families: List<ThemeFamily>) = lock.withLock {
        families.forEach(::registerFamily)
    }

    override fun families(): List<ThemeFamily> = lock.withLock {
        familyMap.values.toList()
    }
}