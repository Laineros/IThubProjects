import java.util.*;

public class RobotInTheNorth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }
        System.out.println(findFromStartToEnd(list));
    }

    private static String findFromStartToEnd(List<String> moves) {
        // Счётчики для in/out
        Map<String, Integer> outCount = new HashMap<>();
        Map<String, Integer> inCount = new HashMap<>();

        for (String move : moves) {
            String[] parts = move.split(" ");
            String fromAddress = parts[0] + " " + parts[1];
            String toAddress = parts[2] + " " + parts[3];

            // Увеличиваем количество in/out +1
            outCount.put(fromAddress, outCount.getOrDefault(fromAddress, 0) + 1);
            inCount.put(toAddress, inCount.getOrDefault(toAddress, 0) + 1);
        }

        String start = null;
        String end = null;

        Set<String> allAddresses = new HashSet<>();
        allAddresses.addAll(outCount.keySet());
        allAddresses.addAll(inCount.keySet());

        for (String address : allAddresses) {
            // Считаем сколько раз приехал/уехал
            int out = outCount.getOrDefault(address, 0);
            int in = inCount.getOrDefault(address, 0);
            // Если ушёл больше, чем пришёл, возможное начало
            // Если пришёл больше, чем ушёл, возможный конец
            if (out > in) {
                if (start != null) return "-1"; // Если начал больше 1 -> -1
                start = address;
            } else if (in > out) {
                if (end != null) return "-1"; // Если концов больше 1 -> -1
                end = address;
            }
        }
        // Если нашли по одной точки start&&end возвращаем точки
        if (start != null && end != null) {
            return start + " " + end;
        } else {
            return "-1";
        }
    }
}
