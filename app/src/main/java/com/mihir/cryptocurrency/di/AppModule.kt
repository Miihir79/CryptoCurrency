package com.mihir.cryptocurrency.di

import com.mihir.cryptocurrency.common.Constants.BASE_URL
import com.mihir.cryptocurrency.data.remote.CoinPaprikaAPI
import com.mihir.cryptocurrency.data.repository.CoinRepoImpl
import com.mihir.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesPaprikaApi():CoinPaprikaAPI{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaAPI):CoinRepository{
        return CoinRepoImpl(api)
    }
}