package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConsultaJaCancelada implements ValidadorCancelamentoDeConsulta {
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());
        var motivo = consulta.getMotivoCancelamento();
        if (motivo != null) {
            throw new ValidacaoException("Essa consulta já foi cancelada! Motivo: " + motivo);
        }
    }
}
