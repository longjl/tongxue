package cool.tongxue.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.actionbarsherlock.app.SherlockFragment;

import cool.tongxue.R;

/**
 * 消息
 * Created by longjianlin on 15/7/3.
 */
public class NewsFragment extends SherlockFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, null);
    }


}
