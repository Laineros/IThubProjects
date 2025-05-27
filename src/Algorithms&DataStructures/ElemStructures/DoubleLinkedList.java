package ElemStructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Tariff {
    private String city;
    private double rate; // Стоимость звонка в определенный город

    public Tariff(String city, double rate) {
        this.city = city;
        this.rate = rate;
    }

    public String getCity() {
        return city;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Город: " + city + " Тариф: " + rate + " за минуту";
    }
}
class Call {
    private String city;
    private int duration; // Продолжительность звонка в минутах
    private double cost;  // Стоимость звонка

    public Call(String city, int duration, double cost) {
        this.city = city;
        this.duration = duration;
        this.cost = cost;
    }

    public String getCity() {
        return city;
    }

    public int getDuration() {
        return duration;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Звонок в город: " + city + " Продолжительность: " + duration + " мин, Стоимость: " + cost;
    }
}

class ClientATC {
    private String lastName;
    private LinkedList<Call> calls; // Список звонков клиента

    public ClientATC(String lastName) {
        this.lastName = lastName;
        this.calls = new LinkedList<>();
    }

    public String getLastName() {
        return lastName;
    }

    public void addCall(Call call) {
        calls.add(call);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Call call : calls) {
            total += call.getCost();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Клиент: " + lastName + ", Звонки: " + calls.toString();
    }
}


class ATC {
    private LinkedList<Tariff> tariffs; // Список тарифов
    private Map<String, ClientATC> clients; // Список клиентов по фамилии

    public ATC() {
        this.tariffs = new LinkedList<>();
        this.clients = new HashMap<>();
    }

    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
    }

    public void addClient(ClientATC clientATC) {
        clients.put(clientATC.getLastName(), clientATC);
    }

    public Tariff findTariff(String city) {
        for (Tariff tariff : tariffs) {
            if (tariff.getCity().equals(city)) {
                return tariff;
            }
        }
        return null; // Если тариф не найден
    }

    public void registerCall(String lastName, String city, int duration) {
        Tariff tariff = findTariff(city);
        if (tariff != null) {
            double cost = duration * tariff.getRate();
            Call call = new Call(city, duration, cost);
            ClientATC clientATC = clients.get(lastName);
            if (clientATC != null) {
                clientATC.addCall(call);
            } else {
                System.out.println("Клиент с фамилией " + lastName + " не найден");
            }
        } else {
            System.out.println("Тариф для города " + city + " не найден");
        }
    }

    public double getTotalCostOfAllCalls() {
        double total = 0;
        for (ClientATC clientATC : clients.values()) {
            total += clientATC.calculateTotalCost();
        }
        return total;
    }

    public double getTotalCostForClient(String lastName) {
        ClientATC clientATC = clients.get(lastName);
        if (clientATC != null) {
            return clientATC.calculateTotalCost();
        } else {
            System.out.println("Клиент с фамилией " + lastName + " не найден");
            return 0;
        }
    }
}
public class DoubleLinkedList {
    public static void main(String[] args) {
        ATC atc = new ATC();

        atc.addTariff(new Tariff("Москва", 10.0));
        atc.addTariff(new Tariff("Курск", 14.0));
        atc.addTariff(new Tariff("Анталья", 30.0));

        ClientATC clientATC1 = new ClientATC("Токмаков");
        ClientATC clientATC2 = new ClientATC("Тушков");
        ClientATC clientATC3 = new ClientATC("Левченко");
        atc.addClient(clientATC1);
        atc.addClient(clientATC2);
        atc.addClient(clientATC3);

        atc.registerCall("Токмаков", "Москва", 30);
        atc.registerCall("Тушков", "Курск", 25);
        atc.registerCall("Токмаков", "Москва", 18);
        atc.registerCall("Тушков", "Курск", 22);
        atc.registerCall("Тушков", "Анталья", 11);
        atc.registerCall("Левченко", "Анталья", 12);
        atc.registerCall("Левченко", "Анталья", 2);

        // Выводим стоимость звонков для каждого клиента
        System.out.println("Общая стоимость звонков Токмакова: " + atc.getTotalCostForClient("Токмаков"));
        System.out.println("Общая стоимость звонков Тушкова: " + atc.getTotalCostForClient("Тушков"));
        System.out.println("Общая стоимость звонков Левченко: " + atc.getTotalCostForClient("Левченко"));

        // Выводим общую стоимость всех звонков
        System.out.println("Общая стоимость всех звонков на АТС: " + atc.getTotalCostOfAllCalls());
    }
}


