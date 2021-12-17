import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Principal {
    private Map<Integer, List<Pair<Employee, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>( new ProfesorTC("Josefina"), true),
                            new Pair<>( new ProfesorTC("Edonisio"), true),
                            new Pair<>( new ProfesorTC("Edufasio"), false)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>( new ProfesorTC("Eduarda"), false),
                            new Pair<>( new ProfesorTC("Abelardo"), false),
                            new Pair<>( new ProfesorTC("Francisca"), false)
                    )
            )
    );
    private final int yearToCalculate;

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }

    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (examsStudents.isEmpty()) {
            return 0f;
        }

        int gradesWeightSum = getGradesWeightSum(examsStudents);
        if (gradesWeightSum == 100) {
            return gradesWithMinimumClasses(examsStudents, hasReachedMinimumClasses);
        } else if (gradesWeightSum > 100) {
            return -1f;
        } else {
            return -2f;
        }
    }

    private float gradesWithMinimumClasses(final List<Pair<Integer, Float>> examsStudents, boolean hasReachedMinimumClasses) {
        if (hasReachedMinimumClasses == false) {
            return 0f;
        }

        float gradesSum = getGradesSum(examsStudents);
        if (needToIncreaseOneExtraPoint()) {
            return Float.min(10f, gradesSum + 1);
        } else {
            return gradesSum;
        }
    }

    private boolean needToIncreaseOneExtraPoint() {
        boolean hasToIncreaseOneExtraPoint = false;

        for (Map.Entry<Integer, List<Pair<Employee, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if ((yearToCalculate != yearlyTeachers.getKey())) {
                continue;
            }

            List<Pair<Employee, Boolean>> teachers = yearlyTeachers.getValue();
            for (Pair<Employee, Boolean> teacher : teachers) {
                if (!teacher.second() && !teacher.getClass().getName().equals(ProfesorTC.class.getName())) {
                    continue;
                }
                hasToIncreaseOneExtraPoint = true;
            }
        }
        return hasToIncreaseOneExtraPoint;
    }

    private int getGradesWeightSum(final List<Pair<Integer, Float>> examsStudents) {
        int   gradesWeightSum = 0;

        for (Pair<Integer, Float> examGrade : examsStudents) {
            gradesWeightSum += examGrade.first();
        }

        return gradesWeightSum;
    }

    private float getGradesSum(final List<Pair<Integer, Float>> examsStudents) {
        float gradesSum = 0f;

        for (Pair<Integer, Float> examGrade : examsStudents) {
            gradesSum += (examGrade.first() * examGrade.second() / 100);
        }

        return gradesSum;
    }

    public void printExtraPointsTeachers(){
        for (List<Pair<Employee, Boolean>> teachers : this.allYearsTeachers.values()){
            for (Pair<Employee, Boolean> pair : teachers){
                if(pair.second()){
                    System.out.println(pair.first().name());
                }
            }
        }
    }

    public static void main(String[] args) {
        Principal instance = new Principal(2019);
        instance.printExtraPointsTeachers();
    }

    public void setTeacher(Map<Integer, List<Pair<Employee, Boolean>>> allYearsTeachers) {
        this.allYearsTeachers = allYearsTeachers;
    }
}
