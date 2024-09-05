package io.github.Paradox;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
   public SpriteBatch batch;
    public BitmapFont font;
    public Skin Launchskin;
    public Graphics.DisplayMode dm;
    public ShapeRenderer shape;

    public void create() {
        dm = Gdx.graphics.getDisplayMode();
        Gdx.graphics.setWindowedMode(dm.width, dm.height);
        batch = new SpriteBatch(); // Spright Batch main
        font = new BitmapFont(); // use libGDX's default Arial font
        Launchskin = new Skin();
        this.setScreen(new LaunchScreen(this));

    }

    public void render() {
        super.render(); // important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
