package com.weronika.coffeehouse.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//*** Data access object for Account Table
@Dao
interface AccountDao {

    @Query("SELECT firstName FROM accounts WHERE email LIKE :search")
    suspend fun findFirstName(search: String): String

    @Query("SELECT lastName FROM accounts WHERE email LIKE :search")
    suspend fun findLastName(search: String): String

    @Query("SELECT email FROM accounts WHERE email LIKE :search")
    suspend fun findEmail(search: String): String

    @Query("SELECT password FROM accounts WHERE email LIKE :search")
    suspend fun findPassword(search: String): String

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(account: AccountTable)
}