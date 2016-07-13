package com.nearsoft;

public class Game {
	private int _rolls[] = new int[21];
	private int _currentRoll = 0;

	public void roll(int pins) { // tentado a calcular el score, a pesar de que
									// no sea su funcion
		_rolls[_currentRoll++] = pins;
	}

	public int score() { // No calcula el score a pesar de que el nombre lo
							// sugiere
		int score = 0;
		int frameIndex = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(frameIndex)){ //hizo strike
				score += 10 + strikeBonus(frameIndex);
				frameIndex++;
			}
			else if(isSpare(frameIndex)) { //hizo spare
				score += 10 + spareBouns(frameIndex);
				frameIndex += 2;
			} else {
				score += sumbOfBallsInFrame(frameIndex);
				frameIndex += 2;
			}
		}
		return score;
	}
	
	private boolean isStrike(int frameIndex){
		return _rolls[frameIndex] == 10;
	}
	
	private int sumbOfBallsInFrame(int frameIndex){
		return _rolls[frameIndex] + _rolls[frameIndex + 1];
	}
	
	private boolean isSpare(int frameIndex){
		return _rolls[frameIndex] + _rolls[frameIndex + 1] == 10;
	}
	
	private int spareBouns(int frameIndex){
		 return _rolls[frameIndex + 2];
	}
	
	private int strikeBonus(int frameIndex){
		return _rolls[frameIndex+1] + _rolls[frameIndex+2];
	}
}
