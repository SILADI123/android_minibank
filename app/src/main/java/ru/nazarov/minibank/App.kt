package ru.nazarov.minibank

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ru.nazarov.minibank.di.ApplicationGraph
import ru.nazarov.minibank.di.DaggerApplicationGraph

@HiltAndroidApp
class App: Application() {
    val applicationGraph: ApplicationGraph = DaggerApplicationGraph.create()
}