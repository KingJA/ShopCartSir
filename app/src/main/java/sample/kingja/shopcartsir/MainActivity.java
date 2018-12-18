package sample.kingja.shopcartsir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.lv);
        List<Item> items = new ArrayList<>();


        for (int i = 0; i < 16; i++) {
            items.add(new Item());
        }
        GoodsAdapter goodsAdapter = new GoodsAdapter(this, items);
        lv.setAdapter(goodsAdapter);
    }
}
