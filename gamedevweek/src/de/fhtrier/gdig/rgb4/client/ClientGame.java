package de.fhtrier.gdig.rgb4.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

import de.fhtrier.gdig.engine.network.NetworkComponent;
import de.fhtrier.gdig.rgb4.common.RGB4Game;
import de.fhtrier.gdig.rgb4.identifiers.Assets;
import de.fhtrier.gdig.rgb4.identifiers.Constants;
import de.fhtrier.gdig.rgb4.identifiers.GameStates;

public class ClientGame extends RGB4Game {
	public static int port = 49999;
	public static String nameOrIp = "localhost";
	public static boolean isSpectator = false;

	public ClientGame() {
		super(Assets.GameTitle);

		NetworkComponent.createClientInstance();

		while (!NetworkComponent.getInstance().connect(nameOrIp, port)) {
			try {
				Log.info("Waiting for Server");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
		}
		
		Constants.GamePlayConstants c1 = new Constants.GamePlayConstants();
		c1.showEditor("ClientSettings");		
		
		Constants.ControlConfig c2 = new Constants.ControlConfig();
		c2.showEditor("ControlConfig");
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new ClientMenuState(GameStates.MENU, container, this));
		addState(new ClientPlayingState());
	}
}
