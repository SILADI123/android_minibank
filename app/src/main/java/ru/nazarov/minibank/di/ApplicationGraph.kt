package ru.nazarov.minibank.di

import dagger.Component
import ru.nazarov.minibank.MainActivity

@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
    ]
)
interface ApplicationGraph {

    fun inject(activity: MainActivity)
}