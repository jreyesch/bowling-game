package com.nearsoft;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

public class BowlingGameTest {
	Game _game;

	@Before
	public void setUp() {
		_game = new Game();
	}

	@Parameters
	private void rollMany(int n, int pins){
		for (int i = 0; i < n; i++) {
			_game.roll(pins);
		}
	}
	
	@Test
	public void testGame() {
		rollMany(20,0);
		assertEquals(0, _game.score());
	}

	@Test
	public void testAllOnes() {
		rollMany(20,1);
		assertEquals(20, _game.score());
	}
	
	@Test
	public void testOneSpare(){
		rollSpare();
		_game.roll(3);
		rollMany(17,0);
		assertEquals(16, _game.score());
	}
	
	@Test
	public void testOneStrike(){
		rollStrike();
		_game.roll(3);
		_game.roll(4);
		rollMany(16, 0);
		assertEquals(24, _game.score());
	}
	
	@Test
	public void testPerfectGame(){
		rollMany(12, 10);
		assertEquals(300, _game.score());
	}
	
	@Test
	public void rollSpare(){
		_game.roll(5);
		_game.roll(5);
	}
	
	@Test
	public void rollStrike(){
		_game.roll(10);
	}
}
