package com.ywwxhz.data;

import android.app.Activity;
import android.widget.AdapterView;

import com.ywwxhz.adapters.BaseAdapter;

import java.util.List;

/**
 * cnBetaReader
 * <p/>
 * Created by 远望の无限(ywwxhz) on 2015/3/25 20:33.
 */
public abstract class ListDataProvider<DataType,DataAdapter extends BaseAdapter<DataType>> extends BaseDataProvider<List<DataType>> {
    private DataAdapter adapter;
    private Activity mActivity;
    private int minPageSize;

    private int pageSize;

    protected boolean hasCached;

    public ListDataProvider(Activity activity) {
        super(activity);
    }

    public DataAdapter getAdapter() {
        if(adapter == null){
            adapter = newAdapter();
        }
        return adapter;
    }

    @Override
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        getAdapter().setContext(activity);
    }

    protected abstract DataAdapter newAdapter();

    public abstract String getTypeKey() ;

    public abstract String getTypeName();

    public abstract void loadNewData();

    public abstract void loadNextData();

    public AdapterView.OnItemClickListener getOnItemClickListener(){return null;}

    public AdapterView.OnItemLongClickListener getOnItemLongClickListener(){return null;}

    public boolean isCached() {
        return hasCached;
    }

    public int getMinPageSize() {
        return minPageSize;
    }

    public void setMinPageSize(int pageSize) {
        this.minPageSize = pageSize;
    }

    public void setPageSize(int pageSize){
        this.minPageSize = this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }
}
