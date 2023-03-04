package com.masemoel.dinosaurio.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.masemoel.dinosaurio.game.entities.EntityFactory;
import com.masemoel.dinosaurio.game.entities.FloorEntity;
import com.masemoel.dinosaurio.game.entities.PlayerEntity;
import com.masemoel.dinosaurio.game.entities.CactusEntity;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends BaseScreen {

    private Stage stage;

    private World world;

    private PlayerEntity player;

    private List<FloorEntity> floorList = new ArrayList<FloorEntity>();

    private List<CactusEntity> spikeList = new ArrayList<CactusEntity>();

    private Sound jumpSound;

    private Sound dieSound;

    private Music backgroundMusic;

    private Vector3 position;

    public GameScreen(MainDinosaurio game) {
        super(game);

        stage = new Stage(new FitViewport(800, 480));
        position = new Vector3(stage.getCamera().position);

        world = new World(new Vector2(0, -10), true);
        world.setContactListener(new GameContactListener());

        jumpSound = game.getManager().get("audio/jump.ogg");
        dieSound = game.getManager().get("audio/die.ogg");
        backgroundMusic = game.getManager().get("audio/song.ogg");
    }

    @Override
    public void show() {
        EntityFactory factory = new EntityFactory(game.getManager());

        player = factory.createPlayer(world, new Vector2(1.5f, 1.5f));

        // Suelo principal
        floorList.add(factory.createFloor(world, 0, 1000, 1));

        // Elevaciones
        floorList.add(factory.createFloor(world, 15, 10, 2));
        floorList.add(factory.createFloor(world, 30, 8, 2));
        floorList.add(factory.createFloor(world, 55, 10, 2));
        floorList.add(factory.createFloor(world, 70, 8, 2));
        floorList.add(factory.createFloor(world, 105, 10, 2));
        floorList.add(factory.createFloor(world, 120, 8, 2));
        floorList.add(factory.createFloor(world, 135, 8, 2));
        floorList.add(factory.createFloor(world, 207, 37, 2));

        // Cactus
        spikeList.add(factory.createSpikes(world, 8, 1));
        spikeList.add(factory.createSpikes(world, 23, 2));
        spikeList.add(factory.createSpikes(world, 35, 2));
        spikeList.add(factory.createSpikes(world, 45, 1));
        spikeList.add(factory.createSpikes(world, 63, 2));
        spikeList.add(factory.createSpikes(world, 75, 2));
        spikeList.add(factory.createSpikes(world, 90, 1));
        spikeList.add(factory.createSpikes(world, 100, 1));
        spikeList.add(factory.createSpikes(world, 110, 2));
        spikeList.add(factory.createSpikes(world, 125, 2));
        spikeList.add(factory.createSpikes(world, 140, 2));
        spikeList.add(factory.createSpikes(world, 150, 1));
        spikeList.add(factory.createSpikes(world, 160, 1));
        spikeList.add(factory.createSpikes(world, 170, 1));
        spikeList.add(factory.createSpikes(world, 180, 1));
        spikeList.add(factory.createSpikes(world, 200, 1));
        spikeList.add(factory.createSpikes(world, 215, 2));
        spikeList.add(factory.createSpikes(world, 220, 2));
        spikeList.add(factory.createSpikes(world, 230, 2));
        spikeList.add(factory.createSpikes(world, 240, 2));
        spikeList.add(factory.createSpikes(world, 255, 1));
        spikeList.add(factory.createSpikes(world, 265, 1));
        spikeList.add(factory.createSpikes(world, 275, 1));
        spikeList.add(factory.createSpikes(world, 280, 1));
        spikeList.add(factory.createSpikes(world, 290, 1));
        spikeList.add(factory.createSpikes(world, 300, 1));
        spikeList.add(factory.createSpikes(world, 305, 1));
        spikeList.add(factory.createSpikes(world, 310, 1));
        spikeList.add(factory.createSpikes(world, 315, 1));
        spikeList.add(factory.createSpikes(world, 320, 1));
        spikeList.add(factory.createSpikes(world, 325, 1));
        spikeList.add(factory.createSpikes(world, 330, 1));
        spikeList.add(factory.createSpikes(world, 335, 1));
        spikeList.add(factory.createSpikes(world, 340, 1));
        spikeList.add(factory.createSpikes(world, 345, 1));
        spikeList.add(factory.createSpikes(world, 350, 1));
        spikeList.add(factory.createSpikes(world, 355, 1));
        spikeList.add(factory.createSpikes(world, 360, 1));
        spikeList.add(factory.createSpikes(world, 365, 1));
        spikeList.add(factory.createSpikes(world, 370, 1));
        spikeList.add(factory.createSpikes(world, 375, 1));
        spikeList.add(factory.createSpikes(world, 380, 1));
        spikeList.add(factory.createSpikes(world, 382, 1));
        spikeList.add(factory.createSpikes(world, 384, 1));

        for (FloorEntity floor : floorList)
            stage.addActor(floor);
        for (CactusEntity spike : spikeList)
            stage.addActor(spike);

        stage.addActor(player);

        stage.getCamera().position.set(position);
        stage.getCamera().update();

        backgroundMusic.setVolume(0.75f);
        backgroundMusic.play();
    }

    @Override
    public void hide() {
        stage.clear();

        player.detach();
        for (FloorEntity floor : floorList)
            floor.detach();
        for (CactusEntity spike : spikeList)
            spike.detach();

        floorList.clear();
        spikeList.clear();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();

        world.step(delta, 6, 2);

        if (player.getX() > 150 && player.isAlive()) {
            float speed = Constants.PLAYER_SPEED * delta * Constants.PIXELS_IN_METER;
            stage.getCamera().translate(speed, 0, 0);
        }

        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();

        world.dispose();
    }

    private class GameContactListener implements ContactListener {

        private boolean areCollided(Contact contact, Object userA, Object userB) {
            Object userDataA = contact.getFixtureA().getUserData();
            Object userDataB = contact.getFixtureB().getUserData();

            if (userDataA == null || userDataB == null) {
                return false;
            }

            return (userDataA.equals(userA) && userDataB.equals(userB)) ||
                    (userDataA.equals(userB) && userDataB.equals(userA));
        }

        @Override
        public void beginContact(Contact contact) {
            if (areCollided(contact, "player", "floor")) {
                player.setJumping(false);
                Constants.PLAYER_SPEED = Constants.PLAYER_SPEED + 0.05f;

                if (Gdx.input.isTouched()) {
                    player.setMustJump(true);
                }
            }

            if (areCollided(contact, "player", "spike")) {
                if (player.isAlive()) {
                    player.setAlive(false);
                    backgroundMusic.stop();
                    dieSound.play();

                    stage.addAction(
                            Actions.sequence(
                                    Actions.delay(0.8f),
                                    Actions.run(new Runnable() {

                                        @Override
                                        public void run() {
                                            game.setScreen(game.gameOverScreen);
                                            Constants.PLAYER_SPEED = 7.0f;
                                        }
                                    })
                            )
                    );
                }
            }
        }

        @Override
        public void endContact(Contact contact) {
            if (areCollided(contact, "player", "floor")) {
                if (player.isAlive()) {
                    jumpSound.play();
                }
            }
        }

        @Override public void preSolve(Contact contact, Manifold oldManifold) { }
        @Override public void postSolve(Contact contact, ContactImpulse impulse) { }
    }
}