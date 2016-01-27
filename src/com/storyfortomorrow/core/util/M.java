package com.storyfortomorrow.core.util;

import org.json.JSONException;

import com.storyfortomorrow.core.lib.References;

public class M
{
	
	/**
	 * Get the message from cached JSON file
	 * 
	 * @param message
	 */
	public static String m(String message)
	{
		try
		{
			return References.JSON.getJSONObject("messages").getString("loading");
		}
		catch (JSONException e)
		{
			return "Error";
		}
	}
}
