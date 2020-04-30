package View;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Paths;

public class Bgm {
	//mediaPlayer-object will not we cleaned away since someone holds a reference to it!	
	private static MediaPlayer mediaPlayer;
	private static boolean playable = true;

	protected static void changeStat(boolean result) {
		playable = result;
		try {
			if(!result) {
				mediaPlayer.stop();
			}
			else {
					System.out.println("should playe music");
					Media hit = new Media(Paths.get("src/View/bgm.mp3").toUri().toString());
					mediaPlayer = new MediaPlayer(hit);
					mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
					mediaPlayer.setAutoPlay(true);

			}
		}catch (Exception e ){
			// do nothing if system is not support playing mp3
			System.out.println("does not support mp3"+e.getMessage());
		}
	}
	
	protected static boolean getStat() {
		return playable;
	}
	
	public static void play()
	{
		if(playable) {
			try {
				Media hit = new Media(Paths.get("bgm.mp3").toUri().toString());
				mediaPlayer = new MediaPlayer(hit);
				mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
				mediaPlayer.setAutoPlay(true);
			}catch (Exception e){
				// do nothing if system is not support.
			}
		}
	}
}