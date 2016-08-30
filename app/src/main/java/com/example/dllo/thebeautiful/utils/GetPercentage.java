package com.example.dllo.thebeautiful.utils;

/**
 * Created by dllo on 16/8/26.
 */
public class GetPercentage {

    /**
     * 得到喜欢与否的高度条
     */
    public static double getUnLikeHeight(double likeNum, double unLikeNum){
        double unlikeHeight = (unLikeNum / (likeNum + unLikeNum)) * 400;
        return unlikeHeight;
    }

    public static double getLikeHeight(double likeNum, double unLikeNum){
        double likeHeight = (likeNum / (likeNum + unLikeNum)) * 400;
        return likeHeight;
    }

    /**
     * 得到喜欢与否的百分比
     */
    public static double getUnLikePercentage(double likeNum, double unLikeNum) {
        double UnLikePercentage = (unLikeNum / (likeNum + unLikeNum)) * 100;
        return UnLikePercentage;
    }

    public static double getLikePercentage(double likeNum, double unLikeNum) {
        double LikePercentage = (likeNum / (likeNum + unLikeNum)) * 100;
        return LikePercentage;
    }



}
