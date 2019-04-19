package fi.tamk.jdce;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;

public class LevelSelectScreen extends NewScreen {
    private float heightUnit = getStageHeight() / 3;
    private float widthUnit = getStageWidth() / 4;
    private float levelSelectTextButtonWidth = getTextButtonHeight();
    private float levelSelectTextButtonHeight = levelSelectTextButtonWidth;
    private float textButtonX = getStageWidth() / 2 - (getTextButtonWidth() / 2);
    private float textButtonY1 = getStageHeight() / 2 - (getTextButtonHeight() / 2);
    private float textButtonY2 = getStageHeight() / 2.5f - (getTextButtonHeight() / 2);
    private ArrayList<ArrayList<TextButton>> buttonGrid;
    private int levelnumber;
    private int worldNumber;

    public LevelSelectScreen(JDCEGame g, final int worldNumber) {
        super(g);
        this.worldNumber = worldNumber;
        int posX;
        int posY;
        levelnumber = 1;
        buttonGrid = new ArrayList<ArrayList<TextButton>>();
        for(int i = 0; i<2;i++){
            buttonGrid.add(new ArrayList<TextButton>());
            for(int n=0; n<3;n++){
                posX = n + 1;
                posY = i + 1;
                buttonGrid.get(i).add( new TextButton(getGame().getBundle().get("level") + " " + levelnumber, getGame().getUiSkin()));

                buttonGrid.get(i).get(n).setWidth(levelSelectTextButtonWidth);
                buttonGrid.get(i).get(n).setHeight(levelSelectTextButtonHeight);
                buttonGrid.get(i).get(n).setPosition(widthUnit*posX, (heightUnit*posY)/*+1*/);

                getGameStage().addActor(buttonGrid.get(i).get(n));


                buttonGrid.get(i).get(n).addListener(new ClickListener() {
                    int level = levelnumber;
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        /*MyTextInputListener listener = new MyTextInputListener();
                        Gdx.input.getTextInput(listener, "What is your name?", "Name", "Write your name here");*/
                        //GameScreen gs = new GameScreen(getGame(),level, worldNumber);
                        playButtonSound();
                        getGame().setScreen(new LevelInfoScreen(getGame(), level, worldNumber));
                        //getGame().setScreen(gs);
                    }
                });

                levelnumber++;

            }
        }


        setupButtonBounds();
        setupButtons();

        getGameStage().addActor(getMuteMusicButton());
        getGameStage().addActor(getMuteSoundFxButton());
        getGameStage().addActor(getBackButton());
        Gdx.input.setInputProcessor(getGameStage());

        clickListeners();

        /*getMuteMusicButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        getMuteSoundFxButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });*/

        Gdx.input.setInputProcessor(getGameStage());
    }

    /*@Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        getPixelViewport().apply();
        getSpriteBatch().setProjectionMatrix(getMeterViewport().getCamera().combined);

        getSpriteBatch().begin();
        getSpriteBatch().draw(getBackground(), 0, 0, getPixelViewport().getWorldWidth(), getPixelViewport().getWorldHeight());
        getSpriteBatch().end();

        getGameStage().draw();
    }*/

    /*@Override
    public void resize(int width, int height) {
        getPixelViewport().update(width, height, true);
        getMeterViewport().update(width, height, true);

        setupButtonBounds();
        setupButtons();
    }*/

    public void setupButtonBounds() {
        super.setupButtonBounds();
        /*updateTenths();

        setTextButtonHeight(getGameStage().getHeight() / 6);
        setTextButtonWidth(getGameStage().getWidth() / 3);
        setImageButtonWidth(getTextButtonHeight());
        setImageButtonHeight(getTextButtonHeight());

        setBackButtonX(getStageWidthTenth() - (getImageButtonWidth() / 2));
        setBackButtonY(getStageHeightTenth() * 1 - (getImageButtonHeight() / 2));
        setMuteMusicY(getStageHeightTenth() * 9 - (getImageButtonHeight() / 2));
        setMuteSoundEffectsY(getStageHeightTenth() * 6.333f - (getImageButtonHeight() / 2));
        setMuteMusicX(getStageWidthTenth() * 9 - (getImageButtonWidth() / 2));
        setMuteSoundEffectsX(getMuteMusicX());*/

        levelSelectTextButtonHeight = getTextButtonHeight();
        levelSelectTextButtonWidth = levelSelectTextButtonHeight;

        heightUnit = getStageHeight() / 3;
        widthUnit = getStageWidth() / 4;
        textButtonX = getStageWidth() / 2 - (getTextButtonWidth() / 2);
        textButtonY1 = getStageHeight() / 2 - (getTextButtonHeight() / 2);
        textButtonY2 = getStageHeight() / 2.5f - (getTextButtonHeight() / 2);
    }

    public void setupButtons() {
        super.setupButtons();
        levelnumber = 1;
        int posX;
        int posY;

        for(int i = 0; i<2;i++){
            for(int n=0; n<3;n++){
                posX = n + 1;
                posY = i + 1;

                buttonGrid.get(i).get(n).setWidth(levelSelectTextButtonWidth);
                buttonGrid.get(i).get(n).setHeight(levelSelectTextButtonHeight);
                buttonGrid.get(i).get(n).setPosition(widthUnit*posX, (heightUnit*posY)/*+1*/);

                levelnumber++;

            }
        }

        /*getBackButton().setWidth(getImageButtonWidth());
        getBackButton().setHeight(getImageButtonHeight());
        getBackButton().setPosition(getBackButtonX(), getBackButtonY());

        getMuteMusicButton().setWidth(getImageButtonWidth());
        getMuteMusicButton().setHeight(getImageButtonHeight());
        getMuteMusicButton().setPosition(getMuteMusicX(), getMuteMusicY());

        getMuteSoundFxButton().setWidth(getImageButtonWidth());
        getMuteSoundFxButton().setHeight(getImageButtonHeight());
        getMuteSoundFxButton().setPosition(getMuteSoundEffectsX(), getMuteSoundEffectsY());*/
    }

    public float getStageWidth() {
        return getGameStage().getWidth();
    }

    public float getStageHeight() {
        return getGameStage().getHeight();
    }

    @Override
    public void clickListeners() {
        super.clickListeners();

        getBackButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getGame().setScreen(new WorldSelectScreen(getGame()));
                dispose();
            }
        });
    }
}
