package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();

        // Çalışanları ekliyoruz (bazıları tekrar ediyor)
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null); // Null değeri de var

        // Test etmek isteyenler için çıktı
        System.out.println("Tekrar Edenler:");
        List<Employee> duplicates = findDuplicates(employees);
        duplicates.forEach(System.out::println);

        System.out.println("\nTekrar Edenlerden Birer Tane + Tekil Olanlar:");
        Map<Integer, Employee> uniques = findUniques(employees);
        uniques.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\nSadece Tek Geçenler:");
        List<Employee> singleOccur = removeDuplicates(employees);
        singleOccur.forEach(System.out::println);
    }

    // ✅ 1. TEKRAR EDENLERİ BUL (Sıralı)
    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicates = new LinkedHashSet<>(); // sıralama korunsun

        for (Employee emp : employees) {
            if (emp == null) continue;
            if (!seen.add(emp)) {
                duplicates.add(emp);
            }
        }

        return new LinkedList<>(duplicates);
    }

    // ✅ 2. TEKRAR EDENLERDEN BİRER TANE + TEK GEÇENLER
    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();         // id -> kaç kez geçti
        Map<Integer, Employee> uniqueMap = new LinkedHashMap<>(); // id -> Employee (sıralı)

        for (Employee emp : employees) {
            if (emp == null) continue;

            int id = emp.getId();
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);

            if (!uniqueMap.containsKey(id)) {
                uniqueMap.put(id, emp);
            }
        }

        // Test için sadece uniqueMap'i dönüyoruz, çünkü her id'den sadece bir tane var
        return uniqueMap;
    }

    // ✅ 3. SADECE TEK GEÇENLERİ AL
    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Employee, Integer> frequencyMap = new HashMap<>();

        for (Employee emp : employees) {
            if (emp == null) continue;
            frequencyMap.put(emp, frequencyMap.getOrDefault(emp, 0) + 1);
        }

        List<Employee> result = new LinkedList<>();
        for (Map.Entry<Employee, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
