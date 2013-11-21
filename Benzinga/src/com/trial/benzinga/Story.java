package com.trial.benzinga;

/** Story class to encapsulate all new story related information
 * @author: Sumedha Pramod
 * @version: 0.1
 */
public class Story { 
	public String title, author, text, snippet, time, date;
	
	/** Constructor used each time a new news story is created
	 * @param i Index for story in news list
	 */
	Story(int i) {
		title = "Story " + Integer.toString(i);
		author = "Author Name";
		text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin aliquet imperdiet quam viverra lacinia. " +
				"Etiam euismod magna ut dolor venenatis, nec dictum est iaculis. Vestibulum risus ipsum, tempor nec orci vel, " +
				"porttitor mollis erat. Morbi at risus in arcu elementum dapibus a et metus. Etiam aliquam ligula vel lacus " +
				"sollicitudin ultricies. Vestibulum diam eros, fringilla a massa fringilla, vestibulum iaculis enim. Cras " +
				"consectetur mollis justo ut ullamcorper. Nullam ultricies consectetur sapien vel dictum. Aenean bibendum " +
				"pharetra risus sed placerat. Vivamus egestas feugiat vehicula.\n\n" + 
				"Donec sed luctus odio, sed luctus nunc. Cras ultrices iaculis egestas. Sed id dui libero. Sed est neque, " +
				"hendrerit id augue et, interdum dignissim sapien. Morbi mattis nunc et nisi ornare ultricies. Quisque " +
				"gravida nisi vehicula est tincidunt, quis rhoncus eros fermentum. Suspendisse interdum, quam eget feugiat " +
				"iaculis, risus tortor tempus neque, ac porttitor quam eros id enim.\n\n" + 
				"Sed non elit quis diam fermentum porta. Ut quis bibendum lacus. Vivamus dictum nisi eget sem interdum, ut " +
				"sollicitudin enim malesuada. Nunc gravida metus risus, sed placerat mi tincidunt vel. Duis aliquam aliquet " +
				"orci ut placerat. Donec sit amet ullamcorper tellus, vitae accumsan nulla. Aliquam viverra eu metus in " +
				"condimentum.\n\n" +
				"Donec a elit nec augue suscipit tempor. Cras pharetra scelerisque sapien, non pulvinar metus feugiat eget. " +
				"In non augue ac augue venenatis condimentum ac sit amet arcu. Vivamus eget rhoncus tortor. Etiam sed tellus " +
				"nunc. In sollicitudin mauris massa, id adipiscing enim viverra in. Nam bibendum metus tellus, nec tincidunt " +
				"nisl faucibus a. Nullam convallis ut augue ut sodales. Ut iaculis nunc ultricies posuere condimentum. Proin " +
				"tristique gravida tempus.\n\n" +
				"Proin a purus urna. Nam blandit diam sit amet consectetur mollis. Mauris pellentesque augue eget ipsum " +
				"elementum, vitae adipiscing elit cursus. Vestibulum lorem dui, ullamcorper sed facilisis ac, consectetur in " +
				"arcu. Sed in adipiscing enim. Donec eleifend pretium tortor vitae rutrum. Vestibulum quis nisi nec felis " +
				"venenatis rhoncus et nec purus. Nulla facilisi.";
		time = 0 + "m ago";
		snippet = text.substring(0, 245);
		date = "Nov 21, 2013";
	}
}