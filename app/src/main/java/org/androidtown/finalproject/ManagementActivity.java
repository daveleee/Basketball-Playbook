package org.androidtown.finalproject;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class ManagementActivity extends ActionBarActivity {

    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private Cursor cursor;
    private TextView status;
    String dbName, tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        status=(TextView)findViewById(R.id.status);
        ListView list=(ListView)findViewById(R.id.list);

        createDatabase("player.db");
       // createTable("PLAYER");



//        insertDB("PLAYER", 1, "Yang Dong geon", "14-15", "54", "11.76", "4.9", "2.8", "1.8", "0.1", "31.7%", "85.4%");
//        insertDB("PLAYER", 2, "Ham Ji Hun", "14-15", "54", "7.3", "3.8", "4.3", "1.0", "0.4", "30.6%", "65.4%");
//        insertDB("PLAYER", 3, "Kim Ju Sung", "14-15", "7", "2.14", "0.7", "0.6", "0", "0", "0%", "99.9%");
//        insertDB("PLAYER", 4, "Moon Tae Young", "14-15", "50", "16.92", "2.3", "6.3", "1.2", "0.5", "23.4%", "70.3%");
//        insertDB("PLAYER", 5, "Ricardo Ratliffe", "14-15", "54", "20.11", "1.7", "10", "0.7", "1.7", "0%", "71.1%");
//        insertDB("PLAYER", 6, "Ira Clark", "14-15", "51", "5.69", "0.5", "4", "0.5", "0.5", "19.4%", "66.4%");
//        insertDB("PLAYER", 7, "Park Jong Chun", "14-15", "30", "2.97", "1.1", "0.3", "0.1", "1.3", "24.6%", "50.4%");
//        insertDB("PLAYER", 8, "Kim Jong Geun", "14-15", "36", "1.08", "0.8", "0.6", "0.1", "0.0", "28.6%", "50%");
//        insertDB("PLAYER", 9, "Bae Soo Yong", "14-15", "21", "1.7", "0.3", "1.0", "0.0", "0.0", "99.9%", "99.9%");


          Cursor cursor=CursorQuery("PLAYER");
        startManagingCursor(cursor);
        DBAdapter dbAdapter=new DBAdapter(this, cursor);
        list.setAdapter(dbAdapter);



//        Toast.makeText(getApplicationContext(), cursor.getColumnCount(),Toast.LENGTH_LONG).show();
    }



    private void createDatabase(String dbName) {
        println(" Database : " + dbName);

        //데이터베이스 저장 경로(SD카드 경로) + 데이터베이스 이름
        String databaseName = "/sdcard/SQLiteDB/" + dbName;

        try {
            // 데이터베이스 생성(or 오픈)-(DB 이름, mode, CursorFactory) -- [코드 작성]

            db=openOrCreateDatabase(databaseName, Activity.MODE_PRIVATE, null);
            println("Database is opened.");
        }catch (Exception e) {
            e.printStackTrace();
            println("Database is not created.");
        }
    }

//    //테이블 생성
//    private void createTable(String tableName) {
//        println("Creating table : " + tableName);
//        try {
//            if (db != null) {
//                //  execSQL() 메소드를 이용하여 테이블 생성 -- [코드 작성]
//
//                db.execSQL("CREATE TABLE " + tableName + "(_id integer PRIMARY KEY autoincrement, "
//                        + " p_name TEXT, season TEXT, match_team TEXT, get TEXT, assist TEXT, rebound TEXT, steal TEXT, block TEXT, three_point TEXT, free_throw TEXT);");
//
//                println("Table is created.");
//
//            } else {
//                println("Database is not created.");
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//            println("Table is not created.");
//        }
//    }

    private void insertDB(String tableName, int _id,  String p_name, String season, String match_team, String get, String assist, String rebound, String steal, String block, String three_point, String free_throw) {
        try {
            if (db != null) {
                //  execSQL() 메소드를 이용하여 테이블 생성 -- [코드 작성]

                db.execSQL("INSERT INTO " + tableName + " VALUES( '" + _id + "', '" + p_name + "', '" + season + "', '" + match_team + "', '" + get + "', '" + assist + "', '" + rebound + "', '" + steal + "', '" + block + "', '" + three_point + "', '" + free_throw + "');");

                println("Table value is created.");

            } else {
                println("Database is not created.");
            }
        }catch (Exception e) {
            e.printStackTrace();
            println("Table value is not created.");
        }
    }
    public Cursor CursorQuery(String tableName) {

        // SELECT * FROM 테이블명 null;
        cursor = db.rawQuery("SELECT * FROM " + tableName, null);

        return cursor;
    }

    private void println(String msg)
    {
        Log.d("e", msg);
        status.append("\n" +msg);
    }

}