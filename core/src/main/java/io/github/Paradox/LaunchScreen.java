package io.github.Paradox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

/** First screen of the application. Displayed after the application is created. */
public class LaunchScreen implements Screen {

    // Game Window
    final Main game;

    // Refs
    OrthographicCamera camera;
    Texture Logo;


    // Screen Setup
    public LaunchScreen(final Main game){
        this.game = game;

        //init camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.dm.width, game.dm.height);

        // init assets
        Logo = new Texture(Gdx.files.internal("logo.png"));

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);



        //camera main code
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(Logo, 0, 0, 1066,  433 );
        game.batch.end();

        game.shape.setProjectionMatrix(camera.combined);
        game.shape.begin(ShapeRenderer.ShapeType.Filled);
        game.shape.setColor(Color.CYAN);
        game.shape.rect(0, 0, game.dm.width, game.dm.height);
        game.shape.end();


    }

    @Override
    public void show() {
        // Prepare your screen here.
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}
