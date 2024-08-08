package ec.edu.espol.tallerrefactoring2;
import java.util.ArrayList;
import java.util.List;

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
        consulta.getPaciente().getHistorialMedico().addConsulta(consulta); //Hacer esto es incorrecto
    }

    public double calcularValorFinalConsulta(double costoConsulta, int edadPaciente){
        double valorARestar = 0;
        if(edadPaciente>=Paciente.ADULTO_MAYOR_EDAD){
            valorARestar = costoConsulta*DESCUENTO_ADULTOS_MAYORES; //0.25 es el descuento para adultos mayores
        }
        return costoConsulta-valorARestar;
    }

    // se puede parametrizar (obtener...)
    public Paciente obtenerPaciente(String nombrePaciente) {
        for(Paciente paciente : pacientes){
            if (paciente.getNombre().equals(nombrePaciente))
                return paciente;
        }
        return null;
    }

    public ServicioMedico obtenerServicioMedico(String nombreServicio) {
        for(ServicioMedico servicioMedico : serviciosMedicos){
            if (servicioMedico.getNombre().equals(nombreServicio))
                return servicioMedico;
        }
        return null;
    }

    public Medico obtenerMedico(String nombreMedico) {
        for(Medico medico : medicos){
            if (medico.getNombre().equals(nombreMedico))
                return medico;
        }
        return null;
    }
}
