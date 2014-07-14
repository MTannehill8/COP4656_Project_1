package com.example.project_1;


import java.util.Random;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity { 
	public static final int TOP_LEFT   = 0;//1
	public static final int TOP_CENTER = 1;//6
	public static final int TOP_RIGHT  = 2;//5
	public static final int CTR_LEFT   = 3;//8
	public static final int CTR_CENTER = 4;//4  
	public static final int CTR_RIGHT  = 5;//0
	public static final int BTM_LEFT   = 6;//3
	public static final int BTM_CENTER = 7;//2
	public static final int BTM_RIGHT  = 8;//7
	final int EMPTY     = 0;
	final int GATOR     = 1;
	final int NOLE      = 4;
	final int P1_WINNER = 3;
	final int P2_WINNER = 12; 
	final int CAT       = 21;
	final int NO_MOVE   = 10;
	int p1Score   = 0;
	int p2Score   = 0;
	int tieScore  = 0;
	
	int winner = 0; 
	int players = 1;
	boolean gamePlaying = false;
	boolean startOver = true;
	
	static int gameBoard[] = {0,0,0,0,0,0,0,0,0};
	static boolean square_empty[] = {true,true,true,true,true,true,true,true,true};
	boolean player_1 = true;
	
	@Override
	public void onBackPressed() {
	} 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setCustomTitleBar();
		ButtonControler();
	}	
	
	@SuppressLint("NewApi")
	private void setCustomTitleBar() {
		getActionBar().setTitle(Html.fromHtml("<font face =\"Arial\" color=\"#540000\">" + "TIC TAC TOE "));
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#CDC092")));//"#CDC092"
		
	}

	private void ButtonControler() {
		
		//Top Left Square
		final Button btnTop_left = (Button) findViewById(R.id.btnTop_left);
		btnTop_left.setOnClickListener(new View.OnClickListener() {
			
			@Override 
			public void onClick(View v){
				if(square_empty[TOP_LEFT]){	
					if(player_1){
						btnTop_left.setBackgroundResource(R.drawable.gator);		//set picture to Gator								
						gameBoard[TOP_LEFT] = GATOR;								//assign the square as a Gator
					}else{//player 2
						btnTop_left.setBackgroundResource(R.drawable.nole);			//set the graphic to Nole
						gameBoard[TOP_LEFT] = NOLE;									//assign the square as a Nole
					}
					btnTop_left.setEnabled(false);									//disable square
					square_empty[TOP_LEFT] = false;									//false empty square
					if(winner()){														//check for a winner
						DeclareWinner();												//declare winner		
						EndGame();														//deactivate game board
					}else{
						NextTurn();														//next turn
					}
				}		
			}
		});	 
		
		//Top Center Square
		final Button btnTop_center = (Button) findViewById(R.id.btnTop_center);
		btnTop_center.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				if(square_empty[TOP_CENTER]){	
					if(player_1){
						btnTop_center.setBackgroundResource(R.drawable.gator);		//set picture to Gator
						gameBoard[TOP_CENTER] = GATOR;								//assign the square as a Gator
					}else{//player 2
						btnTop_center.setBackgroundResource(R.drawable.nole);		//set the graphic to Nole					
						gameBoard[TOP_CENTER] = NOLE;								//assign the square as a Nole
					}
					btnTop_center.setEnabled(false);								//disable square
					square_empty[TOP_CENTER] = false;								//false empty square
					if(winner()){														//check for a winner
						DeclareWinner();												//declare winner		
						EndGame();														//deactivate game board																			
					}else{
						NextTurn();														//next turn
					}
				}			
			}
		});	
		
		//Top Right Square
		final Button btnTop_right = (Button) findViewById(R.id.btnTop_right);
		btnTop_right.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				if(square_empty[TOP_RIGHT]){	
					if(player_1){
						btnTop_right.setBackgroundResource(R.drawable.gator);		//set picture to Gator
						gameBoard[TOP_RIGHT] = GATOR;								//assign the square as a Gator
					}else{//player 2
						btnTop_right.setBackgroundResource(R.drawable.nole);		//set the graphic to Nole
						gameBoard[TOP_RIGHT] = NOLE;								//assign the square as a Nole
					}
					btnTop_right.setEnabled(false);									//disable square
					square_empty[TOP_RIGHT] = false;								//false empty square
					if(winner()){														//check for a winner
						DeclareWinner();												//declare winner		
						EndGame();														//deactivate game board																			
					}else{
						NextTurn();														//next turn
					}
				}			
			}
		});	
		
		//Center Left Square
		final Button btnCenter_left = (Button) findViewById(R.id.btnCenter_left);
		btnCenter_left.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				if(square_empty[CTR_LEFT]){	
					if(player_1){
						btnCenter_left.setBackgroundResource(R.drawable.gator);		//set picture to Gator
						gameBoard[CTR_LEFT] = GATOR;								//assign the square as a Gator
					}else{//player 2
						btnCenter_left.setBackgroundResource(R.drawable.nole);		//set the graphic to Nole
						gameBoard[CTR_LEFT] = NOLE;									//assign the square as a Nole
					}
					btnCenter_left.setEnabled(false);								//disable square
					square_empty[CTR_LEFT] = false;									//false empty square
					if(winner()){														//check for a winner
						DeclareWinner();												//declare winner		
						EndGame();														//deactivate game board																				
					}else{
						NextTurn();														//next turn
					}
				}			
			}
		});

		//Center Center Square 
		final Button btnCenter_center = (Button) findViewById(R.id.btnCenter_center);
		btnCenter_center.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				if(square_empty[CTR_CENTER]){	
					if(player_1){
						btnCenter_center.setBackgroundResource(R.drawable.gator);	//set picture to Gator
						gameBoard[CTR_CENTER] = GATOR;								//assign the square as a Gator
					}else{//player 2
						btnCenter_center.setBackgroundResource(R.drawable.nole);	//set the graphic to Nole
						gameBoard[CTR_CENTER] = NOLE;								//assign the square as a Nole
					}
					btnCenter_center.setEnabled(false);								//disable square
					square_empty[CTR_CENTER] = false;								//false empty square
					if(winner()){														//check for a winner
						DeclareWinner();												//declare winner		
						EndGame();														//deactivate game board																			
					}else{
						NextTurn();														//next turn
					}
				}				
			}
		});	
		
		//Center Right Square
		final Button btnCenter_right = (Button) findViewById(R.id.btnCenter_right);
		btnCenter_right.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				if(square_empty[CTR_RIGHT]){	
					if(player_1){
						btnCenter_right.setBackgroundResource(R.drawable.gator);	//set picture to Gator
						btnCenter_right.setEnabled(false);							//disable the square
						gameBoard[CTR_RIGHT] = GATOR;								//assign the square as a Gator
					}else{//player 2
						btnCenter_right.setBackgroundResource(R.drawable.nole);		//set the graphic to Nole
						btnCenter_right.setEnabled(false);							//disable the square
						gameBoard[CTR_RIGHT] = NOLE;								//assign the square as a Nole
					}
					btnCenter_right.setEnabled(false);								//disable square
					square_empty[CTR_RIGHT] = false;								//false empty square
					if(winner()){														//check for a winner
						DeclareWinner();												//declare winner		
						EndGame();														//deactivate game board																			
					}else{
						NextTurn();														//next turn
					}
				}			
			}
		});	
		
		//Bottom Left Square
		final Button btnBottom_left = (Button) findViewById(R.id.btnBottom_left);
		btnBottom_left.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				if(square_empty[BTM_LEFT]){	
					if(player_1){
						btnBottom_left.setBackgroundResource(R.drawable.gator);		//set picture to Gator
						gameBoard[BTM_LEFT] = GATOR;								//assign the square as a Gator
					}else{//player 2
						btnBottom_left.setBackgroundResource(R.drawable.nole);		//set the graphic to Nole
						gameBoard[BTM_LEFT] = NOLE;									//assign the square as a Nole
					}
					btnBottom_left.setEnabled(false);								//disable square
					square_empty[BTM_LEFT] = false;									//false empty square
					if(winner()){														//check for a winner
						DeclareWinner();												//declare winner		
						EndGame();														//deactivate game board																			
					}else{
						NextTurn();														//next turn
					}
				}					
			}
		});	
	
		//Bottom Center Square
		final Button btnBottom_center = (Button) findViewById(R.id.btnBottom_center);
		btnBottom_center.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				if(square_empty[BTM_CENTER]){	
					if(player_1){
						btnBottom_center.setBackgroundResource(R.drawable.gator);	//set picture to Gator
						gameBoard[BTM_CENTER] = GATOR;								//assign the square as a Gator
					}else{//player 2
						btnBottom_center.setBackgroundResource(R.drawable.nole);	//set the graphic to Nole
						gameBoard[BTM_CENTER] = NOLE;								//assign the square as a Nole
					} 
					btnBottom_center.setEnabled(false);								//disable square
					square_empty[BTM_CENTER] = false;								//false empty square
					if(winner()){														//check for a winner
						DeclareWinner();												//declare winner		
						EndGame();														//deactivate game board																			
					}else{
						NextTurn();														//next turn
					}
				}				
			} 
		});
		
		//Bottom Center Square
		final Button btnBottom_right = (Button) findViewById(R.id.btnBottom_right);
		btnBottom_right.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				Log.i("TEST","bottom right clicked");
				Log.i("TEST",String.valueOf(player_1));
				Log.i("TEST",String.valueOf(square_empty[BTM_RIGHT]));
				if(square_empty[BTM_RIGHT]){	
					if(player_1){
						btnBottom_right.setBackgroundResource(R.drawable.gator);	//set picture to Gator
						gameBoard[BTM_RIGHT] = GATOR;								//assign the square as a Gator
					}else{//player 2
						Log.i("TEST","BR player 2");
						btnBottom_right.setBackgroundResource(R.drawable.nole);		//set the graphic to Nole
						gameBoard[BTM_RIGHT] = NOLE;								//assign the square as a Nole
					}
					btnBottom_right.setEnabled(false);								//disable square
					square_empty[BTM_RIGHT] = false;								//false empty square
					if(winner()){														//check for a winner
						DeclareWinner();												//declare winner		
						EndGame();														//deactivate game board																			
					}else{
						NextTurn();														//next turn
					}
				}					
			}
		});
		
		//Reset Button
		final Button btnResetScore = (Button) findViewById(R.id.btnResetScore);
		btnResetScore.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				TextView tvP1Score = (TextView) findViewById(R.id.tvP1Score);
				TextView tvP2SCore = (TextView) findViewById(R.id.tvP2Score);
				TextView tvTieScore = (TextView) findViewById(R.id.tvTieScore);
				//update new scores
				tieScore = 0;				
				tvTieScore.setText(String.valueOf(tieScore));
			
				p1Score = 0;				
				tvP1Score.setText(String.valueOf(p1Score));
							
				p2Score = 0;				
				tvP2SCore.setText(String.valueOf(p2Score));				
			}		
			
		});
		//Play Game Button
		final Button btnPlayGame = (Button) findViewById(R.id.btnPlayNewGame);
		btnPlayGame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				if(gamePlaying){ //if game in progress ask to start over
					StartOver();
				}else{
					ResetBoard();//reset game board
					StartGame();//start game
					StartMusic();//play a funky beat
				}
			}		
			
		});
		
		//One Player
		final Button btnOnePlayer = (Button) findViewById(R.id.btnOnePlayer);
		final Button btnTwoPlayer = (Button) findViewById(R.id.btnTwoPlayer);
		btnOnePlayer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){			
			btnOnePlayer.setVisibility(View.INVISIBLE);			
			btnTwoPlayer.setVisibility(View.VISIBLE);
			players = 1;
			if(!player_1){
				AndroidTurn();
			}
			}
		});
		
		//Two Player
		btnTwoPlayer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){			
			btnOnePlayer.setVisibility(View.VISIBLE);				
			btnTwoPlayer.setVisibility(View.INVISIBLE);
			
			players = 2;
			}
		});
	}

	//restart game
	private void StartOver() {
		
		new AlertDialog.Builder(this)
	    .setTitle("Game in progress")
	    .setMessage("Are you sure you want to start a new game?")
	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	Log.i("TEST","resetting game");
	        	ResetBoard();//reset game board
				StartGame();//start game
				StartMusic();
	        }
	     })
	    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            //do nothing
	        }
	     })
	    .setIcon(android.R.drawable.ic_dialog_alert)
	     .show();
		
	}

	//start game 
	private void StartGame() {
		TextView tvStatus = (TextView) findViewById(R.id.tvStatus);
		
		tvStatus.setText("Gator's turn");
		player_1=true;
		gamePlaying = true;
		winner = 0;
	}  

	//reset the game board for new game
	@SuppressLint("NewApi")
	private void ResetBoard() {
		Button btnBottom_left   = (Button) findViewById(R.id.btnBottom_left);
		Button btnBottom_center = (Button) findViewById(R.id.btnBottom_center);
		Button btnBottom_right  = (Button) findViewById(R.id.btnBottom_right);
		Button btnTop_left      = (Button) findViewById(R.id.btnTop_left);
		Button btnTop_center    = (Button) findViewById(R.id.btnTop_center);
		Button btnTop_right     = (Button) findViewById(R.id.btnTop_right);
		Button btnCenter_left   = (Button) findViewById(R.id.btnCenter_left);
		Button btnCenter_center = (Button) findViewById(R.id.btnCenter_center);
		Button btnCenter_right  = (Button) findViewById(R.id.btnCenter_right);
		
		btnBottom_left.setEnabled(true);
		btnBottom_left.setVisibility(View.VISIBLE);
		btnBottom_left.setBackground(null);
		
		btnBottom_center.setEnabled(true);
		btnBottom_center.setVisibility(View.VISIBLE);
		btnBottom_center.setBackground(null);
		
		btnBottom_right.setEnabled(true);
		btnBottom_right.setVisibility(View.VISIBLE);
		btnBottom_right.setBackground(null);
		
		btnTop_left.setEnabled(true);
		btnTop_left.setVisibility(View.VISIBLE);
		btnTop_left.setBackground(null);
		
		btnTop_center.setEnabled(true);
		btnTop_center.setVisibility(View.VISIBLE);
		btnTop_center.setBackground(null);
		
		btnTop_right.setEnabled(true);
		btnTop_right.setVisibility(View.VISIBLE);
		btnTop_right.setBackground(null);
		
		btnCenter_left.setEnabled(true);
		btnCenter_left.setVisibility(View.VISIBLE);
		btnCenter_left.setBackground(null);
		
		btnCenter_center.setEnabled(true);
		btnCenter_center.setVisibility(View.VISIBLE);
		btnCenter_center.setBackground(null);
		
		btnCenter_right.setEnabled(true);
		btnCenter_right.setVisibility(View.VISIBLE);
		btnCenter_right.setBackground(null);
		
		for(int i = 0;i<9;i++){
			gameBoard[i]=0;
			square_empty[i]= true;
		}
	}

	//Give control to next player
	private void NextTurn() {
		TextView tvStatus = (TextView) findViewById(R.id.tvStatus);
		
			if(player_1){
				player_1 = false;
				if(players == 1){ 
					tvStatus.setText("Android Nole's turn");
					Log.i("TEST","Android turn");
					AndroidTurn();
				}else{
					tvStatus.setText("Nole's turn");
				}
				
			}else{
				player_1 = true;
				tvStatus.setText("Gator's turn");
			}
		}
	
	//AI logic for Android turn
	@SuppressLint("NewApi")
	private void AndroidTurn() {
		Button btnBottom_left   = (Button) findViewById(R.id.btnBottom_left);
		Button btnBottom_center = (Button) findViewById(R.id.btnBottom_center);
		Button btnBottom_right  = (Button) findViewById(R.id.btnBottom_right);
		Button btnTop_left      = (Button) findViewById(R.id.btnTop_left);
		Button btnTop_center    = (Button) findViewById(R.id.btnTop_center);
		Button btnTop_right     = (Button) findViewById(R.id.btnTop_right);
		Button btnCenter_left   = (Button) findViewById(R.id.btnCenter_left);
		Button btnCenter_center = (Button) findViewById(R.id.btnCenter_center);
		Button btnCenter_right  = (Button) findViewById(R.id.btnCenter_right);
		int move = NO_MOVE;
		
		move = Win_Move();			//check for win
		
		if(move == NO_MOVE){ 		//if can not win 
			move = Block_Move();	//check for block
		}
		if(move == NO_MOVE){		//no win or block then just move
			move = Rand_Move();		//random empty block
		}
		
		switch(move){
			case 0:
				Log.i("TEST","Call On Click 0");
				btnTop_left.callOnClick();
				break;
			case 1:
				Log.i("TEST","Call On Click 1");
				btnTop_center.callOnClick();
				break;
			case 2:
				Log.i("TEST","Call On Click 2");
				btnTop_right.callOnClick();
				break;
			case 3:
				Log.i("TEST","Call On Click 3");
				btnCenter_left.callOnClick();
				break;
			case 4:
				Log.i("TEST","Call On Click 4");
				btnCenter_center.callOnClick();
				break;
			case 5:
				Log.i("TEST","Call On Click 5");
				btnCenter_right.callOnClick();
				break;
			case 6:
				Log.i("TEST","Call On Click 6");
				btnBottom_left.callOnClick();
				break;
			case 7:
				Log.i("TEST","Call On Click 7");
				btnBottom_center.callOnClick();
				break;
			case 8:
				Log.i("TEST","Call On Click 8");
				btnBottom_right.callOnClick();
				break;
		}
	}
 
	//Android will randomly select an empty square
	private int Rand_Move() {
		Random r = new Random();
		int move = NO_MOVE;
		do{
			move = r.nextInt(9);
		}while(square_empty[move] == false);
		return move;
	}

	//have Android block opponent from winning
	private int Block_Move() {
		final int POSSIBLE_BLOCK = 2;
		int move = NO_MOVE;
		
		if((      gameBoard[TOP_LEFT]   + gameBoard[TOP_CENTER] + gameBoard[TOP_RIGHT])  == POSSIBLE_BLOCK){
			if(gameBoard[TOP_LEFT] == EMPTY){
				move = TOP_LEFT;
			}else if (gameBoard[TOP_CENTER] == EMPTY){
				move = TOP_CENTER;
			}else if (gameBoard[TOP_RIGHT] == EMPTY){
				move = TOP_RIGHT;
			}
		}else if((gameBoard[CTR_LEFT]   + gameBoard[CTR_CENTER] + gameBoard[CTR_RIGHT])  == POSSIBLE_BLOCK){
			if(gameBoard[CTR_LEFT] == EMPTY){
				move = CTR_LEFT;
			}else if (gameBoard[CTR_CENTER] == EMPTY){
				move = CTR_CENTER;
			}else if (gameBoard[CTR_RIGHT] == EMPTY){
				move = CTR_RIGHT;
			}
		}else if((gameBoard[BTM_LEFT]   + gameBoard[BTM_CENTER] + gameBoard[BTM_RIGHT])  == POSSIBLE_BLOCK){
			if(gameBoard[BTM_LEFT] == EMPTY){
				move = BTM_LEFT;
			}else if (gameBoard[BTM_CENTER] == EMPTY){
				move = BTM_CENTER;
			}else if (gameBoard[BTM_RIGHT] == EMPTY){
				move = BTM_RIGHT;
			}
		}else if((gameBoard[TOP_LEFT]   + gameBoard[CTR_LEFT]   + gameBoard[BTM_LEFT])   == POSSIBLE_BLOCK){
			if(gameBoard[TOP_LEFT] == EMPTY){
				move = TOP_LEFT;
			}else if (gameBoard[CTR_LEFT] == EMPTY){
				move = CTR_LEFT;
			}else if (gameBoard[BTM_LEFT] == EMPTY){
				move = BTM_LEFT;
			}
		}else if((gameBoard[TOP_CENTER] + gameBoard[CTR_CENTER] + gameBoard[BTM_CENTER]) == POSSIBLE_BLOCK){
			if(gameBoard[TOP_CENTER] == EMPTY){
				move = TOP_CENTER;
			}else if (gameBoard[CTR_CENTER] == EMPTY){
				move = CTR_CENTER;
			}else if (gameBoard[BTM_CENTER] == EMPTY){
				move = BTM_CENTER;
			}			
		}else if((gameBoard[TOP_RIGHT]  + gameBoard[CTR_RIGHT]  + gameBoard[BTM_RIGHT])  == POSSIBLE_BLOCK){
			if(gameBoard[TOP_RIGHT] == EMPTY){
				move = TOP_RIGHT;
			}else if (gameBoard[CTR_RIGHT] == EMPTY){
				move = CTR_RIGHT;
			}else if (gameBoard[BTM_RIGHT] == EMPTY){
				move = BTM_RIGHT;
			}
		}else if((gameBoard[TOP_LEFT]   + gameBoard[CTR_CENTER] + gameBoard[BTM_RIGHT])  == POSSIBLE_BLOCK){
			if(gameBoard[TOP_LEFT] == EMPTY){
				move = TOP_LEFT;
			}else if (gameBoard[CTR_CENTER] == EMPTY){
				move = CTR_CENTER;
			}else if (gameBoard[BTM_RIGHT] == EMPTY){
				move = BTM_RIGHT;
			}
		}else if((gameBoard[TOP_RIGHT]  + gameBoard[CTR_CENTER] + gameBoard[BTM_LEFT])   == POSSIBLE_BLOCK){
			if(gameBoard[TOP_RIGHT] == EMPTY){
				move = TOP_RIGHT;
			}else if (gameBoard[CTR_CENTER] == EMPTY){
				move = CTR_CENTER;
			}else if (gameBoard[BTM_LEFT] == EMPTY){
				move = BTM_LEFT;
			}
		}
		return move;
	}

	//Have Android win if possible
	private int Win_Move() {
		final int POSSIBLE_WIN = 8;
		int move = NO_MOVE;
		if((      gameBoard[TOP_LEFT]   + gameBoard[TOP_CENTER] + gameBoard[TOP_RIGHT])  == POSSIBLE_WIN){
			if(gameBoard[TOP_LEFT] == EMPTY){
				move = TOP_LEFT;
			}else if (gameBoard[TOP_CENTER] == EMPTY){
				move = TOP_CENTER;
			}else if (gameBoard[TOP_RIGHT] == EMPTY){
				move = TOP_RIGHT;
			}
		}else if((gameBoard[CTR_LEFT]   + gameBoard[CTR_CENTER] + gameBoard[CTR_RIGHT])  == POSSIBLE_WIN){
			if(gameBoard[CTR_LEFT] == EMPTY){
				move = CTR_LEFT;
			}else if (gameBoard[CTR_CENTER] == EMPTY){
				move = CTR_CENTER;
			}else if (gameBoard[CTR_RIGHT] == EMPTY){
				move = CTR_RIGHT;
			}
		}else if((gameBoard[BTM_LEFT]   + gameBoard[BTM_CENTER] + gameBoard[BTM_RIGHT])  == POSSIBLE_WIN){
			if(gameBoard[BTM_LEFT] == EMPTY){
				move = BTM_LEFT;
			}else if (gameBoard[BTM_CENTER] == EMPTY){
				move = BTM_CENTER;
			}else if (gameBoard[BTM_RIGHT] == EMPTY){
				move = BTM_RIGHT;
			}
		}else if((gameBoard[TOP_LEFT]   + gameBoard[CTR_LEFT]   + gameBoard[BTM_LEFT])   == POSSIBLE_WIN){
			if(gameBoard[TOP_LEFT] == EMPTY){
				move = TOP_LEFT;
			}else if (gameBoard[CTR_LEFT] == EMPTY){
				move = CTR_LEFT;
			}else if (gameBoard[BTM_LEFT] == EMPTY){
				move = BTM_LEFT;
			}
		}else if((gameBoard[TOP_CENTER] + gameBoard[CTR_CENTER] + gameBoard[BTM_CENTER]) == POSSIBLE_WIN){
			if(gameBoard[TOP_CENTER] == EMPTY){
				move = TOP_CENTER;
			}else if (gameBoard[CTR_CENTER] == EMPTY){
				move = CTR_CENTER;
			}else if (gameBoard[BTM_CENTER] == EMPTY){
				move = BTM_CENTER;
			}
		}else if((gameBoard[TOP_RIGHT]  + gameBoard[CTR_RIGHT]  + gameBoard[BTM_RIGHT])  == POSSIBLE_WIN){
			if(gameBoard[TOP_RIGHT] == EMPTY){
				move = TOP_RIGHT;
			}else if (gameBoard[CTR_RIGHT] == EMPTY){
				move = CTR_RIGHT;
			}else if (gameBoard[BTM_RIGHT] == EMPTY){
				move = BTM_RIGHT;
			}
		}else if((gameBoard[TOP_LEFT]   + gameBoard[CTR_CENTER] + gameBoard[BTM_RIGHT])  == POSSIBLE_WIN){
			if(gameBoard[TOP_LEFT] == EMPTY){
				move = TOP_LEFT;
			}else if (gameBoard[CTR_CENTER] == EMPTY){
				move = CTR_CENTER;
			}else if (gameBoard[BTM_RIGHT] == EMPTY){
				move = BTM_RIGHT;
			}
		}else if((gameBoard[TOP_RIGHT]  + gameBoard[CTR_CENTER] + gameBoard[BTM_LEFT])   == POSSIBLE_WIN){
			if(gameBoard[TOP_RIGHT] == EMPTY){
				move = TOP_RIGHT;
			}else if (gameBoard[CTR_CENTER] == EMPTY){
				move = CTR_CENTER;
			}else if (gameBoard[BTM_LEFT] == EMPTY){
				move = BTM_LEFT;
			}
		}
		return move;
	}

	//Updates game board and variables for game over status
	private void EndGame() {
		Button btnBottom_left   = (Button) findViewById(R.id.btnBottom_left);
		Button btnBottom_center = (Button) findViewById(R.id.btnBottom_center);
		Button btnBottom_right  = (Button) findViewById(R.id.btnBottom_right);
		Button btnTop_left      = (Button) findViewById(R.id.btnTop_left);
		Button btnTop_center    = (Button) findViewById(R.id.btnTop_center);
		Button btnTop_right     = (Button) findViewById(R.id.btnTop_right);
		Button btnCenter_left   = (Button) findViewById(R.id.btnCenter_left);
		Button btnCenter_center = (Button) findViewById(R.id.btnCenter_center);
		Button btnCenter_right  = (Button) findViewById(R.id.btnCenter_right);
		
		btnBottom_left.setEnabled(false);
		btnBottom_center.setEnabled(false);
		btnBottom_right.setEnabled(false);
		btnTop_left.setEnabled(false);
		btnTop_center.setEnabled(false);
		btnTop_right.setEnabled(false);
		btnCenter_left.setEnabled(false);
		btnCenter_center.setEnabled(false);
		btnCenter_right.setEnabled(false);
		gamePlaying = false;
		
		StopMusic();
	} 

	//start background music
	private void StartMusic() {
		
		//audio in the next version
		
	}
	
	//stops background music
	private void StopMusic() {
		
		//audio in the next version		
	}

	//Declares who the winner is and updates score
	private void DeclareWinner(){
		TextView tvStatus = (TextView) findViewById(R.id.tvStatus);
		TextView tvP1Score = (TextView) findViewById(R.id.tvP1Score);
		TextView tvP2SCore = (TextView) findViewById(R.id.tvP2Score);
		TextView tvTieScore = (TextView) findViewById(R.id.tvTieScore);
		switch(winner){
			case CAT:
				tieScore = tieScore + 1;
				tvStatus.setText("Tie Cat Wins!");
				tvTieScore.setText(String.valueOf(tieScore));
				break;
			case P1_WINNER:
				p1Score = p1Score + 1;
				tvStatus.setText("Player 1 Wins!");
				tvP1Score.setText(String.valueOf(p1Score));
				break;
			case P2_WINNER:
				p2Score = p2Score + 1;
				tvStatus.setText("Player 2 Wins!");
				tvP2SCore.setText(String.valueOf(p2Score));
				break;
		}
	}

	//calculate if there is a winner and return true if there is
	private boolean winner() {
		
		if((      gameBoard[TOP_LEFT]   + gameBoard[TOP_CENTER] + gameBoard[TOP_RIGHT])  == P1_WINNER){
			//player 1 winner
			winner = P1_WINNER;
		}else if((gameBoard[CTR_LEFT]   + gameBoard[CTR_CENTER] + gameBoard[CTR_RIGHT])  == P1_WINNER){
			//player 1 winner
			winner = P1_WINNER;
		}else if((gameBoard[BTM_LEFT]   + gameBoard[BTM_CENTER] + gameBoard[BTM_RIGHT])  == P1_WINNER){
			//player 1 winner
			winner = P1_WINNER;
		}else if((gameBoard[TOP_LEFT]   + gameBoard[CTR_LEFT]   + gameBoard[BTM_LEFT])   == P1_WINNER){
			//player 1 winner
			winner = P1_WINNER;
		}else if((gameBoard[TOP_CENTER] + gameBoard[CTR_CENTER] + gameBoard[BTM_CENTER]) == P1_WINNER){
			//player 1 winner
			winner = P1_WINNER;
		}else if((gameBoard[TOP_RIGHT]  + gameBoard[CTR_RIGHT]  + gameBoard[BTM_RIGHT])  == P1_WINNER){
			//player 1 winner
			winner = P1_WINNER;
		}else if((gameBoard[TOP_LEFT]   + gameBoard[CTR_CENTER] + gameBoard[BTM_RIGHT])  == P1_WINNER){
			//player 1 winner
			winner = P1_WINNER;
		}else if((gameBoard[TOP_RIGHT]  + gameBoard[CTR_CENTER] + gameBoard[BTM_LEFT])   == P1_WINNER){
			//player 1 winner
			winner = P1_WINNER;
		}else if((gameBoard[TOP_LEFT]   + gameBoard[TOP_CENTER] + gameBoard[TOP_RIGHT])  == P2_WINNER){
			//player 2 winner
			winner = P2_WINNER;
		}else if((gameBoard[CTR_LEFT]   + gameBoard[CTR_CENTER] + gameBoard[CTR_RIGHT])  == P2_WINNER){
			//player 2 winner
			winner = P2_WINNER;
		}else if((gameBoard[BTM_LEFT]   + gameBoard[BTM_CENTER] + gameBoard[BTM_RIGHT])  == P2_WINNER){
			//player 2 winner
			winner = P2_WINNER;
		}else if((gameBoard[TOP_LEFT]   + gameBoard[CTR_LEFT]   + gameBoard[BTM_LEFT])   == P2_WINNER){
			//player 2 winner
			winner = P2_WINNER;
		}else if((gameBoard[TOP_CENTER] + gameBoard[CTR_CENTER] + gameBoard[BTM_CENTER]) == P2_WINNER){
			//player 2 winner
			winner = P2_WINNER;
		}else if((gameBoard[TOP_RIGHT]  + gameBoard[CTR_RIGHT]  + gameBoard[BTM_RIGHT])  == P2_WINNER){
			//player 2 winner
			winner = P2_WINNER;
		}else if((gameBoard[TOP_LEFT]   + gameBoard[CTR_CENTER] + gameBoard[BTM_RIGHT])  == P2_WINNER){
			//player 2 winner
			winner = P2_WINNER;
		}else if((gameBoard[TOP_RIGHT]  + gameBoard[CTR_CENTER] + gameBoard[BTM_LEFT])   == P2_WINNER){
			//player 2 winner
			winner = P2_WINNER;
		}else if(gameBoard[TOP_LEFT]   + gameBoard[TOP_CENTER] + gameBoard[TOP_RIGHT] + 
				 gameBoard[CTR_LEFT]   + gameBoard[CTR_CENTER] + gameBoard[CTR_RIGHT] +
				 gameBoard[BTM_LEFT]   + gameBoard[BTM_CENTER] + gameBoard[BTM_RIGHT] == CAT){
			//cat winner player_1 goes first
			winner = CAT;
		}else if(gameBoard[TOP_LEFT]   + gameBoard[TOP_CENTER] + gameBoard[TOP_RIGHT] + 
				 gameBoard[CTR_LEFT]   + gameBoard[CTR_CENTER] + gameBoard[CTR_RIGHT] +
				 gameBoard[BTM_LEFT]   + gameBoard[BTM_CENTER] + gameBoard[BTM_RIGHT] == (CAT + 3)){
			//cat winner player_2 goes first
			winner = CAT;
		} 
		
		if(winner > 0){
			return true;//there is a winner
		}else{
			return false;//still no winner yet
		}	
	}//winner()
}

