package io.github.kureung;

import io.github.kureung.domain.*;
import io.github.kureung.random.RandomBooleans;
import io.github.kureung.view.ConsoleInputView;
import io.github.kureung.view.ConsoleOutputView;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Game(ConsoleInputView consoleInputView, ConsoleOutputView consoleOutputView) {
    public void run() throws IOException {
        final Ladder ladder = ladder();
        final String name = consoleInputView.name();
        consoleOutputView.print(ladder.result(name));
    }

    private Ladder ladder() throws IOException {
        final int height = consoleInputView.height();
        final Participants participants = new Participants(consoleInputView.names());
        final Lines lines = new Lines(lines(height, participants));
        final Results results = new Results(consoleInputView.results());
        return new Ladder(participants, lines, results);
    }

    private List<Line> lines(int height, Participants participants) {
        final RandomBooleans randomBooleans = new RandomBooleans(participants.size());
        return IntStream.range(0, height)
                .mapToObj(index -> new Line(randomBooleans.randomBooleans()))
                .collect(Collectors.toList());
    }


}
