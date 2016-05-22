package lc.mpcontent.utils;

/**
 * Created by lin on 16-5-22.
 */
public class ViewUtils {

    private static long lastClick = 0;

    private static final long TIME_DURATION = 200;

    public static boolean isFastClick(){
        long cur_time = System.currentTimeMillis();
        long dur_time = cur_time - lastClick;
        if(dur_time > TIME_DURATION){
            return false;
        }else{
            return true;
        }
    }
}
