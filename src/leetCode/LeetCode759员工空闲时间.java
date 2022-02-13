package leetCode;

import others.Interval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/4
 */
public class LeetCode759员工空闲时间 {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        // 将所有的工作时间全部合并到一起 并排序
        List<Interval> flat = schedule.stream().flatMap(Collection::stream)
                .sorted((o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start).collect(Collectors.toList());
        // 将重复的工作时间合并
        List<Interval> merged = new ArrayList<>();
        int index = 0;
        while (index < flat.size()) {
            Interval currentInterval = flat.get(index);
            // 有重叠
            while (index < flat.size() && currentInterval.end >= flat.get(index).start) {
                Interval temp = flat.get(index);
                currentInterval.start = Math.min(currentInterval.start, temp.start);
                currentInterval.end = Math.max(currentInterval.end, temp.end);
                index++;
            }
            merged.add(currentInterval);
        }
        if (merged.size() == 1) {
            return result;
        }
        Interval first = merged.get(0);
        for (int i = 1; i < merged.size(); i++) {
            Interval current = merged.get(i);
            int start = first.end;
            int end = current.start;
            if (start < end) {
                result.add(new Interval(start, end));
            }
            first = current;
        }
        return result;
    }

    /**
     * 扫描线
     *
     * @param schedule
     * @return
     */
    public List<Interval> employeeFreeTime2(List<List<Interval>> schedule) {
        List<int[]> events = new ArrayList<>();
        List<Interval> all = schedule.stream().flatMap(Collection::stream).collect(Collectors.toList());
        for (Interval each : all) {
            events.add(new int[]{each.start, 1});
            events.add(new int[]{each.end, -1});
        }
        events.sort(((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        List<Interval> result = new ArrayList<>();
        int start = -1;
        int balance = 0;
        for (int[] currentArray : events) {
            if (start >= 0 && balance == 0 && start != currentArray[0]) {
                result.add(new Interval(start, currentArray[0]));
            }
            start = currentArray[0];
            balance += currentArray[1];
        }
        return result;
    }
}
