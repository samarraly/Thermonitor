package guc.edu.thermonitor;

import android.app.ListActivity;
import android.content.Intent;
import android.media.session.PlaybackState;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class List extends ListActivity {
    String [] ACTIVITES = {"Android", "iPhone", "Windows", "Blackberry" , "Linux" };
    ListView list ;
    int[] images={R.drawable.download2,R.drawable.download
            ,R.drawable.download3,R.drawable.images,R.drawable.download1};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (ListView)findViewById(android.R.id.list) ;
        customadaptor customadaptor =new customadaptor();
        list.setAdapter(customadaptor);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(List.this, DeviceDetailActivity.class);
                intent.putExtra("name",ACTIVITES[position]);
                intent.putExtra("image",images[position]);
                startActivity(intent);

            }
        });

       // ListAdapter Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ACTIVITES);
        //setListAdapter(Adapter);




       // if (!isTaskRoot()) {
        // FirebaseAuth.getInstance().signOut();


     //   }

    }



  class customadaptor extends BaseAdapter{


      @Override
      public int getCount() {
          return images.length;
      }

      @Override
      public Object getItem(int position) {
          return null;
      }

      @Override
      public long getItemId(int position) {
          return 0;
      }

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
         View view = getLayoutInflater().inflate(R.layout.customlayout,null);
         ImageView imagev= view.findViewById(R.id.imageView);
         TextView   textv= view.findViewById(R.id.textView);
         imagev.setImageResource(images[position]);
         textv.setText(ACTIVITES[position]);

          return view;
      }
        //protected void onListItemClick(ListView l, View v, int position, long id) {
          //  Intent intent = new Intent(List.this, DeviceDetailActivity.class);
          //  startActivity(intent);
       // }
  }



}
