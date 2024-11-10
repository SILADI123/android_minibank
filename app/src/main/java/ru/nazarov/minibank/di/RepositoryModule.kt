package ru.nazarov.minibank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nazarov.minibank.data.RegistrationRepositoryImpl
import ru.nazarov.minibank.domain.RegistrationRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindRegistrationRepository(
        impl: RegistrationRepositoryImpl
    ): RegistrationRepository
}