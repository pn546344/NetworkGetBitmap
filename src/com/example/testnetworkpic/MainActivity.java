package com.example.testnetworkpic;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn;
	private ImageView im;
	private Bitmap b;
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			im.setImageBitmap(b);
			Log.i("ttt", "getBitmap");
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button)findViewById(R.id.button1);
		im  = (ImageView)findViewById(R.id.imageView1);
		btn.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				b = loadImageFromNetwork("http://rack.2.mshcdn.com/media/ZgkyMDE0LzA2LzExLzQ3L0Fzc2Fzc2luc0NyLjVjN2EwLmpwZwpwCXRodW1iCTEyMDB4OTYwMD4/b3d33ac3/c02/Assassins-Creed-Unity-2.jpg");
				handler.sendMessage(new Message());
			}
		}).start();
	}
	private Bitmap loadImageFromNetwork(String url) {
		try {
			Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).getContent());
			return	bitmap;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
