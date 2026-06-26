package com.zaki.dynamic.core.registry

import platform.Foundation.NSRecursiveLock

actual class PlatformLock actual constructor() {
    private val lock = NSRecursiveLock()
    actual fun lock() {
        lock.lock()
    }
    actual fun unlock() {
        lock.unlock()
    }
}
