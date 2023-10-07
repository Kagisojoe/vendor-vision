package com.example.vendorvision.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//    @Provides
//    @Singleton
//    fun provideSharedPref(app: Application): SharedPreferences {
//        return app.getSharedPreferences("prefs", Context.MODE_PRIVATE)//we are storing Token response in shared preferences
//        //there is a way to store encrypted login in details so we can automally login user if their token has expired
//    }
//}