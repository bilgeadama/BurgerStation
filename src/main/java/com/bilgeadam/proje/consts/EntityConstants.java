package com.bilgeadam.proje.consts;

public class EntityConstants {

    public static final String DURUM = "durum";
    public static final short DELETED = 0;
    public static final short UNDELETED = 1;
    public static final String WHERE_CLAUSE = DURUM + " <> " + DELETED;

}
