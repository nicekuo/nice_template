package nice.com.nice_template;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.id_home_fragment)
    FrameLayout idHomeFragment;
    @BindView(R.id.id_shop_image)
    ImageView idShopImage;
    @BindView(R.id.id_shop_text)
    TextView idShopText;
    @BindView(R.id.id_shop)
    LinearLayout idShop;
    @BindView(R.id.id_home_image)
    ImageView idHomeImage;
    @BindView(R.id.id_home_text)
    TextView idHomeText;
    @BindView(R.id.id_home)
    LinearLayout idHome;
    @BindView(R.id.id_me_image)
    ImageView idMeImage;
    @BindView(R.id.id_me_text)
    TextView idMeText;
    @BindView(R.id.id_me)
    LinearLayout idMe;
    @BindView(R.id.id_bottom)
    LinearLayout idBottom;
    @BindView(R.id.splashImageOne)
    ImageView splashImageOne;
    @BindView(R.id.splashImageTwo)
    ImageView splashImageTwo;
    @BindView(R.id.splashImageThree)
    ImageView splashImageThree;
    @BindView(R.id.splashLayout)
    LinearLayout splashLayout;
    @BindView(R.id.rootView)
    FrameLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main_layout);
        ButterKnife.bind(this);

    }
}
