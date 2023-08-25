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
        DadosData dadosData = new DadosData(LocalDate.of(1993, Month.JANUARY, 1));
        
        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "NBA", "Michael Jordan", "ala");
        Time time = new Time(1L, LocalDate.of(1993, Month.JANUARY, 1));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);
        //Mocka
        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();
        //Executa
        List<String> resultado = apiService.timeDaData(dadosData);
        System.out.println(resultado);
        //Compara
        List<String> esperado = new ArrayList<>();
        esperado.add("Michael Jordan");

        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void integranteMaisUsado(){
        DadosDatas dadosDatas = new DadosDatas(LocalDate.of(1993, Month.JANUARY, 1),
                LocalDate.of(1995, Month.JANUARY, 1));

        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "NBA", "Michael Jordan", "ala");
        Time time = new Time(1L, LocalDate.of(1994, Month.AUGUST, 23));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();

        String resultado = apiService.integranteMaisUsado(dadosDatas);
        System.out.println(resultado);

        Assert.assertEquals("Michael Jordan", resultado);
    }

    @Test
    public void timeMaisComum(){
        DadosDatas dadosDatas = new DadosDatas(LocalDate.of(1993, Month.JANUARY, 1),
                LocalDate.of(1995, Month.JANUARY, 1));

        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "NBA", "Michael Jordan", "ala");
        Time time = new Time(1L, LocalDate.of(1994, Month.AUGUST, 23));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();

        List<String> resultado = apiService.timeMaisComum(dadosDatas);
        System.out.println(resultado);

        List<String> esperado = new ArrayList<>();
        esperado.add("Michael Jordan");

        Assert.assertEquals(esperado, resultado);


    }

    @Test
    public void funcaoMaisComum(){
        DadosDatas dadosDatas = new DadosDatas(LocalDate.of(1993, Month.JANUARY, 1),
                LocalDate.of(1995, Month.JANUARY, 1));

        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "NBA", "Michael Jordan", "ala");
        Time time = new Time(1L, LocalDate.of(1994, Month.AUGUST, 23));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();

        String resultado = apiService.funcaoMaisComum(dadosDatas);
        System.out.println(resultado);

        Assert.assertEquals("ala", resultado);

    }

    @Test
    public void franquiaMaisFamosa(){
        DadosDatas dadosDatas = new DadosDatas(LocalDate.of(1993, Month.JANUARY, 1),
                LocalDate.of(1995, Month.JANUARY, 1));

        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "NBA", "Michael Jordan", "ala");
        Time time = new Time(1L, LocalDate.of(1994, Month.AUGUST, 23));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();

        String resultado = apiService.franquiaMaisFamosa(dadosDatas);
        System.out.println(resultado);

        Assert.assertEquals("NBA", resultado);

    }

    @Test
    public void contagemPorFranquia(){
        DadosDatas dadosDatas = new DadosDatas(LocalDate.of(1993, Month.JANUARY, 1),
                LocalDate.of(1995, Month.JANUARY, 1));

        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "NBA", "Michael Jordan", "ala");
        Time time = new Time(1L, LocalDate.of(1994, Month.AUGUST, 23));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);


        Integrante integrante1 = new Integrante(1L, "NBA", "Michael Jordan", "ala");
        Time time1 = new Time(1L, LocalDate.of(1994, Month.AUGUST, 23));
        ComposicaoTime composicaoTime1 = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();

        Map<String, Integer> resultado = apiService.contagemPorFranquia(dadosDatas);
        System.out.println(resultado);

        Assert.assertEquals(2, resultado.get("NBA").intValue());

    }



    @Test
    public void contagemPorFuncao(){
        DadosDatas dadosDatas = new DadosDatas(LocalDate.of(1993, Month.JANUARY, 1),
                LocalDate.of(1995, Month.JANUARY, 1));

        List<ComposicaoTime> composicaoTimeList = new ArrayList<>();
        Integrante integrante = new Integrante(1L, "NBA", "Michael Jordan", "ala");
        Time time = new Time(1L, LocalDate.of(1994, Month.AUGUST, 23));
        ComposicaoTime composicaoTime = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Integrante integrante1 = new Integrante(1L, "NBA", "Michael Jordan", "ala");
        Time time1 = new Time(1L, LocalDate.of(1994, Month.AUGUST, 23));
        ComposicaoTime composicaoTime1 = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Integrante integrante2 = new Integrante(1L, "NBA", "Michael Jordan", "ala");
        Time time2 = new Time(1L, LocalDate.of(1994, Month.AUGUST, 23));
        ComposicaoTime composicaoTime2 = new ComposicaoTime(1L, time, integrante);
        composicaoTimeList.add(composicaoTime);

        Mockito.doReturn(composicaoTimeList).when(apiService).buscarComposicao();

        Map<String, Integer> resultado = apiService.contagemPorFuncao(dadosDatas);
        System.out.println(resultado);

        Assert.assertEquals(3, resultado.get("ala").intValue());

    }
        
    
    
}
