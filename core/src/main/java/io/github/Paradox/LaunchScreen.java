package io.github.Paradox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

/** First screen of the application. Displayed after the application is created. */
public class LaunchScreen implements Screen {

    final Main game;

    Texture Logo;
    OrthographicCamera camera;

    public LaunchScreen(final Main game) {
        this.game = game;

        //Load imiges
        Logo = new Texture(Gdx.files.internal("logo.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render(float delta){
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "ParadoxInteractive llc", 100, 100);
        game.batch.draw(Logo, 0, 0, 300, 100);

        game.batch.end();

        if(Gdx.input.isTouched()){
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        Logo.dispose();
        game.batch.dispose();
    }

}
