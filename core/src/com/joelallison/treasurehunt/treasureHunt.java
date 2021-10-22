package com.joelallison.treasurehunt;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;


public class treasureHunt extends ApplicationAdapter {
	private Texture player;
	private Texture boardTile;
	private Sound digSfx;
	private Music backgroundMusic;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	public Viewport viewPort;
	private Rectangle playerRect;
	private Rectangle boardRect;

	private int boardWidth = 17;
	private int boardHeight = 11;

	private int playerX = 0;
	private int playerY = 0;



	@Override
	public void create () {
		player = new Texture(Gdx.files.internal("player.png"));
		boardTile = new Texture(Gdx.files.internal("boardTile.png"));

		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("04-over-your-head.mp3"));

		backgroundMusic.setLooping(true);
		backgroundMusic.play();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		viewPort = new FitViewport(300,180, camera);
		batch = new SpriteBatch();

		playerRect = new Rectangle();
		playerRect.x = 800 / 2 - 64 / 2;
		playerRect.y = 200;
		playerRect.width = 16;
		playerRect.height = 16;

	}

	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
	}
	@Override
	public void render () {
		ScreenUtils.clear(0.168627f, 0.474509f, 0.760784f, 1);
		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		for (int i = 1; i <= boardHeight; i++) {
			for (int j = 1; j <= boardWidth; j++) {
				batch.draw(boardTile, boardWidth*boardTile.getWidth() + (boardTile.getWidth() * i), boardTile.getHeight() * j);
			}
		}

		batch.draw(player, playerRect.x, playerRect.y);

		batch.end();

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) playerX += 150 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) playerX -= 150 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) playerY += 150 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) playerY -= 150 * Gdx.graphics.getDeltaTime();

		playerRect.x += playerX;
		playerRect.y += playerY;
		playerX = (int) (playerX * 0.6);
		playerY = (int) (playerY * 0.6);

	}

	@Override
	public void resize(int width, int height) {
		viewPort.update(width, height);
	}
}
