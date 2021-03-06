package de.fhtrier.gdig.rgb4.server;

import java.net.InterfaceAddress;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import de.fhtrier.gdig.engine.network.NetworkComponent;
import de.fhtrier.gdig.engine.network.impl.NetworkLobby;
import de.fhtrier.gdig.rgb4.common.RGB4Game;
import de.fhtrier.gdig.rgb4.identifiers.Assets;
import de.fhtrier.gdig.rgb4.identifiers.Constants;

public class ServerGame extends RGB4Game {
	public static int port = 49999;
	public static InterfaceAddress networkInterface = null;

	public ServerGame() {
		super(Assets.GameTitle + " (Server)");
		
	   if ( networkInterface == null )
	   {
	      NetworkLobby lobby = new NetworkLobby();
	      List<InterfaceAddress> networkInterfaces = lobby.getInterfaces();
	      
	      if ( networkInterfaces.size() > 0 )
	      {
	         networkInterface = networkInterfaces.get( 0 );
	      }
	      else
	      {
	         System.out.println( "No network interfaces detected" );
	         return;
	      }
	   }
		
       NetworkComponent.createServerInstance();
       NetworkComponent.getInstance().startListening( networkInterface, port );
       
		Constants.GamePlayConstants c = new Constants.GamePlayConstants();
		c.showEditor("ServerSettings");	
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new ServerPlayingState());
	}
}
