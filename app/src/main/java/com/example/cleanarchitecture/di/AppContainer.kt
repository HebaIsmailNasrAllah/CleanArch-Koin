package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.data.MobilesRepoImpl
import com.example.cleanarchitecture.data.datasource.DataSource
import com.example.cleanarchitecture.domain.IRepo
import com.example.cleanarchitecture.domain.usecases.UseCase
import com.example.cleanarchitecture.presentation.viewmodels.MobilesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val myKoinModule = module {
    factory { DataSource() }
    single <IRepo> { MobilesRepoImpl(get())} //before using angle bracket  as I kept getting NoBeanDefFoundException
    factory { UseCase(repo = get()) }
    viewModel { MobilesViewModel(get() as UseCase) }
}