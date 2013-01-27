package com.ago.guitartrainer.db;

import com.ago.guitartrainer.lessons.custom.QuestionScalegridDegree2Position;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    private static final Class<?>[] classes = new Class[] { QuestionScalegridDegree2Position.class, };

    public static void main(String[] args) throws Exception {
        writeConfigFile("ormlite_config.txt", classes);
    }
}