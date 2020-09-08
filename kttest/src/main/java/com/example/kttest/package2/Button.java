package com.example.kttest.package2;


import org.jetbrains.annotations.NotNull;

public class Button implements View {

    @NotNull
    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(@NotNull State state) {

    }
    public class ButtonState implements State{

    }
}
