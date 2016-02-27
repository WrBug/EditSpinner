package cn.mandroid.widget.editspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditSpinner spinner1;
    EditSpinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = (EditSpinner) findViewById(R.id.editSpinner1);
        spinner2 = (EditSpinner) findViewById(R.id.editSpinner2);
        spinner2.setRightImageResource(R.drawable.ic_expand_more_black);
        spinner2.setHint("EditSpinner");
        loadData();
    }

    private void loadData() {
        List<String> list = new ArrayList<>();
        list.add("Hello World");
        list.add("EditSpinner");
        list.add("Test");
        list.add("123456789");
        list.add("123456788");
        list.add("123456777");
        list.add("123456666");
        list.add("123455555");
        list.add("123444444");
        list.add("123333333");
        list.add("122222222");

        spinner1.setItemData(list);
        spinner2.setItemData(list);
    }
}
