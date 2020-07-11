package br.com.danielsan.app.javafx

import kotlin.system.exitProcess
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import javafx.application.Application

abstract class CoroutineScopeApplication : Application(), CoroutineScope by MainScope() {

    final override fun stop() {
        super.stop()
        cancel()
        // If you don't use this the application will continue to run because of the use of Coroutines.
        exitProcess(0)
    }

    open fun onStop() { /* Empty body */}
}
