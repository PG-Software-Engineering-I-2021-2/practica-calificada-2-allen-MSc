public class Administrativo extends Employee {
    private int salarioBaseMensual =2000;
    private int bonus = 100;

    Administrativo(String nombre) {
        super(nombre);
    }

    int sueldo() {
        return salarioBaseMensual + bonus;
    }
}
