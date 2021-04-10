package com.example.addproducttocart;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class AnimationUtils {
    static final int ANIMATION_DURATION = 1000;
    static boolean isAnimationtoStart;

    public static void translateAnimation(final ImageView viewAnimations,final View startView,View endView,final Animation.AnimationListener animationListener){
        startView.setDrawingCacheEnabled(true);
        Bitmap cache = startView.getDrawingCache();
        if(cache == null)
            return;
        Bitmap bitmap = Bitmap.createBitmap(cache);
        startView.setDrawingCacheEnabled(false);
        viewAnimations.setImageBitmap(bitmap);
        float startViewWidthCenter = startView.getWidth()/2;
        float startViewHeightCenter = startView.getHeight()/2;

        float endViewWidthCenter= (float) (endView.getWidth()*0.75);
        float endViewHeightCenter = endView.getHeight() /2f;
        final int[] startPops = new int[2];
        startView.getLocationOnScreen(startPops);
        final int[] endPops = new int[2];
        endView.getLocationOnScreen(endPops);

        float fromX = startPops[0];
        float toX = endPops[0] + endViewWidthCenter - startViewWidthCenter;
        float fromY = startPops[1];
        float toY = endPops[1] + endViewHeightCenter - startViewHeightCenter;

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(new AccelerateInterpolator());

        int animationDuration = 200;
        ScaleAnimation startScaleAnimation = new ScaleAnimation(1.0f, 1.5f, 1.0f,1.5f,startViewWidthCenter,startViewHeightCenter);
        startScaleAnimation.setDuration(animationDuration);
        View view;
        TranslateAnimation translateAnimation = new TranslateAnimation(fromX, toX, fromY, toY);
        translateAnimation.setStartOffset(animationDuration);
        translateAnimation.setDuration(ANIMATION_DURATION);

        ScaleAnimation translateScaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, toX,toY);
        translateScaleAnimation.setStartOffset(animationDuration);
        translateScaleAnimation.setDuration(ANIMATION_DURATION);

        animationSet.addAnimation(startScaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(translateScaleAnimation);

        if(isAnimationtoStart){
            viewAnimations.clearAnimation();
            if(animationListener!=null){
                animationListener.onAnimationEnd(null);
            }
        }

        viewAnimations.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                isAnimationtoStart = true;
                viewAnimations.setVisibility(View.VISIBLE);
                startView.setVisibility(View.INVISIBLE);
                if (animationListener != null){
                    animationListener.onAnimationStart(animation);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                viewAnimations.setVisibility(View.GONE);
                startView.setVisibility(View.VISIBLE);
                if (animationListener != null){
                    animationListener.onAnimationEnd(animation);
                }
                isAnimationtoStart = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                if (animationListener!=null)
                    animationListener.onAnimationRepeat(animation);
            }
        });

    }
}
