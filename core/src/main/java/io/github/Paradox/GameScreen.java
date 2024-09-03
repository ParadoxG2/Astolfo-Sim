package io.github.Paradox;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    final Main game;

    Texture AstolfoImage;
    Rectangle Astolfo;
    OrthographicCamera camera;

    public GameScreen(final Main game) {
        this.game = game;

        //load texturs for player and drop
        AstolfoImage = new Texture(Gdx.files.internal("Astolfo.png"));

        //create camra and spright batch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // Create rectangle to logicly represent the player
        Astolfo = new Rectangle();
        Astolfo.x = 800 / 2 - 64 / 2;
        Astolfo.y = 20;

        Astolfo.width = 64;
        Astolfo.height = 64;

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        // tell the camera to update its matrices.
        camera.update();

        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);

        //draw all prights
        game.batch.begin();
        game.font.draw(game.batch, "Satisfaction: ", 0, 480);
        game.batch.draw(AstolfoImage, Astolfo.x, Astolfo.y, Astolfo.width, Astolfo.height);
        game.batch.end();

        if(Gdx.input.isTouched()){
            Vector3 toutchPos = new Vector3();
            toutchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(toutchPos);
            Astolfo.x = toutchPos.x - 64 / 2;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            Astolfo.x -= 200 + Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            Astolfo.x += 200 + Gdx.graphics.getDeltaTime();
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
