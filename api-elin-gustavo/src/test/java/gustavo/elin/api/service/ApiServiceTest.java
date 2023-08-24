package gustavo.elin.api.service;

import gustavo.elin.api.dto.DadosData;
import gustavo.elin.api.dto.DadosDatas;
import gustavo.elin.api.model.ComposicaoTime;
import gustavo.elin.api.model.Integrante;
import gustavo.elin.api.model.Time;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class ApiServiceTest {
    
    @Spy
    private ApiService apiService;
    
    @BeforeEach
    public void setup() { MockitoAnnotations.openMocks(this); }// inicializa os mocks
    
    @Test
    public void timeDaData(){
        //Prepara os dados
        DadosData dadosData = new DadosData(LocalDate.of(2023, Month.AUGUST, 23));
        
        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "teste", "teste", "teste");
        Time time = new Time(1L, LocalDate.of(2023, Month.AUGUST, 23));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);
        //Mocka
        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();
        //Executa
        List<String> resultado = apiService.timeDaData(dadosData);
        System.out.println(resultado);
        //Compara (no primeiro parâmetro passa o resultado esperado e no segundo o que armazenou do retorno do método real)
        List<String> esperado = new ArrayList<>();
        esperado.add("teste");

        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void integranteMaisUsado(){
        DadosDatas dadosDatas = new DadosDatas(LocalDate.of(2023, Month.AUGUST, 12),
                LocalDate.of(2023, Month.AUGUST, 23));

        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "teste", "nome teste", "teste");
        Time time = new Time(1L, LocalDate.of(2023, Month.AUGUST, 23));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();

        String resultado = apiService.integranteMaisUsado(dadosDatas);
        System.out.println(resultado);

        Assert.assertEquals("nome teste", resultado);
    }

    @Test
    public void timeMaisComum(){
        DadosDatas dadosDatas = new DadosDatas(LocalDate.of(2023, Month.AUGUST, 12),
                LocalDate.of(2023, Month.AUGUST, 23));

        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "teste", "teste", "teste");
        Time time = new Time(1L, LocalDate.of(2023, Month.AUGUST, 23));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();

        List<String> resultado = apiService.timeMaisComum(dadosDatas);
        System.out.println(resultado);

        List<String> esperado = new ArrayList<>();
        esperado.add("teste");

        Assert.assertEquals(esperado, resultado);


    }

    @Test
    public void funcaoMaisComum(){
        DadosDatas dadosDatas = new DadosDatas(LocalDate.of(2023, Month.AUGUST, 12),
                LocalDate.of(2023, Month.AUGUST, 23));

        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "teste", "teste", "funcao teste");
        Time time = new Time(1L, LocalDate.of(2023, Month.AUGUST, 23));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();

        String resultado = apiService.funcaoMaisComum(dadosDatas);
        System.out.println(resultado);

        Assert.assertEquals("funcao teste", resultado);

    }

    @Test
    public void franquiaMaisFamosa(){
        DadosDatas dadosDatas = new DadosDatas(LocalDate.of(2023, Month.AUGUST, 12),
                LocalDate.of(2023, Month.AUGUST, 23));

        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "franquia teste", "teste", "teste");
        Time time = new Time(1L, LocalDate.of(2023, Month.AUGUST, 23));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();

        String resultado = apiService.franquiaMaisFamosa(dadosDatas);
        System.out.println(resultado);

        Assert.assertEquals("franquia teste", resultado);

    }

    @Test
    public void contagemPorFranquia(){

    }

    @Test
    public void contagemPorFuncao(){

    }
        
    
    
}
