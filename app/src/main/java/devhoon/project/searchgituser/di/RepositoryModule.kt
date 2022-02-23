package devhoon.project.searchgituser.di

import devhoon.project.searchgituser.data.repository.SearchUserRepository
import devhoon.project.searchgituser.data.repository.SearchUserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<SearchUserRepository> { SearchUserRepositoryImpl(get()) }
}