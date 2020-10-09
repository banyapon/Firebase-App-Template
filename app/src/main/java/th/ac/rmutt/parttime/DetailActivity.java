package th.ac.rmutt.parttime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView ShowTitle,ShowDetail;
    ImageView ShowImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ShowImage = (ImageView)findViewById(R.id.ShowImage);
        ShowTitle = (TextView)findViewById(R.id.ShowTitle);
        ShowDetail = (TextView)findViewById(R.id.ShowDetail);
        Intent intent= getIntent();
        ShowTitle.setText(""+intent.getStringExtra("title"));
        ShowDetail.setText(""+intent.getStringExtra("content"));
        Picasso.with(this).load(intent.getStringExtra("image")).into(ShowImage);

    }
}