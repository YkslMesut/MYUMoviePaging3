package com.myu.myumoviepagin3.di

import androidx.transition.Visibility.Mode
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.myu.myumoviepagin3.data.remote.MovieService
import com.myu.myumoviepagin3.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Named("BASE_URL")
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Named("API_KEY")
    fun provideApiKey() = Constants.API_KEY

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, @Named("BASE_URL") BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)


}