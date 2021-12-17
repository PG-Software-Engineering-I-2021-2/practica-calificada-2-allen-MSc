public class ProfesorTP extends Employee {
    private int _salarioBaseMensual =2000;

    ProfesorTP(String nombre) {
        super(nombre);
    }

    int Sueldo() {
        return _salarioBaseMensual;
    }
}
