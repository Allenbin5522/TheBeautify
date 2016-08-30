package com.example.dllo.thebeautiful.model.net;

import android.widget.TabHost;

/**
 * Created by dllo on 16/8/16.
 * 所有的接口
 */
public class URLValues {


    /**
     * 有物界面
     */
    //有物
    public static final String THINGS_THINGS = "http://design.zuimeia.com/api/v1/activities/daily/?timestamp=1471320000000&device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.5&appVersionCode=10105&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld%20HTTP/1.1";
    //包袋
    public static final String THINGS_BAG = "http://design.zuimeia.com/api/v1/products/category/1/?page=1&page_size=30&device_id=867886023232352&platform=android&lang=zh&appVersion=1.0.6&appVersionCode=10006&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //鞋履
    public static final String THINGS_SHOES = "http://design.zuimeia.com/api/v1/products/category/2?page=1&page_size=30&device_id=867886023232352&platform=android&lang=zh&appVersion=1.0.6&appVersionCode=10006&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //首饰
    public static final String THINGS_JEWELRY = "http://design.zuimeia.com/api/v1/products/category/3?page=1&page_size=30&device_id=867886023232352&platform=android&lang=zh&appVersion=1.0.6&appVersionCode=10006&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //配饰
    public static final String THINGS_ACCESSORY = "http://design.zuimeia.com/api/v1/products/category/4?page=1&page_size=30&device_id=867886023232352&platform=android&lang=zh&appVersion=1.0.6&appVersionCode=10006&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //其他
    public static final String THINGS_OTHERS = "http://design.zuimeia.com/api/v1/products/category/54?page=1&page_size=30&device_id=867886023232352&platform=android&lang=zh&appVersion=1.0.6&appVersionCode=10006&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";

    //有物界面pop目录
    public static final String THINGS_POP = "http://design.zuimeia.com/api/v1/product/categories/?device_id=867886023232352&platform=android&lang=zh&appVersion=1.0.6&appVersionCode=10006&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //有物二级界面
    public static final String THINGS_SECOND = "http://design.zuimeia.com/api/v1/product/913/?device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.5&appVersionCode=10105&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    /**
     *画报二级界面
     */
    public static final String PIC_CHILD_START = "http://design.zuimeia.com/api/v1/article/";
    public static final String PIC_CHILD_END = "/?device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.7_1&appVersionCode=10171&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";



    /**
     *设计师
     */
    public static final String DESIGNER  = "http://design.zuimeia.com/api/v1/designers/?page=1&page_size=30&device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.5&appVersionCode=10105&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";

    // 设计师详情页拼接前部分
    public static final String DESIGNER_BANNER_BEFORE = "http://design.zuimeia.com/api/v1/designer/";
    // 设计师详情页拼接后部分
    public static final String DESIGHER_BANNER_AFTER = "/?device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.5&appVersionCode=10105&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";


}
