package com.example.servelt;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
	
	private ActionFactory(){
		init();
	}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	/**
	 * Action을 저장할 map
	 */
	Map<String, Action> actions = new HashMap<>();
	
	private void init(){
		actions.put("add", new AddRegionAction());
		actions.put("del", new DeleteAction());
	}
	
	public Action getAction(String cmd){
		return actions.get(cmd);
	}
}
