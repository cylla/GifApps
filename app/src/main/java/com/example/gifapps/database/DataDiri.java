package com.example.gifapps.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity(tableName = "datadiri_db")
    public class DataDiri {

        @NonNull
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        private int id;

        @ColumnInfo(name = "name")
        private String name;

        @ColumnInfo(name = "email")
        private String email;

        @ColumnInfo(name = "alamat")
        private String alamat;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

    }

