package guc.edu.thermonitor;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class List extends ListActivity {
    String [] ACTIVITES = {"Android", "iPhone", "Windows", "Bluckberry" , "Linux" };
    ListView list ;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (ListView)findViewById(android.R.id.list) ;

        ListAdapter Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ACTIVITES);
        setListAdapter(Adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(List.this, DeviceDetailActivity.class);
        startActivity(intent);
    }
}
