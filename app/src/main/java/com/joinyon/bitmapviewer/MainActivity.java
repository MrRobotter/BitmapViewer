package com.joinyon.bitmapviewer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private GridView gridView;
    private EditText etContent;
    private Button check;
    private Button clear;
    private List<String> dataList = new ArrayList<>();
    private BitmapAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        etContent = findViewById(R.id.etContent);
        check = findViewById(R.id.check);
        clear = findViewById(R.id.clear);

        check.setOnClickListener(this);
        clear.setOnClickListener(this);
        for (int i = 0; i < 64; i++) {
            dataList.add("0");
        }
        adapter = new BitmapAdapter(this, dataList);
        gridView.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.check:
                dataList.clear();
                String content = etContent.getText().toString().trim();
                if (content.length() != 16) {
                    Toast.makeText(this, "请输入正确的格式", Toast.LENGTH_SHORT).show();
                    return;
                }

                String hex = content.substring(0, 2);
                StringBuilder sb = new StringBuilder();
                if (Utils.isHexString(hex)) {
                    Integer num = Integer.parseInt(hex, 16);
                    String s = Integer.toBinaryString(num);
                    Log.e("TAG", s);
                    String ori = Utils.toEightRightPadingBrinryString(s);
                    sb.append(ori);

                } else {
                    Toast.makeText(this, "格式不正确，请检查!", Toast.LENGTH_SHORT).show();
                    return;
                }

                hex = content.substring(2, 4);
                if (Utils.isHexString(hex)) {
                    Integer num = Integer.parseInt(hex, 16);
                    String s = Integer.toBinaryString(num);
                    Log.e("TAG", s);
                    String ori = Utils.toEightRightPadingBrinryString(s);
                    sb.append(ori);

                } else {
                    Toast.makeText(this, "格式不正确，请检查!", Toast.LENGTH_SHORT).show();
                    return;
                }

                hex = content.substring(4, 6);
                if (Utils.isHexString(hex)) {
                    Integer num = Integer.parseInt(hex, 16);
                    String s = Integer.toBinaryString(num);
                    Log.e("TAG", s);
                    String ori = Utils.toEightRightPadingBrinryString(s);
                    sb.append(ori);

                } else {
                    Toast.makeText(this, "格式不正确，请检查!", Toast.LENGTH_SHORT).show();
                    return;
                }

                hex = content.substring(6, 8);
                if (Utils.isHexString(hex)) {
                    Integer num = Integer.parseInt(hex, 16);
                    String s = Integer.toBinaryString(num);
                    Log.e("TAG", s);
                    String ori = Utils.toEightRightPadingBrinryString(s);
                    sb.append(ori);

                } else {
                    Toast.makeText(this, "格式不正确，请检查!", Toast.LENGTH_SHORT).show();
                    return;
                }

                hex = content.substring(8, 10);
                if (Utils.isHexString(hex)) {
                    Integer num = Integer.parseInt(hex, 16);
                    String s = Integer.toBinaryString(num);
                    Log.e("TAG", s);
                    String ori = Utils.toEightRightPadingBrinryString(s);
                    sb.append(ori);

                } else {
                    Toast.makeText(this, "格式不正确，请检查!", Toast.LENGTH_SHORT).show();
                    return;
                }

                hex = content.substring(10, 12);
                if (Utils.isHexString(hex)) {
                    Integer num = Integer.parseInt(hex, 16);
                    String s = Integer.toBinaryString(num);
                    Log.e("TAG", s);
                    String ori = Utils.toEightRightPadingBrinryString(s);
                    sb.append(ori);

                } else {
                    Toast.makeText(this, "格式不正确，请检查!", Toast.LENGTH_SHORT).show();
                    return;
                }

                hex = content.substring(12, 14);
                if (Utils.isHexString(hex)) {
                    Integer num = Integer.parseInt(hex, 16);
                    String s = Integer.toBinaryString(num);
                    Log.e("TAG", s);
                    String ori = Utils.toEightRightPadingBrinryString(s);
                    sb.append(ori);

                } else {
                    Toast.makeText(this, "格式不正确，请检查!", Toast.LENGTH_SHORT).show();
                    return;
                }

                hex = content.substring(14, 16);
                if (Utils.isHexString(hex)) {
                    Integer num = Integer.parseInt(hex, 16);
                    String s = Integer.toBinaryString(num);
                    Log.e("TAG", s);
                    String ori = Utils.toEightRightPadingBrinryString(s);
                    sb.append(ori);

                } else {
                    Toast.makeText(this, "格式不正确，请检查!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String data = sb.toString();
                char[] stringArr = data.toCharArray();
                for (char s : stringArr) {
                    dataList.add(String.valueOf(s));
                }
                adapter.notifyDataSetChanged();
                Log.e("TAG", data);
                break;
            case R.id.clear:
                dataList.clear();
                for (int i = 0; i < 64; i++) {
                    dataList.add("0");
                }
                adapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }


    static class Utils {

        static boolean isHexString(String s) {
            String regex = "^[A-Fa-f0-9]+$";

            if (s.matches(regex)) {
                return true;

            } else {
                return false;
            }
        }

        static String toEightRightPadingBrinryString(String s) {
            String temp = "00000000" + s;
            return temp.substring(temp.length() - 8, temp.length());
        }
    }
}
