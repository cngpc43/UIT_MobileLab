package com.example.lab2_ex5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private Spinner spThumbnail;
    private CheckBox cbPromotion;
    private Button btnAdd;
    private GridView gvMenu;

    private List<Dish> dishes;
    private DishAdapter dishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        spThumbnail = findViewById(R.id.sp_thumbnail);
        cbPromotion = findViewById(R.id.cb_promotion);
        btnAdd = findViewById(R.id.btn_add);
        gvMenu = findViewById(R.id.gvMenu);

        dishes = new ArrayList<>();
        dishAdapter = new DishAdapter(this, R.layout.item_dish, dishes);
        gvMenu.setAdapter(dishAdapter);

        ArrayAdapter<Thumbnail> thumbnailAdapter = new ThumbnailAdapter(this, R.layout.item_thumbnail, Arrays.asList(Thumbnail.values()));
        spThumbnail.setAdapter(thumbnailAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                Thumbnail thumbnail = (Thumbnail) spThumbnail.getSelectedItem();
                boolean isPromotion = cbPromotion.isChecked();

                Dish dish = new Dish(name, thumbnail, isPromotion);
                dishes.add(dish);
                dishAdapter.notifyDataSetChanged();
            }
        });
    }
}