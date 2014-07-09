package com.example.project_1;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		ButtonControler();
	}

	private void ButtonControler() {
		Button buttonTop_left = (Button) findViewById(R.id.Top_left);
		Button buttonTop_center = (Button) findViewById(R.id.Top_center);
		Button buttonTop_right = (Button) findViewById(R.id.Top_right);
		Button buttonCenter_left = (Button) findViewById(R.id.Center_left);
		Button buttonCenter_center = (Button) findViewById(R.id.Center_center);
		Button buttonCenter_right = (Button) findViewById(R.id.Center_right);
		Button buttonBottom_left = (Button) findViewById(R.id.Bottom_left);
		Button buttonBottom_center = (Button) findViewById(R.id.Bottom_center);
		Button buttonBottom_right = (Button) findViewById(R.id.Bottom_right);
		
		
		buttonTop_left.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//if blank fill in graphic
				//else do nothing
				
			}
		});
		
		buttonTop_center.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//if blank fill in graphic
				//else do nothing
				
			}
		});
		
		buttonTop_right.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//if blank fill in graphic
				//else do nothing
				
			}
		});
		
		buttonTop_left.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//if blank fill in graphic
				//else do nothing
				
			}
		});
		
		buttonTop_center.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//if blank fill in graphic
				//else do nothing
				
			}
		});
		
		buttonTop_right.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//if blank fill in graphic
				//else do nothing
				
			}
		});
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
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
