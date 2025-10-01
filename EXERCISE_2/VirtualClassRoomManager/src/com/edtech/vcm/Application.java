package com.edtech.vcm;

import com.edtech.vcm.controller.CLIController;

public class Application {
    public static void main(String[] args) {
        CLIController controller = new CLIController();
        controller.start();
    }
}
