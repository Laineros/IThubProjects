import java.util.*;

public class SatelliteImagery {
    private static int W, H, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        H = sc.nextInt();
        N = sc.nextInt();

        Set<Point> prev = new HashSet<>();
        // Заполняем координаты для первого треугольника
        int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
        // Добавляем все точки прямоугольника во множество
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                prev.add(new Point(x, y)); // Добавляем точку в множество
            }
        }
        // Обрабатываем следующий снимок
        for (int i = 1; i < N; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            Set<Point> currentPointsOfPhoto = new HashSet<>();
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    currentPointsOfPhoto.add(new Point(x, y));
                }
            }
            // Для проверки пересечений с предыдущим снимком
            Set<Point> next = new HashSet<>();
            // Проверяем все соседние точки для каждой точки предыдущего снимка
            for (Point p : prev) {
                for (int dx = -1; dx <= 1; dx++) { // По горизонтали и вертикали
                    for (int dy = -1; dy <= 1; dy++) { // По вертикали и горизонтали
                        // Если соседняя точка
                        if (Math.abs(dx) + Math.abs(dy) == 1) {
                            int nx = p.x + dx;
                            int ny = p.y + dy;
                            // Создаём новую точку
                            Point np = new Point(nx, ny);
                            // Если новая точка пересекает текущий прямоугольник, добавляем в next
                            if (currentPointsOfPhoto.contains(np)) {
                                next.add(np);
                            }
                        }
                    }
                }
            }
            // Если после пересечения не осталось точек значит Лиза не может попасть на все снимки
            if (next.isEmpty()) {
                System.out.println("No");
                return;
            }
            prev = next;
        }
        System.out.println("Yes");
    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

