package com.example.listviewtest1;

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

        ListView lvCities = (ListView) findViewById(R.id.listView);
        lvCities.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String[] cities = getResources().getStringArray(R.array.cities);
        TextView tvResult = (TextView) findViewById(R.id.tvResult);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("城市");
        dialog.setMessage("您選擇的是:"+ cities[i]);
        dialog.setCancelable(true);
        dialog.show();
//        Toast.makeText(this, "你點選的是" + cities[i], Toast.LENGTH_LONG).show();
//        tvResult.setText(cities[i]);
    }
}