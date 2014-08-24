package com.example.lifecounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.splash);
		
		Thread timer = new Thread()
		{
			public void run()
			{
				try
				{
					sleep(3000);	
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					//Intent openMainActivity = new Intent("com.example.lifecounter.MENU");
					//Intent openMainActivity = new Intent("com.example.lifecounter.MAINACTIVITY");
					//Intent openMainActivity = new Intent("com.example.lifecounter.SUBMITNAMES");
					Intent openMainActivity = new Intent(getApplicationContext(), SubmitNames.class);
					startActivity(openMainActivity);
					finish();
				}
			}
		};
		timer.start();		
	}	
}