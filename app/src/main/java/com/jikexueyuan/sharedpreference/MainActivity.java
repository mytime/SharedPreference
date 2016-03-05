package com.jikexueyuan.sharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * sharedPreference存储数据
 * 文件默认保存路径data/data/包名/shared_prefs/
 * 数据格式 key:value
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY = "MyKey" ;
    private Button btnRead;
    private Button btnWrite;
    private EditText et;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();//初始化
    }

    private void init() {
        btnRead = (Button) findViewById(R.id.btnRead);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        et = (EditText) findViewById(R.id.editText);

        btnRead.setOnClickListener(this);
        btnWrite.setOnClickListener(this);

        preferences = getPreferences(Activity.MODE_PRIVATE);
        editor = preferences.edit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRead:
                //找不到KEY -> 当前数值不存在
                String in = preferences.getString(KEY,"当前数值不存在");
                Toast.makeText(getApplicationContext(),in,Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnWrite:

                editor.putString(KEY,et.getText().toString());
                if(editor.commit()){//保存
                    Toast.makeText(getApplicationContext(),"写入成功",Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
