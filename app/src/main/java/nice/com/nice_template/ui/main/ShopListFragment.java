package nice.com.nice_template.ui.main;

import android.support.v4.widget.SwipeRefreshLayout;

import nice.com.nice_template.R;
import nice.com.nice_template.core.AbstractFragment;

import org.androidannotations.annotations.EFragment;

import cn.finalteam.loadingviewfinal.OnLoadMoreListener;


/**
 * Created by sufun_job on 2016/2/16.
 *
 * @description 商家列表主界面
 */
@EFragment(R.layout.fragment_main_home)
public class ShopListFragment extends AbstractFragment implements SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {


    @Override
    public void loadMore() {

    }

    @Override
    public void onRefresh() {

    }
}
