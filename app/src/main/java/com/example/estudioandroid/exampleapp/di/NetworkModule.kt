package com.example.estudioandroid.exampleapp.di

import com.example.estudioandroid.exampleapp.application.AppConstant
import com.example.estudioandroid.exampleapp.data.remote.WebService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(AppConstant.BASE_URL).addConverterFactory(
            GsonConverterFactory.create(GsonBuilder().create())
        ).build()


    @Singleton
    @Provides
    fun provideWebService(retrofit: Retrofit): WebService = retrofit.create(WebService::class.java)

}