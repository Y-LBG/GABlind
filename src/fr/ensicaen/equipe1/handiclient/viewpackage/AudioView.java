package fr.ensicaen.equipe1.handiclient.viewpackage;

import java.util.Locale;
import fr.ensicaen.equipe1.handiclient.R;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

public class AudioView implements IView, TextToSpeech.OnInitListener {
	private TextToSpeech _tts;
	private Activity _activity;
	private int _layoutID;

	public AudioView(Activity activity, int layoutID) {
		_activity = activity;
		_layoutID = layoutID;
		_tts = new TextToSpeech(_activity, this);
	}

<<<<<<< HEAD
	public void readActivityDescription(){
		_activity.findViewById(R.id.layout);
=======
	@Override
	public void describe() {
		new Thread(new Runnable() {
			public void run() {
				ViewGroup layout = (ViewGroup) _activity.findViewById(_layoutID);
				for (int i = 0; i < layout.getChildCount(); i++) {
					View v = layout.getChildAt(i);
					if (v.getClass() == Button.class
							|| v.getClass() == TextView.class) {
						readButtonDescription((Button) v);
					}
				}
			}
		}).start();

>>>>>>> 05fc5798d320db99e01f1c85a28ef7899948a74a
	}

	private void readButtonDescription(Button button) {
		String text = button.getContentDescription().toString();
		_tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void reactOnAction(Button button) {
		Animation animation = new ScaleAnimation(1, 0.8f, 1, 0.8f);
	    animation.setDuration(300);
	    animation.setInterpolator(new AccelerateInterpolator());
	    animation.setRepeatCount(1);
	    animation.setRepeatMode(Animation.REVERSE); 
	    button.startAnimation(animation);
	}

	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			int resultLocalization = _tts.setLanguage(Locale.FRENCH);
			if (resultLocalization == TextToSpeech.LANG_MISSING_DATA
					|| resultLocalization == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "This Language is not supported");
			} else {
				Log.e("TTS", "Initilization Failed!");
			}
		}
	}
}
