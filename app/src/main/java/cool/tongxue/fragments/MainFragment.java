package cool.tongxue.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;

import cool.tongxue.R;
import cool.tongxue.base.TXFragmentActivity;


public class MainFragment extends TXFragmentActivity {
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    private TabPagerAdapter mTabAdapter;                //Pager 数据适配器

    private DisplayMetrics dm;                          //获取当前屏幕的密度

    private View main_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dm = getResources().getDisplayMetrics();        //获取屏幕分辨率
        main_view = LayoutInflater.from(this).inflate(R.layout.fragment_main, null);
        setContentView(main_view);
        initViews();
    }

    /**
     * init views
     */
    private void initViews() {
        tabs = (PagerSlidingTabStrip) main_view.findViewById(R.id.tabs);
        pager = (ViewPager) main_view.findViewById(R.id.pager);
        mTabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(mTabAdapter);
        tabs.setViewPager(pager);
        setTabsValue();
    }

    /**
     * 对PagerSlidingTabStrip的各项属性进行赋值。
     */
    private void setTabsValue() {
        // 设置Tab是自动填充满屏幕的
        tabs.setShouldExpand(false);
        //tabs.setUnderlineColorResource(R.color.indicator_color);

        // 设置Tab的分割线是透明的
        tabs.setDividerColor(getResources().getColor(android.R.color.transparent));
        // 设置Tab底部线的高度
        tabs.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        tabs.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, dm));
        // 设置Tab标题文字的大小
        tabs.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, dm));
        // 设置Tab Indicator的颜色
        tabs.setIndicatorColor(getResources().getColor(R.color.indicator_color));
        // 设置选中Tab文字的颜色 (这是我自定义的一个方法)
        //tabs.setSelectedTextColor(getResources().getColor(R.color.indicator_color));
        // 取消点击Tab时的背景色
        tabs.setTabBackground(0);
    }


    /**
     * tab adapter
     */
    private class TabPagerAdapter extends FragmentPagerAdapter {
        private String[] mTitles = {"消息", "助考", "同学", "我"};
        private Fragment[] fragments = {new NewsFragment(), new HelptestFragment(), new TongxueFragment(), new MyFragment()};

        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }
    }

}
