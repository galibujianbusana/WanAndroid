package com.example.helper.db.helper;

import android.content.Context;
import android.os.Environment;

import com.example.helper.db.utils.LogUtil;

import org.w3c.dom.Document;

import java.io.File;

public class PathUtil {

    public static String getSDCardPath(Context context) {
        String path= context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
            LogUtil.d("this is path init file no! ");
        }
        LogUtil.d("this is path ->" + path);
        return path;
    }
}
