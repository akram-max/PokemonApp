package fr.eilco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        //        Remove title bar
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        Remove notification bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView logoView = findViewById(R.id.logo);
        Glide.with(this)
                .load("https://www.eilco-ulco.fr/wp-content/uploads/2011/12/logo.png")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(logoView);

        Toast.makeText(this, "Created by : Soufiane Neffar & Bourichi Akram", Toast.LENGTH_LONG).show();

        new android.os.Handler().postDelayed(this::finish, 5000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

}