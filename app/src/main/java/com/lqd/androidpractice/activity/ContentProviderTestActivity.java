package com.lqd.androidpractice.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lqd.androidpractice.R;
import com.lqd.androidpractice.provider.UsersProvider;

import java.io.File;

public class ContentProviderTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_test);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void onTest(View view) {
//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        //任意类型文件
//        intent.setType("*/*");
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//        startActivityForResult(intent,1);

//        //系统相册
//        Intent intent= new Intent(Intent.ACTION_PICK, null);
//        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
//        startActivityForResult(intent, REQUEST_CODE_FILE);

        try {
            File apkFile = new File("");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= 24) {
                Uri apkUri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", apkFile);
                //添加这一句表示对目标应用临时授权该Uri所代表的文件
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.setDataAndType(apkUri, "application/vnd.android.package-archive");

            } else {
                intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            }
            getApplicationContext().startActivity(intent);
        } catch (Exception e) {
            Log.d("#####", e.toString());
        }

    }

    public void onClickAddDetails(View view) {
        ContentValues values = new ContentValues();
        values.put(UsersProvider.name, ((EditText) findViewById(R.id.txtName)).getText().toString());
        getContentResolver().insert(UsersProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(), "New Record Inserted", Toast.LENGTH_LONG).show();
    }

    public void onClickShowDetails(View view) {
        // Retrieve employee records
        TextView resultView = (TextView) findViewById(R.id.res);
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.lqd.androidpractice.provider.UsersProvider/users"), null, null, null, null);
        if (cursor.moveToFirst()) {
            StringBuilder strBuild = new StringBuilder();
            while (!cursor.isAfterLast()) {
                strBuild.append("\n" + cursor.getString(cursor.getColumnIndex("id")) + "-" + cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }
            resultView.setText(strBuild);
        } else {
            resultView.setText("No Records Found");
        }
    }
}