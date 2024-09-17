package dev.joely.pokemonapi.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TokenManager {

    private static final String TOKEN_KEY = "access_token";
    private SQLiteDatabase database;

    public TokenManager(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public void saveToken(String token) {
        ContentValues values = new ContentValues();
        values.put("id", 1);
        values.put(TOKEN_KEY, token);
        database.replace("token", null, values);
    }

    public String getToken() {
        Cursor cursor = database.query("token", new String[]{TOKEN_KEY}, "id = ?", new String[]{"1"}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            String token = cursor.getString(cursor.getColumnIndex(TOKEN_KEY));
            cursor.close();
            return token;
        }
        return null;
    }

    public void clearToken() {
        database.delete("token", "id = ?", new String[]{"1"});
    }
}
