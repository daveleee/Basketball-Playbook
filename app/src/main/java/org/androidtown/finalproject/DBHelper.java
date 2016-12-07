package org.androidtown.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Toast;

/**
 * Created by LDH on 2015-06-20.
 */
public class DBHelper extends SQLiteOpenHelper {
    Context context;
    SQLiteDatabase db;
    Cursor cursor;

    // DATABASE name
    private static final String DATABASE_NAME = Environment.getExternalStorageDirectory().getPath();
    // DATABASE version
    private static final int DATABASE_VERSION = 1;
    // TABLE name
    private static final String TABLE_NAME = "player";


    // DBHelper ������(context, DB name, cursor, DB version)
    public DBHelper(Context context) {
        //�����ͺ��̽� �̸��� ���� ������ �̿��Ͽ� ���� �����ڸ� ȣ��
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    /* �����ͺ��̽� Create
       - �����ڿ��� �Ѱܹ��� �̸��� DB�� ������ DB�� �������� ���� �� �ѹ� ȣ���
       - ���ο� �����ͺ��̽��� ������ �� ���
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        /* ���̺��� �����ϱ� ���� SQL���� �ۼ��Ͽ� execSQL �� ����
           - execSQL()�޼ҵ�� SELECT ���� ������ ��� SQL���� ����
           - CREATE TABLE ���̺�� (�÷��� Ÿ�� �ɼ�);
        */
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(id TEXT PRIMARY KEY, "
                + " p_name TEXT, season TEXT, match_team TEXT, get TEXT, assist TEXT, rebound TEXT, steal TEXT, block TEXT, three_point TEXT, free_throw TEXT);");
        Toast.makeText(context, "onCreate() �޼ҵ� ȣ��", Toast.LENGTH_LONG).show();
    }

    /* �����ͺ��̽� Open
       - DB�� �� �� ȣ���
     */
    @Override
    public void onOpen(SQLiteDatabase db) {
        Toast.makeText(context, "onOpen() �޼ҵ� ȣ��", Toast.LENGTH_LONG).show();
    }

    /* �����ͺ��̽� Version Upgrade
       - DB�� ���������� ������ �ٸ��� ȣ���
       - DB�� �����ϰ�, ������ ������ �� �������� ���׷��̵� �۾� ���� ����
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "onUpgrade() �޼ҵ� ȣ��", Toast.LENGTH_LONG).show();
         /* ���̺��� ���׷��̵��ϱ� ���� SQL���� �ۼ��Ͽ� execSQL �� ����
           - DROP TABLE IF EXISTS ���̺��;
           - ���� ���̺��� ������ �� ���̺� �� ����
        */
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //���̺��� ���ڵ�(��) Insert
    public void insert(String id, String p_name, String season, String match_team, String get, String assist, String rebound, String steal, String block, String three_point, String free_throw ) {
        db = getWritableDatabase();//�����ͺ��̽��� write/read ���� open

        /* ���ڵ带 �߰��ϱ� ���� SQL���� �ۼ��Ͽ� execSQL �� ����
           - INSERT INTO  ���̺�� VALUES (�÷���, �÷���..., �÷���, �÷���...);
           - ���̺� ���ڵ带 �߰��� �� ���
        */
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES('" + id
                + "', '" + p_name + "', '" + season + "', '" + match_team + "', '" + get + "', '" + assist + "', '" + rebound + "', '" + steal + "', '" + block + "', '" + three_point + "', '" + free_throw + "');");
        db.close();//DB close
    }

    // ���̺� �ִ� ��ü ���ڵ� ����
    public Cursor CursorQuery() {
        db = getReadableDatabase();
        Toast.makeText(context, "CursorQuery() �޼ҵ� ȣ��", Toast.LENGTH_LONG).show();

        // SELECT * FROM ���̺�� null;
        cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        return cursor;
    }
}
