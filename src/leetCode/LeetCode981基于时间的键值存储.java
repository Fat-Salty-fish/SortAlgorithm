package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/14
 */
public class LeetCode981基于时间的键值存储 {

    static class Value {

        /**
         * 存储的值
         */
        public String value;

        /**
         * 时间戳
         */
        public int timeStamp;


    }

    static class TimeMap {


        Map<String, LinkedList<Value>> keyValueTimeMap;


        public TimeMap() {
            keyValueTimeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            LinkedList<Value> list = keyValueTimeMap.getOrDefault(key, new LinkedList<>());
            Value valueObject = new Value();
            valueObject.value = value;
            valueObject.timeStamp = timestamp;
            list.add(valueObject);
            keyValueTimeMap.put(key, list);
        }

        public String get(String key, int timestamp) {
            if (!keyValueTimeMap.containsKey(key)) {
                return "";
            }
            LinkedList<Value> valueList = keyValueTimeMap.get(key);
            for (int i = valueList.size() - 1; i >= 0; i--) {
                Value single = valueList.get(i);
                if (single.timeStamp <= timestamp){
                    return single.value;
                }
            }
            return "";
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo","bar",1);
        System.out.println(timeMap.get("foo",1));
        System.out.println(timeMap.get("foo",3));
    }

}
