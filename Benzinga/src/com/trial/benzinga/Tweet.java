package com.trial.benzinga;
/** Tweet class to encapsulate all trending tweet related information
 * @author: Sumedha Pramod
 * @version: 0.1
 */
public class Tweet { 
	public String author, username, text, time, url;
	
	/** Constructor used each time a new trending tweet is created
	 */
	Tweet() {
		author = "Sumedha Pramod";
		username = "@" + "pramodsum";
		text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, " +
				"sed do eiusmod tempor incididunt ut labore et dolore magna " +
				"aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
				"ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
				"aute irure dolor in reprehenderit in voluptate velit esse cillum " +
				"dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat " +
				"non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		time = 0 + "m ago";
		url = "www.twitter.com";
	}
}