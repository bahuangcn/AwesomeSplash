package site.linyuange.awesome.splash.tracker;

import com.segment.analytics.Analytics;
import com.segment.analytics.Properties;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Author: BaHuang
 * Date: 2018/9/14 15:04
 */
public class TrackerManager {

    private static TrackerManager sSingleton = new TrackerManager();
    private Analytics mAnalytics;

    private TrackerManager() {}

    public static void registerTrackerManger(Analytics analytics) {
        sSingleton.mAnalytics = analytics;
    }

    public static TrackerManager instance() {
        return sSingleton;
    }
    public void trackerEvent(String event) {
        trackerEvent(event, new HashMap<>());
    }
    public void trackerEvent(String event, Map<String, String> map) {
        Properties properties = new Properties();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            properties.put(entry.getKey(), entry.getValue());
        }
        mAnalytics.track(event, properties);
    }
}
