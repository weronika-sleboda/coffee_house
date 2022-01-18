package com.weronika.coffeehouse.model.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//*** Primary key - every entity must have one
@Entity(tableName = "accounts")
class AccountTable(
    @PrimaryKey(autoGenerate = false) val id: String,
    @ColumnInfo(name = "firstName") val firstName: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String,
)