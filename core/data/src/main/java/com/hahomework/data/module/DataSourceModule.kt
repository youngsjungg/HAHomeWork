package com.hahomework.data.module

import com.hahomework.data.remote.SearchRemoteDataSource
import com.hahomework.data.remote.SearchRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindSearchRemoteDataSource(searchRemoteDataSourceImpl: SearchRemoteDataSourceImpl): SearchRemoteDataSource

}