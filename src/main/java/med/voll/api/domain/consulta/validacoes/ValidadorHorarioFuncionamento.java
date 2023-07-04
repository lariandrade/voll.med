package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;
import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamentoDeConsulta {

    //O horário de funcionamento da clínica é de segunda a sábado, das 07:00 às 19:00;

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisEncerramentoClinica = dataConsulta.getHour() > 18;

        if(domingo || antesAberturaDaClinica || depoisEncerramentoClinica) {
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica.");
        }
    }
}
