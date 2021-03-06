package de.fhtrier.gdig.rgb4.common.gamelogic.player.states;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import de.fhtrier.gdig.engine.entities.Entity;
import de.fhtrier.gdig.engine.entities.gfx.AnimationEntity;
import de.fhtrier.gdig.engine.entities.gfx.AssetEntity;
import de.fhtrier.gdig.engine.management.AssetMgr;
import de.fhtrier.gdig.engine.management.Factory;
import de.fhtrier.gdig.rgb4.common.gamelogic.player.Player;

public abstract class PlayerAssetState {

	private Factory factory;
	private Player player;
	private AssetEntity gfxEntity;
	
	public PlayerAssetState(Player player, int animAssetId, String animAssetPath, int entityOrder, Factory factory) throws SlickException {

		AssetMgr assets = factory.getAssetMgr();
		this.player = player;
		this.factory = factory;
		
		// gfx
		assets.storeAnimation(animAssetId, animAssetPath);
		AnimationEntity anim = getFactory().createAnimationEntity(entityOrder, animAssetId);		
		
		anim.getData()[Entity.CENTER_X] = player.getData()[Entity.CENTER_X];
		anim.getData()[Entity.CENTER_Y] = player.getData()[Entity.CENTER_Y];
		
		anim.setVisible(true);
		setGfxEntity(anim);
	}

	public abstract void enter();

	public abstract void leave();
	
	public abstract void update();

	public Factory getFactory() {
		return factory;
	}

	public void render(Graphics g, Image frameBuffer) {
		gfxEntity.render(g, frameBuffer);
	}
	
	public AssetEntity getGfxEntity() {
		return gfxEntity;
	}
	
	public void setGfxEntity(AssetEntity gfxEntity) {
		this.gfxEntity = gfxEntity;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
