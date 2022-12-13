package pairmatching.controller;

import pairmatching.domain.Crews;
import pairmatching.domain.MenuCommand;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatcher;
import pairmatching.domain.Pairs;
import pairmatching.domain.SearchingInfoDto;
import pairmatching.domain.YesNoCommand;
import pairmatching.util.InvalidPairException;
import pairmatching.util.UnableToMatchException;
import pairmatching.util.UnableToSearchPairException;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {


    private final InputView inputview;
    private final OutputView outputView;
    private final Crews crews = new Crews();
    private Pairs pairs = new Pairs();

    public PairController(InputView inputview, OutputView outputView){
        this.inputview = inputview;
        this.outputView = outputView;
    }

    public void executePairCommand(MenuCommand menuCommand){
        if(menuCommand.equals(MenuCommand.PAIR_MATCHING)){
            executePairMatching();
        }
        if(menuCommand.equals(MenuCommand.PAIR_SEARCHING)){
            executePairSearching();
        }
        if(menuCommand.equals(MenuCommand.PAIR_INITIALIZE)){
            executePairReset();
        }
    }

    private void executePairMatching(){
        outputView.printWholeCourseMissions();
        SearchingInfoDto searchingInfoDto = readValidSearchingInfoDto();
        PairMatcher pairMatcher = new PairMatcher(crews.getNamesByCourse(searchingInfoDto.getCourse()));
        try{
            matchPair(searchingInfoDto, pairMatcher);
        } catch(UnableToMatchException error){
            outputView.printErrorMessage(error.getMessage());
        }
        outputView.printMatchingResult(pairs.getPrintablePair(searchingInfoDto));
    }

    private void matchPair(SearchingInfoDto searchingInfoDto, PairMatcher pairMatcher){
        while(true){
            try{
                pairs.addPair(searchingInfoDto, new Pair(searchingInfoDto, crews, pairMatcher.match()));
                break;
            } catch (InvalidPairException error){
                outputView.printErrorMessage(error.getMessage());
            }
        }
    }

    private SearchingInfoDto readValidSearchingInfoDto(){
        while(true){
            SearchingInfoDto searchingInfoDto = inputview.readSearchingInformation();
            YesNoCommand command = YesNoCommand.YES;
            if(pairs.isExistedPair(searchingInfoDto)){
                command = inputview.readRematchOrNot();
            }
            if(YesNoCommand.YES.equals(command)){
                return searchingInfoDto;
            };
        }
    }

    private void executePairSearching(){
        outputView.printWholeCourseMissions();
        SearchingInfoDto searchingInfoDto = readSearchableInfoDto();
        outputView.printMatchingResult(pairs.getPrintablePair(searchingInfoDto));
    }

    private SearchingInfoDto readSearchableInfoDto(){
        while(true) {
            SearchingInfoDto searchingInfoDto = inputview.readSearchingInformation();
            try{
                pairs.validateSearchablePairInfo(searchingInfoDto);
                return searchingInfoDto;
            } catch (UnableToSearchPairException error) {
                outputView.printErrorMessage(error.getMessage());
            }
        }
    }

    private void executePairReset() {
        pairs = new Pairs();
        outputView.printPairsResetMessage();
    }
}
