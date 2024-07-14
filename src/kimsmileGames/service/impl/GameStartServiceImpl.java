package kimsmileGames.service.impl;

import kimsmileGames.model.Member;
import kimsmileGames.service.GameStartService;

import java.util.Scanner;

import static kimsmileGames.util.EscapeUtil.escapeT;

public class GameStartServiceImpl implements GameStartService {


    Scanner sc;

    Member member = Member.getInstance();

    @Override
    public void goHomeTown(Member member) {
        System.out.println();
        System.out.println(escapeT(25) + "신규 혜택 초보자 지원 상자를 받았습니다." + escapeT(10));
        System.out.println();

        System.out.println(escapeT(25) + "    _______\n" +
                escapeT(25) + "  /       /|\n" +
                escapeT(25) + " /_______/ |\n" +
                escapeT(25) + " |       | |\n" +
                escapeT(25) + " |       | /\n" +
                escapeT(25) + " |_______|/" + escapeT(10));
        System.out.println(escapeT(25) + "상자를 개봉하시겠습니까?" + escapeT(10));
    }
}
