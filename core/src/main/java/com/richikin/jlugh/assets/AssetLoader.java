package com.richikin.jlugh.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.richikin.jlugh.logging.Trace;

public abstract class AssetLoader implements Assets {
    //
    // Texture Atlas names.
    private static String _BUTTONS_ATLAS;
    private static String _ANIMATIONS_ATLAS;
    private static String _OBJECTS_ATLAS;
    private static String _TEXT_ATLAS;
    private static String _ACHIEVEMENTS_ATLAS;

    public AssetManager assetManager;

    public AssetLoader() {
        validate();
    }

    private void validate() {
        if (_BUTTONS_ATLAS.isBlank() || _BUTTONS_ATLAS == null
                || _ACHIEVEMENTS_ATLAS.isBlank() || _ACHIEVEMENTS_ATLAS == null
                || _ANIMATIONS_ATLAS.isBlank() || _ANIMATIONS_ATLAS == null
                || _OBJECTS_ATLAS.isBlank() || _OBJECTS_ATLAS == null
                || _TEXT_ATLAS.isBlank() || _TEXT_ATLAS == null) {
            throw new NullPointerException("ATLAS NAME definitions are incomplete!");
        }
    }

    /**
     * Loads the TextureAtlases that will be
     * used for animations/object/buttons etc.
     */
    @Override
    public void initialise() {
        this.assetManager = new AssetManager();

        try {
            loadAtlas(_BUTTONS_ATLAS);
            loadAtlas(_ANIMATIONS_ATLAS);
            loadAtlas(_TEXT_ATLAS);
            loadAtlas(_OBJECTS_ATLAS);
            loadAtlas(_ACHIEVEMENTS_ATLAS);
        } catch (Exception _exception) {
            Trace.checkPoint();
            Trace.dbg("WARNING: ATLASES NEED BUILDING!");
        }
    }

    /**
     * Use the AssetManager to find and return the specified
     * region from the Buttons Atlas.
     *
     * @param name The name of the required region
     * @return A TextureRegion holding requested Region
     */
    @Override
    public TextureRegion getButtonRegion(final String name) {
        return assetManager.get(_BUTTONS_ATLAS, TextureAtlas.class).findRegion(name);
    }

    /**
     * Use the AssetManager to find and return the specified
     * region from the Animations Atlas.
     *
     * @param name The name of the required region
     * @return A TextureRegion holding requested Region
     */
    @Override
    public TextureRegion getAnimationRegion(final String name) {
        return assetManager.get(_ANIMATIONS_ATLAS, TextureAtlas.class).findRegion(name);
    }

    /**
     * Use the AssetManager to find and return the specified
     * region from the Objects Atlas.
     *
     * @param name The name of the required region
     * @return A TextureRegion holding requested Region
     */
    @Override
    public TextureRegion getObjectRegion(final String name) {
        return assetManager.get(_OBJECTS_ATLAS, TextureAtlas.class).findRegion(name);
    }

    /**
     * Use the AssetManager to find and return the specified
     * region from the Text Atlas.
     *
     * @param name The name of the required region
     * @return A TextureRegion holding requested Region
     */
    @Override
    public TextureRegion getTextRegion(final String name) {
        return assetManager.get(_TEXT_ATLAS, TextureAtlas.class).findRegion(name);
    }

    /**
     * Use the AssetManager to find and return the specified
     * region from the Achievements Atlas.
     *
     * @param name The name of the required region
     * @return A TextureRegion holding requested Region
     */
    @Override
    public TextureRegion getAchievementRegion(final String name) {
        return assetManager.get(_ACHIEVEMENTS_ATLAS, TextureAtlas.class).findRegion(name);
    }

    @Override
    public AssetManager getAssetManager() {
        return assetManager;
    }

    @Override
    public TextureAtlas getButtonsLoader() {
        return assetManager.get(_BUTTONS_ATLAS, TextureAtlas.class);
    }

    @Override
    public TextureAtlas getAnimationsLoader() {
        return assetManager.get(_ANIMATIONS_ATLAS, TextureAtlas.class);
    }

    @Override
    public TextureAtlas getObjectsLoader() {
        return assetManager.get(_OBJECTS_ATLAS, TextureAtlas.class);
    }

    @Override
    public TextureAtlas getTextsLoader() {
        return assetManager.get(_TEXT_ATLAS, TextureAtlas.class);
    }

    @Override
    public TextureAtlas getAchievementsLoader() {
        return assetManager.get(_ACHIEVEMENTS_ATLAS, TextureAtlas.class);
    }

    /**
     * Load single asset, and ensures that it is loaded.
     * It then returns an object of the specified type.
     *
     * @param <T>   the type parameter
     * @param asset the asset to load
     * @param type  the class type of the asset to load
     * @return an object of the specified type
     */
    @Override
    public <T> T loadSingleAsset(String asset, Class<?> type) {
        if (!assetManager.isLoaded(asset, type)) {
            assetManager.load(asset, type);
            assetManager.finishLoadingAsset(asset);
        }

        return assetManager.get(asset);
    }

    /**
     * Load TextureAtlas asset.
     *
     * @param atlasName the full name of the specified atlas.
     */
    @Override
    public void loadAtlas(String atlasName) {
        loadSingleAsset(atlasName, TextureAtlas.class);
    }

    /**
     * Unload the specified object
     *
     * @param asset the filename of the object to unload
     */
    @Override
    public void unloadAsset(String asset) {
        if (assetManager.isLoaded(asset)) {
            assetManager.unload(asset);
        }
    }

    @Override
    public abstract String getSkinFilename();

    @Override
    public abstract String getDevPanelFont();

    @Override
    public abstract String getDevPanelBackground();

    @Override
    public void dispose() {
        Trace.checkPoint();

        assetManager.dispose();
        assetManager = null;
    }
}
