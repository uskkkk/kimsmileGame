package kimsmileGames.service.impl;

import kimsmileGames.service.*;

import java.util.Scanner;

import static kimsmileGames.util.EscapeUtil.escapeT;

public class MainServiceImpl implements MainService {

    StringBuilder showText = new StringBuilder();

    @Override
    public void showMain() {

        try {
            showText.append(escapeT(20)+"======================================="+escapeT(20)+"\n");
            showText.append(escapeT(20)+"  환      영       합       니       다"+escapeT(20)+"\n");
            showText.append(escapeT(20)+"======================================="+escapeT(20)+"\n");

            System.out.println(showText);
        } catch (Exception e) {
            showText.append(escapeT(20)+"======================================"+escapeT(20)+"\n");
            showText.append(escapeT(20)+"  오     류     발      생      !!!!!!!"+escapeT(20)+"\n");
            showText.append(escapeT(20)+"======================================"+escapeT(20)+"\n");

            System.out.println(showText);
        }
        showText.delete(0,showText.length());
    }

    @Override
    public void insertView() {

        showText.append(escapeT(20)+"      원하시는 메뉴를 선택해주세요.      "+escapeT(20)+"\n");

        System.out.println(showText);

        showText.delete(0,showText.length());
    }

    @Override
    public int selectMenuView() {
        showMenu();

        Scanner sc = new Scanner(System.in);
        int selectNum = 1;
        try {
            selectNum = sc.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectNum;
    }

    void showMenu() {

        showText.append(escapeT(22)+"┏━━━━━━━━━━━━━━━━━┓"+escapeT(10)+"\n");
        showText.append(escapeT(22)+"  1 .   로그인     "+escapeT(10)+"\n");
        showText.append(escapeT(22)+"  2 .  회원가입    "+escapeT(10)+"\n");
        showText.append(escapeT(22)+"  3 .    랭킹      "+escapeT(10)+"\n");
        showText.append(escapeT(22)+"  4 .    상점      "+escapeT(10)+"\n");
        showText.append(escapeT(22)+"  5 .  커뮤니티    "+escapeT(10)+"\n");
        showText.append(escapeT(22)+"┗━━━━━━━━━━━━━━━━━┛"+escapeT(10)+"\n");

        System.out.println(showText);

        showText.delete(0,showText.length());
    }
}

