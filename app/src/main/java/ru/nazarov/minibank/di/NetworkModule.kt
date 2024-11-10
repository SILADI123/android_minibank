package ru.nazarov.minibank.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.nazarov.minibank.data.RegistrationApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://localhost:8080")
            .build()

    @Singleton
    @Provides
    fun provideRegistrationApi(retrofit: Retrofit): RegistrationApi =
        retrofit.create(RegistrationApi::class.java)
}