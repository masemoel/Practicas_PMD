package com.masemoel.dinosaurio.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class LoadingScreen extends BaseScreen {

    private Stage stage;

    private Skin skin;

    private Label loading;

    public LoadingScreen(MainDinosaurio game) {
        super(game);

        stage = new Stage(new FitViewport(800, 480));
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        loading = new Label("Cargando...", skin);
        loading.setPosition(320 - loading.getWidth() / 2, 180 - loading.getHeight() / 2);
        stage.addActor(loading);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (game.getManager().update()) {
            game.finishLoading();
        } else {
            int progress = (int) (game.getManager().getProgress() * 100);
            loading.setText("Cargando... " + progress + "%");
        }

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}