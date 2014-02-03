package com.nubco.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class WebView {
	 public static void showWebSite(Activity activity, String url) {

	        Intent webIntent = new Intent( Intent.ACTION_VIEW );
	        webIntent.setData( Uri.parse(url) );
	        activity.startActivity( webIntent );
	}
}
