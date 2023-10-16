package controller;

import service.LottoService;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void run() {
        lottoService.winningResult();
        double result = lottoService.printStatistics();
        lottoService.rateOfReturn(result);
    }

}
