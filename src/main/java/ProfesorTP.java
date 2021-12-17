public class ProfesorTP extends Employee {
    private int salarioBaseMensual =2000;

    ProfesorTP(String nombre) {
        super(nombre);
    }

    int sueldo() {
        return salarioBaseMensual;
    }
}
