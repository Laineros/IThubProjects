public class MinElem {
    public static int findMinElement(int[] arr, int left, int right) {
        // Если массив содержит только один элемент
        if (left == right) {
            if (arr[left] % 5 == 0 && arr[left] % 3 != 0) {
                return arr[left];
            } else {
                return Integer.MAX_VALUE;
            }
        }
        // Разделяем массив на две половины
        int mid = (left + right) / 2;
        // Рекурсивный вызов для левой и правой части
        int leftMin = findMinElement(arr, left, mid);
        int rightMin = findMinElement(arr, mid + 1, right);

        // Возвращаем минимальный из найденных элементов
        return Math.min(leftMin, rightMin);
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 25, 30, 40, 50, 75, 95};

        // Вызываем метод для поиска минимального элемента
        int result = findMinElement(arr, 0, arr.length - 1);

        // Выводим результат
        if (result == Integer.MAX_VALUE) {
            System.out.println("Нет элемента, который кратен 5, но не кратен 3.");
        } else {
            System.out.println("Минимальный элемент, кратный 5, но не кратный 3: " + result);
        }
    }
}
