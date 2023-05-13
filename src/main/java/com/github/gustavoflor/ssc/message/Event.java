package com.github.gustavoflor.ssc.message;

public record Event(String name, Long delay) {

    @Override
    public String toString() {
        return String.format("Event{name='%s',delay='%s'}", name, delay);
    }

}
