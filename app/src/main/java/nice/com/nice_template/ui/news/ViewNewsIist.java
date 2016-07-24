package nice.com.nice_template.ui.news;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import nice.com.nice_library.bean.BaseBean;
import nice.com.nice_template.R;
import nice.com.nice_template.background.ConfigValue;
import nice.com.nice_template.background.RequestAPI;
import nice.com.nice_template.core.AbstractActivity;
import nice.com.nice_template.ui.ErrorViewForReload;

import java.util.HashMap;
import java.util.Map;

import cn.finalteam.loadingviewfinal.ListViewFinal;
import cn.finalteam.loadingviewfinal.OnLoadMoreListener;
import cn.finalteam.loadingviewfinal.SwipeRefreshLayoutFinal;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class ViewNewsIist extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {

    private SwipeRefreshLayoutFinal refresh_layout;
    private ListViewFinal news_list;
    private ErrorViewForReload errorView;
    private int page = 1;
    private int size = 20;
    private AbstractActivity activity;
    private NewsListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_news_list, container, false);
        initView(view);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (AbstractActivity) getActivity();
    }

    private void initView(View view) {
        refresh_layout = (SwipeRefreshLayoutFinal) view.findViewById(R.id.refresh_layout);
        news_list = (ListViewFinal) view.findViewById(R.id.news_list);
        errorView = (ErrorViewForReload) view.findViewById(R.id.errorView);

        refresh_layout.setOnRefreshListener(this);
        news_list.setOnLoadMoreListener(this);
        refresh_layout.autoRefresh();
    }

    public void setData(NewsGroupListBean.DataBean.NewsGroupBean groupBean){
//        refresh_layout.autoRefresh();
    }

    private void getData() {
        Map<String, String> params = new HashMap<>();
        activity.new NiceAsyncTask() {

            @Override
            public void loadSuccess(BaseBean bean) {
                NewsListBean listBean = (NewsListBean) bean;
                if (listBean!=null&&listBean.getData()!=null){
                    if (page == 1){
                        refresh_layout.onRefreshComplete();
                        if (adapter == null){
                            adapter = new NewsListAdapter(listBean.getData().getNews_list(),activity,null,null);
                            news_list.setAdapter(adapter);
                        }else {
                            adapter.setData(listBean.getData().getNews_list());
                        }
                    }else {
                        news_list.onLoadMoreComplete();
                        adapter.addData(listBean.getData().getNews_list());
                    }
                    if (listBean.getData().isLastPage()){
                        news_list.setHasLoadMore(false);
                    }else {
                        news_list.setHasLoadMore(true);
                    }
                }
            }

            @Override
            public void exception() {

            }
        }.post(true, RequestAPI.API_JZB_NEWS_LIST, params, NewsListBean.class);
    }

    @Override
    public void loadMore() {
        page++;
        getData();
    }

    @Override
    public void onRefresh() {
        page = 1;
        getData();
    }
}
