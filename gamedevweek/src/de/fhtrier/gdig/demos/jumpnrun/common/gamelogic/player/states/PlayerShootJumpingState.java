package de.fhtrier.gdig.demos.jumpnrun.common.gamelogic.player.states;

import org.newdawn.slick.SlickException;

import de.fhtrier.gdig.demos.jumpnrun.common.gamelogic.player.Player;
import de.fhtrier.gdig.demos.jumpnrun.identifiers.Assets;
import de.fhtrier.gdig.demos.jumpnrun.identifiers.EntityOrder;
import de.fhtrier.gdig.engine.management.Factory;

public class PlayerShootJumpingState extends PlayerAssetState {

	public PlayerShootJumpingState(Player player, Factory factory)
			throws SlickException {
		super(player, Assets.PlayerShootJumpingAnimId,
				Assets.PlayerShootJumpingImagePath, EntityOrder.Player, factory);
	}

	@Override
	public void enter() {
	}

	@Override
	public void leave() {
	}

	@Override
	public void update() {
	}
}