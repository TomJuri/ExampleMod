package de.tomjuri.examplemod;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Text;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class ExampleModConfig extends Config {

    public ExampleModConfig() {
        super(new Mod("examplemod", ModType.UTIL_QOL), "examplemod.json");
        initialize();
    }

    @Text(name = "Just some example text")
    public static final String exampleText = "Hello World!";
}
