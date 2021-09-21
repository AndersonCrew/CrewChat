package com.anderson.crewchat.di

import android.content.Context
import androidx.room.Room
import com.anderson.crewchat.db.DazoneDatabase
import com.anderson.crewchat.service.DazoneService
import com.anderson.crewchat.utils.Config
import com.anderson.crewchat.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDazoneDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        DazoneDatabase::class.java,
        Constants.DAZONE_DB_NAME
    ).build()

    @Singleton
    @Provides
    fun provideUserDao(
        db: DazoneDatabase
    ) = db.userDao()


    //    Network

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Config.BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): DazoneService = retrofit.create(DazoneService::class.java)

}