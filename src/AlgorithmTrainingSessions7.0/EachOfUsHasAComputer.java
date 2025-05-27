import java.util.*;

public class EachOfUsHasAComputer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] groupSizes = new int[N];
        for (int i = 0; i < N; i++) {
            groupSizes[i] = sc.nextInt();
        }

        int[] roomComputers = new int[M];
        for (int i = 0; i < M; i++) {
            roomComputers[i] = sc.nextInt();
        }

        List<int[]> sortedGroups = sort(N, groupSizes);

        List<int[]> sortedRooms = sort(M, roomComputers);

        int[] result = new int[N];
        Arrays.fill(result, 0);

        int roomIndex = 0;
        int groupCount = 0;

        for (int[] group : sortedGroups) {
            int groupSize = group[0];
            int groupIdx = group[1];
            int requiredComputers = groupSize + 1;

            while (roomIndex < M && sortedRooms.get(roomIndex)[0] < requiredComputers) {
                roomIndex++;
            }

            if (roomIndex < M) {
                result[groupIdx] = sortedRooms.get(roomIndex)[1] + 1;
                roomIndex++;
                groupCount++;
            }
        }

        System.out.println(groupCount);
        System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
    }

    private static List<int[]> sort(int n, int[] groupSizes) {
        List<int[]> sortedGroups = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sortedGroups.add(new int[]{groupSizes[i], i});
        }
        sortedGroups.sort(Comparator.comparingInt(a -> a[0]));
        return sortedGroups;
    }
}
