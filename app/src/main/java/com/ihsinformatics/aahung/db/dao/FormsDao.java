package com.ihsinformatics.aahung.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ihsinformatics.aahung.model.Forms;

import java.util.List;

@Dao
public interface FormsDao {

    @Query("SELECT * FROM forms")
    List<Forms> getAllForms();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveForm(Forms form);
}
