package com.example.controleestoque.dagger

import com.example.controleestoque.services.webservices.Requisition
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class GRModule {

    @Provides
    fun provideRetrofitRequisition() : Requisition {
        return Retrofit.Builder().baseUrl("https://5e878423781e48001676bce6.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Requisition::class.java)
    }

}