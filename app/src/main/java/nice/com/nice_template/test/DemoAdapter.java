package nice.com.nice_template.test;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import nice.com.nice_library.adapter.IOnItemtClickListerner;
import nice.com.nice_library.adapter.SFBaseRecyclerAdapter;
import nice.com.nice_library.adapter.SFBaseViewHolder;
import nice.com.nice_library.bean.BaseBean;
import nice.com.nice_template.R;

import java.util.List;

/**
 * Created by sufun_job on 2016/1/19.
 *
 * 用于测试的测试Adapter
 *
 * @description:
 *     调用过程
 *
 */
public class DemoAdapter extends SFBaseRecyclerAdapter<BaseBean> {

    public DemoAdapter(Context mContext, List<BaseBean> mdatas, IOnItemtClickListerner<BaseBean> clickListerner, Object other) {
        super(mContext, mdatas, clickListerner, other);
        child_layout_id= R.layout.recycler_view_item;
    }

    @Override
    public SFBaseViewHolder getViewHolder(View v) {
        return new CoreHolder(v);
    }

    /**
     *自定义的VieewHoder
     */
    public class CoreHolder extends SFBaseViewHolder
    {
        Button id_btn;

        public CoreHolder(View view) {
            super(view);
        }

        @Override
        public void initViewHolder(View view) {
           id_btn=(Button)view.findViewById(R.id.id_btn);
        }

        @Override
        public void onBindData(int position) {
               //绑定数据
            id_btn.setText(mDatas.get(position).msg);
        }
    }
}
