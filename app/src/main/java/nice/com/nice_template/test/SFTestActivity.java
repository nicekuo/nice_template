package nice.com.nice_template.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import nice.com.nice_library.util.NiceLogUtil;
import nice.com.nice_template.R;
import nice.com.nice_template.utils.ExtendFileUtil;

/**
 * Created by sufun_job on 2016/2/24.
 * @descritption 处理类
 */
public class SFTestActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        donLoadAssetRestTest();
    }
    /**
     * 加载本地资源测试
     */
    void donLoadAssetRestTest()
    {
        findViewById(R.id.id_btn_load_assets).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= ExtendFileUtil.getAssetContentByName("datas", "service_shops.json", SFTestActivity.this);
                NiceLogUtil.D("     this is the data read---->" + data);
            }
        });
    }
}
