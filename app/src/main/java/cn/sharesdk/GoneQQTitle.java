package cn.sharesdk;

import cn.sharesdk.framework.authorize.AuthorizeAdapter;

/**
 * Created by dllo on 16/8/15.
 */
public class GoneQQTitle extends AuthorizeAdapter {
    public void onCreate() {
        // 隐藏标题栏右部的ShareSDK Logo
        hideShareSDKLogo();
    }
}
