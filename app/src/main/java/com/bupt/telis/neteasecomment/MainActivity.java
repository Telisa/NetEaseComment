package com.bupt.telis.neteasecomment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        SQLiteDatabase db = Connector.getDatabase();
        ListView mListView = (ListView) findViewById(R.id.list_view);
        List<Comment> list = new ArrayList<>();
        list.add(new Comment());
        list.add(new Comment());
        list.add(new Comment());
        mListView.setAdapter(new CommentListAdapter(this, list));
        //        if (user.save()) {
        //            Toast.makeText(this, "存储成功", Toast.LENGTH_SHORT).show();
        //        } else {
        //            Toast.makeText(this, "存储失败", Toast.LENGTH_SHORT).show();
        //        }
    }

    private void initData() {
        //        DBHelper helper = new DBHelper(this);
        //        SQLiteDatabase database = helper.getWritableDatabase();
        //        ContentValues values = new ContentValues();
        //        User user = new User();
        //        values.put(User.COLUMN_ID, user.getId());
        //        values.put(User.COLUMN_NAME, user.getName());
        //        values.put(User.COLUMN_LOCALE, user.getLocale());
        //        database.insert("user", null, values);
        //        Cursor query = database.query();
        User user = new User();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}