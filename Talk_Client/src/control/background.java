package control;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

import FriendsLists.FLists;
import common.MessageType;

public class background {
	static FLists fl;
	MessageType m;
	public background(MessageType U , Socket s,ObjectInputStream ois){
			
			 fl = new FLists(U, s);
			FlistThread ft = new FlistThread(s,ois);
			
		ft.start();
		
	}
}
