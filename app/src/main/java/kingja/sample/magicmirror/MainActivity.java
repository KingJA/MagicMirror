package kingja.sample.magicmirror;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kingja.magicmirror.MagicMirrorView;

public class MainActivity extends AppCompatActivity {
    int sides=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MagicMirrorView polygonMirror = (MagicMirrorView) findViewById(R.id.polygonMirror);
        polygonMirror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                polygonMirror.setSides(++sides);
                polygonMirror.setFilter(sides%2==0? MagicMirrorView.Filter.SATURATION: MagicMirrorView.Filter.GRAY);
            }
        });
    }
}
