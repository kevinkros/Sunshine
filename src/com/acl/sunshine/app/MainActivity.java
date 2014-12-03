package com.acl.sunshine.app;

import com.acl.sunshine.app.ForecastFragment.FetchWeatherTask;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends Activity {
	private final String LOG_TAG = MainActivity.class.getSimpleName();
	

	
	
	
	
	
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }
        Log.d(LOG_TAG, "SUNSHINECreate");
    }

	
	

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "SUNSHINEStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
        Log.d(LOG_TAG, "SUNSHINEResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        Log.d(LOG_TAG, "SUNSHINEPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
        Log.d(LOG_TAG, "SUNSHINEStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        Log.d(LOG_TAG, "SUNSHINEDestroy");
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
        	startActivity(new Intent(this, SettingsActivity.class));
	    	return true;
        }
        
        if (id == R.id.action_showlocationonmap) {
    		openPreferredLocationInMap();
	    	return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private void openPreferredLocationInMap() {
    	String location = PreferenceManager.getDefaultSharedPreferences(this)
				.getString(getString(R.string.pref_location_key), 
				getString(R.string.pref_location_default));

       	Uri builtLocUri = Uri.parse("geo:0,0?q="+location);
    	Intent intent = new Intent(Intent.ACTION_VIEW);
    	intent.setData(builtLocUri);
    	
    	if (intent.resolveActivity(getPackageManager()) != null) {
    	    startActivity(intent);
    	} else {
    		Log.d(LOG_TAG, "Couldn't call " + location +".");
    	}
    }
}
