package com.acl.sunshine.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            String[] weatherArray = {
            	"Today - Sunny - 22",
            	"Tomorrow - Foggy - 23",
            	"Wednesday - Dark - -2",
            	"Thursday - Hazy - 123",
            	"Friday - Stay at home - 3434",
            	"Saturday - Come out again - 32",
            	"Sunday - Normal - 22"
            };
            
            List<String> weatherList = new ArrayList<String>(Arrays.asList(weatherArray));            
            
            ArrayAdapter<String> weatherAdapter = new ArrayAdapter<String>(
            		getActivity(), R.layout.list_item_forecast, 
            		R.id.list_item_forecast_textview, weatherList);
            
            ListView weatherListView = (ListView)rootView.findViewById(R.id.listview_forecast);
            
            weatherListView.setAdapter(weatherAdapter);
            
            return rootView;
        }
    }
}
