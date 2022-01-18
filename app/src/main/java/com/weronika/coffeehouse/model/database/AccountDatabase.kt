package com.weronika.coffeehouse.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AccountTable::class],
    version = 1, exportSchema = false)

abstract class AccountDatabase : RoomDatabase() {

    abstract fun accountDao(): AccountDao

    companion object {

        @Volatile
        private var INSTANCE: AccountDatabase? = null

        fun getDatabase(context: Context): AccountDatabase {

            //*** Hold the lock if instance is null
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AccountDatabase::class.java,
                    "account_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}