package FundOfAlgos;

import java.sql.Time;
import java.util.*;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        Map<String, List<Time>> map = new HashMap<>();
        map.put("period1", new ArrayList<>() {{
            add(new Time(12, 10, 00));
            add(new Time(12, 11, 00));
        }});
        map.put("period2", new ArrayList<>() {{
            add(new Time(12, 12, 00));
            add(new Time(12, 13, 00));
        }});
        map.put("period3", new ArrayList<>() {{
            add(new Time(12, 11, 00));
            add(new Time(12, 14, 00));
        }});
        map.put("period4", new ArrayList<>() {{
            add(new Time(12, 11, 00));
            add(new Time(12, 15, 00));
        }});
        map.put("period5", new ArrayList<>() {{
            add(new Time(12, 14, 00));
            add(new Time(12, 17, 00));
        }});
        map.put("period6", new ArrayList<>() {{
            add(new Time(9, 9, 00));
            add(new Time(10, 16, 00));
        }});
        map.put("period7", new ArrayList<>() {{
            add(new Time(15, 14, 00));
            add(new Time(20, 17, 00));
        }});
        List<Time[]> lectures = new ArrayList<>();
        for (Map.Entry<String, List<Time>> entry : map.entrySet()) {
            lectures.add(new Time[]{entry.getValue().get(0), entry.getValue().get(1)});
        }

        List<Time[]> selectedLectures = greedyAlgorithm(lectures);
        System.out.println("Выбранные лекции:");
        for (Time[] lecture : selectedLectures) {
            System.out.println("С " + lecture[0] + " по " + lecture[1]);
        }
    }

    public static List<Time[]> greedyAlgorithm(List<Time[]> lectures) {
        Collections.sort(lectures, Comparator.comparing(t -> t[1]));
        List<Time[]> selectedLectures = new ArrayList<>();
        Time lastEndTime = null;
        for (Time[] lecture : lectures) {
            if (lastEndTime == null || lecture[0].after(lastEndTime)) {
                selectedLectures.add(lecture);
                lastEndTime = lecture[1];
            }
        }
        return selectedLectures;
    }
}
