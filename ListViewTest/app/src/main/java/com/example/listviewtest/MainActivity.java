package com.example.listviewtest;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lv = (ListView) findViewById(R.id.cityListView);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView tv = (TextView) findViewById(R.id.textView);
        String[] citiesArray = getResources().getStringArray(R.array.cities);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("城市").setMessage("您選擇的是：" + citiesArray[i]).setCancelable(true);
        dialog.setPositiveButton("確定", null);
        dialog.setNeutralButton("取消", null);
        dialog.setNegativeButton("放棄", null);
        dialog.show();

//        Toast.makeText(
//                this,
//                "您選擇的是：" + citiesArray[i],
//                Toast.LENGTH_SHORT
//        ).show();
//        tv.setText("您選擇的是：" + citiesArray[i]);
    }
}