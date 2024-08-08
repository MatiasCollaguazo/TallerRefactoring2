package ec.edu.espol.tallerrefactoring2;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SistemaAtencionMedico {
    private static final double DESCUENTO_ADULTOS_MAYORES = 0.25;
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<ServicioMedico> serviciosMedicos;

    public SistemaAtencionMedico() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.serviciosMedicos = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void agregarServicioMedico(ServicioMedico servicioMedico) {
        serviciosMedicos.add(servicioMedico);
    }

    public void agendarConsulta(Consulta consulta){
        double costoConsulta = consulta.getServicioMedico().getCosto();
        int edadPaciente = consulta.getPaciente().getEdad();
        costoConsulta = calcularValorFinalConsulta(costoConsulta,edadPaciente);
        System.out.println("Se han cobrado "+ costoConsulta+ " dolares de su tarjeta de credito");
        consulta.getPaciente().getHistorialMedico().addConsulta(consulta);
    }

    public double calcularValorFinalConsulta(double costoConsulta, int edadPaciente){
        double valorARestar = 0;
        if(edadPaciente>=Paciente.ADULTO_MAYOR_EDAD){
            valorARestar = costoConsulta*DESCUENTO_ADULTOS_MAYORES; //0.25 es el descuento para adultos mayores
        }
        return costoConsulta-valorARestar;
    }

    // se puede parametrizar (obtener...)
    private <T> T obtenerPorNombre(List<T> lista, Predicate<T> predicado) {
        for (T elemento : lista) {
            if (predicado.test(elemento)) {
                return elemento;
            }
        }
        return null;
    }

    public Paciente obtenerPaciente(String nombrePaciente) {
        return obtenerPorNombre(pacientes, paciente -> paciente.getNombre().equals(nombrePaciente));
    }

    public ServicioMedico obtenerServicioMedico(String nombreServicio) {
        return obtenerPorNombre(serviciosMedicos, servicio -> servicio.getNombre().equals(nombreServicio));
    }

    public Medico obtenerMedico(String nombreMedico) {
        return obtenerPorNombre(medicos, medico -> medico.getNombre().equals(nombreMedico));
    }
}
