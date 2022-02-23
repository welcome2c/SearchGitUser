package devhoon.project.searchgituser.di

import devhoon.project.searchgituser.ui.main.MainViewModel
import org.koin.dsl.module

val viewModelModule =  module {
    single { MainViewModel(get()) }
}