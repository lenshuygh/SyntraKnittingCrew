package be.lens.syntra.spring.knittingcrewhomepage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Stitches {
    GARTER("Garter"),
    STOCKINETTE("Stockinette"),
    RIB("Rib"),
    SEED("Seed"),
    BEGINNER_LACE("Beginner lace"),
    CABLE("Cable");

    private String stitchName;
}
