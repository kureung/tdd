package io.github.kureung.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int height() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(br.readLine());
    }

    public String[] names() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return br.readLine()
                .split(",");
    }

    public String[] results() throws IOException {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return br.readLine()
                .split(",");
    }

    public String name() throws IOException {
        return br.readLine();
    }


}
