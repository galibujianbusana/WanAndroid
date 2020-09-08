package com.example.helper.db.helper;

import android.content.Context;
import android.os.Environment;

public class PathUtil {

    public static String getSDCardPath(Context context) {
        String path= context.getFilesDir().getAbsolutePath();
        return path;
    }
}
