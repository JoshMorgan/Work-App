package com.nubco.app;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

public class DonateActivity extends ListActivity {

	public class ReportsActivity extends Activity {
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.donate_layout);
	    }
	}
}