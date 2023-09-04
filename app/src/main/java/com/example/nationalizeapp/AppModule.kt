package com.example.nationalizeapp

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi) =
        Retrofit.Builder().baseUrl("https://api.nationalize.io").addConverterFactory(
            MoshiConverterFactory.create(moshi),
        ).build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit) = retrofit.create(NationaliseService::class.java)

    @Provides
    @Singleton
    fun provideRepository(service: NationaliseService) = NationaliseRepository(service)
}
