package com.anderson.crewchat.di

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.anderson.crewchat.db.DazoneDatabase
import com.anderson.crewchat.service.DazoneNonService
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

    /**
    * Database
    * */

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

    @RequiresApi(Build.VERSION_CODES.M)
    @Singleton
    @Provides
    fun provideSharePreference(@ApplicationContext context: Context): SharedPreferences = EncryptedSharedPreferences.create(
        Constants.DAZONE_SHARE_PREF_NAME,
        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )


    /**
     * Network
     */


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
    @Retrofit1
    fun provideRetrofit(okHttpClient: OkHttpClient, mPref: SharedPreferences): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(mPref.getString(Constants.DAZONE_DB_NAME, "")?: "")
        .client(okHttpClient)
        .build()


    @Singleton
    @Provides
    @Retrofit2
    fun provideRetrofit2(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Config.NON_BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(@Retrofit1 retrofit: Retrofit): DazoneService = retrofit.create(DazoneService::class.java)

    @Singleton
    @Provides
    fun provideNonApiService(@Retrofit2 retrofit: Retrofit): DazoneNonService = retrofit.create(DazoneNonService::class.java)

}

