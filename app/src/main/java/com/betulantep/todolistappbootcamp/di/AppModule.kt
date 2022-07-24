package com.betulantep.todolistappbootcamp.di

import android.content.Context
import androidx.room.Room
import com.betulantep.todolistappbootcamp.data.repo.ToDoDaoRepository
import com.betulantep.todolistappbootcamp.room.Database
import com.betulantep.todolistappbootcamp.room.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDoDaoRepository(tododao:ToDoDao): ToDoDaoRepository {
        return ToDoDaoRepository(tododao)
    }

    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context: Context): ToDoDao {
        val db = Room.databaseBuilder(context, Database::class.java, "todolist.sqlite")
            .createFromAsset("todolist.sqlite").build()
        return db.getToDoDao()
    }
}