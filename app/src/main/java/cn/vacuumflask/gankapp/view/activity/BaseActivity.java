package cn.vacuumflask.gankapp.view.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/4/27 0027.
 * Activity基类
 */

public class BaseActivity extends AppCompatActivity {

    public <T extends ViewDataBinding> T getDataBindingView(int res) {
        return DataBindingUtil.setContentView(this, res);
    }
}
