package com.example.threefatftw;

public class FatJarLauncher {

    // Shade, Assembly, and other plugins mess with the jar structure and ... threads?
    // and i dont fully understand it but we require this little shim
    // https://stackoverflow.com/questions/52653836/maven-shade-javafx-runtime-components-are-missing
    // this can be reworked once you move to modules.
    // more reading here:
    // https://edencoding.com/runtime-components-error/

    public static void main(String...args) {
        HelloApplication.main(args);
    }

}