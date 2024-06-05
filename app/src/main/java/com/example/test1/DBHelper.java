package com.example.test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "StudentDB";
    private static final String TABLE_NAME = "students";
    private static final String COL_ROLL_NUMBER = "RollNumber";
    private static final String COL_NAME = "Name";
    private static final String COL_MARKS = "Marks";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COL_ROLL_NUMBER + " INTEGER PRIMARY KEY," +
            COL_NAME + " TEXT," +
            COL_MARKS + " INTEGER)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(int rollNumber, String name, int marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ROLL_NUMBER, rollNumber);
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_MARKS, marks);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public boolean updateData(int rollNumber, String name, int marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_MARKS, marks);
        int result = db.update(TABLE_NAME, contentValues, COL_ROLL_NUMBER + "=?", new String[]{String.valueOf(rollNumber)});
        return result > 0;
    }

    public Integer deleteData(int rollNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_ROLL_NUMBER + "=?", new String[]{String.valueOf(rollNumber)});
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public boolean checkStudent(int rollNumber) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COL_ROLL_NUMBER};
        String selection = COL_ROLL_NUMBER + " = ?";
        String[] selectionArgs = {String.valueOf(rollNumber)};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }
}
