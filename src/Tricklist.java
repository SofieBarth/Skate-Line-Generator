public class Tricklist {
    SkateTrick rockToFakie = new SkateTrick("rockToFakie", Direction.REGULAR, Direction.FAKIE, Level.BASIC, false);
    SkateTrick bsFeebleToFakie = new SkateTrick("bsFeebleToFakie", Direction.REGULAR, Direction.FAKIE, Level.INTERMEDIATE, false);
    SkateTrick halfCapRockToFakie = new SkateTrick("HalfCapRockToFakie", Direction.FAKIE, Direction.FAKIE, Level.BASIC, false);
    SkateTrick tailTap = new SkateTrick("tailTap", Direction.FAKIE, Direction.REGULAR, Level.BASIC, false);
    SkateTrick axleStall = new SkateTrick("axleStall", Direction.REGULAR, Direction.REGULAR, Level.BASIC, false);
    SkateTrick bsFeeble = new SkateTrick("bsFeeble", Direction.REGULAR, Direction.REGULAR, Level.BASIC, false);
    SkateTrick fsFeeble = new SkateTrick("fsFeeble", Direction.REGULAR, Direction.REGULAR, Level.BASIC, false);
    SkateTrick rocknRoll = new SkateTrick("rocknRoll", Direction.REGULAR, Direction.REGULAR, Level.BASIC, false);
    SkateTrick bsFiftyFifty = new SkateTrick("bsFiftyFifty", Direction.REGULAR, Direction.REGULAR, Level.BASIC, false);
    SkateTrick fsFiftyFifty = new SkateTrick("fsFiftyFifty", Direction.REGULAR, Direction.REGULAR, Level.INTERMEDIATE, false);
    SkateTrick fsSmithGrind = new SkateTrick("fsSmithGrind", Direction.REGULAR, Direction.REGULAR, Level.INTERMEDIATE, false);
    SkateTrick fsSmithStall = new SkateTrick("fsSmithStall", Direction.REGULAR, Direction.REGULAR, Level.BASIC, false);
    SkateTrick fsFiveO = new SkateTrick("fsFiveO", Direction.REGULAR, Direction.REGULAR, Level.INTERMEDIATE, false);
    SkateTrick boardSlide = new SkateTrick("boardslide", Direction.REGULAR, Direction.FAKIE, Level.INTERMEDIATE, false);
    SkateTrick fakieAxleStall = new SkateTrick("fakieAxleStall", Direction.FAKIE, Direction.REGULAR, Level.BASIC, false);
    SkateTrick fakieSmithStall = new SkateTrick("fakieSmithStall", Direction.FAKIE, Direction.REGULAR, Level.BASIC, false);
    SkateTrick fakieSmithGrind = new SkateTrick("fakieSmithGrind", Direction.FAKIE, Direction.REGULAR, Level.INTERMEDIATE, false);
    SkateTrick twoSeventyFeeble = new SkateTrick("twoSeventyFeeble", Direction.FAKIE, Direction.REGULAR, Level.INTERMEDIATE, false);
    SkateTrick twoSeventyFeebletoFakie = new SkateTrick("twoSeventyFeebleToFakie", Direction.FAKIE, Direction.FAKIE, Level.ADVANCED, false);
    SkateTrick rocknRollBoardSlide = new SkateTrick("rocknRollBoardSlide", Direction.REGULAR, Direction.REGULAR, Level.INTERMEDIATE, false);

    SkateTrick[] tricklisteAll = {rockToFakie, bsFeeble, halfCapRockToFakie, tailTap, axleStall, rocknRoll, bsFiftyFifty, fsFiftyFifty, fsSmithGrind, fsFiveO, boardSlide, fakieAxleStall, fakieSmithStall, fakieSmithGrind, twoSeventyFeeble, twoSeventyFeebletoFakie, rocknRollBoardSlide};
    SkateTrick[] beginnerTricks = {rockToFakie, bsFeeble, bsFiftyFifty, halfCapRockToFakie, axleStall, rocknRoll, fakieAxleStall, fakieSmithStall, fsSmithStall, tailTap};
    SkateTrick[] intermediateTricks = {fsFiftyFifty, bsFeebleToFakie, fsFeeble, fsSmithGrind, fsFiveO, boardSlide, twoSeventyFeeble,fakieSmithGrind, rocknRollBoardSlide};
}

