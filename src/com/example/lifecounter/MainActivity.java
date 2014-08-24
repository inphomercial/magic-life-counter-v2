package com.example.lifecounter;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lifecounter.dice.Dice;
import com.example.lifecounter.player.Player;

public class MainActivity extends Activity {

	Player Player1;
	Player Player2;
	Dice   Dice;
		
	Button btnPlayerOneAddOne, btnPlayerOneMinusOne, btnPlayerOneAddFive, btnPlayerOneMinusFive;
	Button btnPlayerTwoAddOne, btnPlayerTwoMinusOne, btnPlayerTwoAddFive, btnPlayerTwoMinusFive;
	Button btnResetTotals;
	ImageButton ibDice2, ibDice20;
	TextView tvPlayerOneTotal, tvPlayerTwoTotal;
	TextView tvPlayerOneName, tvPlayerTwoName;
	TextView tvDiceResult;
	TextView playerOnePoisonTotal, playerTwoPoisonTotal;
	Button btnPlayerOnePoisonTotal, btnPlayerTwoPoisonTotal;
	
	MediaPlayer song;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // media player used for longer sound
 		song = MediaPlayer.create(MainActivity.this, R.raw.splashsound);
 		//song.start();
 		
 		// passed from the SubmitNames activity
 		Bundle extras = getIntent().getExtras();
 		String player1Name = extras.getString("player1Name");
 		String player2Name = extras.getString("player2Name");
        
        // Player one 
        Player1 			    = new Player(20, player1Name);
        btnPlayerOneAddOne      = (Button)   findViewById(R.id.btnPlayerOneAddOne);
        btnPlayerOneMinusOne    = (Button)   findViewById(R.id.btnPlayerOneMinusOne);
        btnPlayerOneAddFive     = (Button)   findViewById(R.id.btnPlayerOneAddFive);
        btnPlayerOneMinusFive   = (Button)   findViewById(R.id.btnPlayerOneMinusFive);
        tvPlayerOneName	        = (TextView) findViewById(R.id.tvPlayerOneDisplay);
        tvPlayerOneTotal        = (TextView) findViewById(R.id.tvPlayerOneTotal);
        btnPlayerOnePoisonTotal = (Button)   findViewById(R.id.btnPlayerOnePoisonTotal);
              
        // Player two
        Player2 			    = new Player(20, player2Name);
        btnPlayerTwoAddOne      = (Button)   findViewById(R.id.btnPlayerTwoAddOne);
        btnPlayerTwoMinusOne    = (Button)   findViewById(R.id.btnPlayerTwoMinusOne);
        btnPlayerTwoAddFive     = (Button)   findViewById(R.id.btnPlayerTwoAddFive);
        btnPlayerTwoMinusFive   = (Button)   findViewById(R.id.btnPlayerTwoMinusFive);
        tvPlayerTwoName         = (TextView) findViewById(R.id.tvPlayerTwoDisplay);
        tvPlayerTwoTotal        = (TextView) findViewById(R.id.tvPlayerTwoTotal);
        btnPlayerTwoPoisonTotal = (Button)   findViewById(R.id.btnPlayerTwoPoisonTotal);
              
        // Reset game
        btnResetTotals       = (Button)   findViewById(R.id.btnResetTotals);
        
        // Dice buttons
        Dice				 = new Dice();
        ibDice2				 = (ImageButton) findViewById(R.id.ibDice2); 
        ibDice20			 = (ImageButton) findViewById(R.id.ibDice20);
        tvDiceResult	     = (TextView)    findViewById(R.id.tvDice2);       
               
        // Set player names to the text fields
        tvPlayerOneName.setText(Player1.getName());
        tvPlayerTwoName.setText(Player2.getName());
        
        //playerOnePoisonTotal.setText("" + Player1.getPoisonCounter());
        //playerTwoPoisonTotal.setText("" + Player2.getPoisonCounter());
        
        
        // Button Listeners 
        btnPlayerOnePoisonTotal.setOnClickListener(new OnClickListener() 
        {	
			@Override
			public void onClick(View v)
			{
				Player1.incrementPoison(1);
				btnPlayerOnePoisonTotal.setText("" + Player1.getPoisonCounter());
			}
		});
        
        btnPlayerTwoPoisonTotal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Player2.incrementPoison(1);
				btnPlayerTwoPoisonTotal.setText("" + Player2.getPoisonCounter());
			}
		});
        
        ibDice2.setOnClickListener(new OnClickListener() 
        {		
			@Override
			public void onClick(View v) {
				Dice.rollDice(2);
				
				Log.v(INPUT_SERVICE, "Rolled a d2 with a result of :" + Dice.getResult());
				tvDiceResult.setText("" + Dice.getResult());
			}
		});
        
        ibDice20.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Dice.rollDice(20);
				
				Log.v(INPUT_SERVICE, "Rolled a d20 with a result of :" + Dice.getResult());
				tvDiceResult.setText("" + Dice.getResult());
			}
		});
        
        btnResetTotals.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{			
				Player1.reset();
				Player2.reset();
				
				Dice.reset();
				
				tvPlayerOneTotal.setText("" + Player1.getLifeCounter());
				tvPlayerTwoTotal.setText("" + Player2.getLifeCounter());
				
				btnPlayerOnePoisonTotal.setText("" + Player1.getPoisonCounter());
				btnPlayerTwoPoisonTotal.setText("" + Player2.getPoisonCounter());
				
				tvDiceResult.setText(" " + Dice.getResult());
				
				CharSequence text = "Game reset";
				int duration = Toast.LENGTH_SHORT;
				
				Toast toast = Toast.makeText(getApplicationContext(), text, duration);
				toast.setGravity(Gravity.TOP, 0, 450);
				toast.show();
				
				Log.v(INPUT_SERVICE, "Pushed resetTotals Button onClick, game reset");
			}
		});
        
        btnPlayerOneAddOne.setOnClickListener(new OnClickListener() 
        {		
			@Override
			public void onClick(View v) 
			{				
				Player1.incrementLife(1);
				tvPlayerOneTotal.setText("" + Player1.getLifeCounter());
				
				Log.v(INPUT_SERVICE, "Pushed playerOneAddOne onClick");
			}
		});
        
        btnPlayerOneMinusOne.setOnClickListener(new OnClickListener() 
        {		
			@Override
			public void onClick(View v) 
			{
				Player1.decrementLife(1);
				tvPlayerOneTotal.setText("" + Player1.getLifeCounter());	
				
				Log.v(INPUT_SERVICE, "Pushed playerOneMinusOne onClick");
			}
		});
        
        btnPlayerOneAddFive.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Player1.incrementLife(5);
				tvPlayerOneTotal.setText("" + Player1.getLifeCounter());
			}
		});
        
        btnPlayerOneMinusFive.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Player1.decrementLife(5);
				tvPlayerOneTotal.setText("" + Player1.getLifeCounter());
			}
		});
        
        btnPlayerTwoAddOne.setOnClickListener(new OnClickListener() 
        {		
			@Override
			public void onClick(View v) 
			{
				Player2.incrementLife(1);
				tvPlayerTwoTotal.setText("" + Player2.getLifeCounter());		
				
				Log.v(INPUT_SERVICE, "Pushed playerTwoAddOne onClick");
			}
		});
        
        btnPlayerTwoMinusOne.setOnClickListener(new OnClickListener() 
        {			
			@Override
			public void onClick(View v) 
			{			
			    Player2.decrementLife(1);
				tvPlayerTwoTotal.setText("" + Player2.getLifeCounter());
				
				Log.v(INPUT_SERVICE, "Pushed playerTwoMinusOne onClick");
			}
		});  
        
        btnPlayerTwoAddFive.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Player2.incrementLife(5);
				tvPlayerTwoTotal.setText("" + Player2.getLifeCounter());
			}
		});
        
        btnPlayerTwoMinusFive.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Player2.decrementLife(5);
				tvPlayerTwoTotal.setText("" + Player2.getLifeCounter());			
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
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		//song.pause();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		//song.start();
	}
	
	
    
    
    
}
;