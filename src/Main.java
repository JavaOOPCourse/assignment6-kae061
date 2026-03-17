import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        students.put("S1", new Student("Adelya", 3.5, 18));
        students.put("S2", new Student("Asya", 3.2, 17));
        students.put("S3", new Student("Rahat", 4.0, 19));
        students.put("S4", new Student("Ayana",3.3, 20 ));
        students.put("S5", new Student("Zara", 4.0, 17));

        // TODO: Напечатай всех студентов (ID + объект)
        System.out.println("ALL STUDENTS");
        // TODO: Найди студента по ID и выведи его
        for (String id : students.keySet()) {
            System.out.println(id + " - " + students.get(id));
        }
        System.out.println(students.get("S3"));

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, List<String>> gpaMap = new HashMap<>();

        for (Student s : students.values()) {
            gpaMap.putIfAbsent(s.getGpa(), new ArrayList<>());
            gpaMap.get(s.getGpa()).add(s.getName());
        }

        for (Double gpa : gpaMap.keySet()) {
            if (gpaMap.get(gpa).size() > 1) {
                System.out.println("GPA " + gpa + " - " + gpaMap.get(gpa));
            }
        }

        // TODO: Удали одного студента по ID
        students.remove("S5");
        // TODO: Обнови GPA у одного студента
        students.get("S1").setGpa(3.9);

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        ArrayList<Student> list = new ArrayList<>(students.values());
        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        Collections.sort(list);
        System.out.println("SORT BY GPA");
        for (Student s : list) {
            System.out.println(s);
        }
        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        list.sort(Comparator.comparing(Student::getName));
        System.out.println("SORT BY NAME");
        for (Student s : list) {
            System.out.println(s);
        }
        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        ArrayList<Student> topList = new ArrayList<>(students.values());
        topList.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));

        for (int i = 0; i < Math.min(3, topList.size()); i++) {
            System.out.println(topList.get(i));
        }

        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        Course math = new Course("Math");
        Course cs = new Course("CS");

        courseMap.put(math, new ArrayList<>());
        courseMap.put(cs, new ArrayList<>());

        courseMap.get(math). add(students.get("S1"));
        courseMap.get(math).add(students.get("S2"));

        courseMap.get(cs).add(students.get("S3"));
        courseMap.get(cs).add(students.get("S4"));

        for (Course c : courseMap.keySet()) {
            System.out.println(c);
            for (Student s : courseMap.get(c)) {
                System.out.println(" " + s);
            }
        }
        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        ArrayList<Student> complexSort = new ArrayList<>(students.values());

        complexSort.sort((s1, s2) -> {
            int result = Double.compare(s2.getGpa(), s1.getGpa());
            if (result == 0) {
                return s1.getName().compareTo(s2.getName());
            }
            return result;
        });
        for (Student s : complexSort) {
            System.out.println(s);
        }
    }
}



