package com.codeassigement.enu;

public enum LightColor {
    RED {
        public LightColor next() { return GREEN; }
    },
    GREEN {
        public LightColor next() { return YELLOW; }
    },
    YELLOW {
        public LightColor next() { return RED; }
    };

    public abstract LightColor next();
}


