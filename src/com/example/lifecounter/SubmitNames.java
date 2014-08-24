package com.example.lifecounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SubmitNames extends Activity {

	Button submitNames;
	EditText player1Name, player2Name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.submit_names);
		
		submitNames = (Button) findViewById(R.id.bSubmitPlayerNames);
		
		submitNames.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				player1Name = (EditText) findViewById(R.id.etPlayer1);
				player2Name = (EditText) findViewById(R.id.etPlayer2);
				
				Intent openMainActivity = new Intent(getApplicationContext(), MainActivity.class);
				openMainActivity.putExtra("player1Name", player1Name.getText().toString());
				openMainActivity.putExtra("player2Name", player2Name.getText().toString());
				startActivity(openMainActivity);
			}
		});
	}

	
	
}
