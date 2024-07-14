package kimsmileGames.service.impl;

import kimsmileGames.model.Member;
import kimsmileGames.service.GameStartService;
import kimsmileGames.service.MemberService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static kimsmileGames.util.EscapeUtil.escapeT;

public class MemberServiceImpl implements MemberService {

    Scanner sc;

    Member member = Member.getInstance();
    List<Member> members = new ArrayList<>();

    GameStartService gameStartService = new GameStartServiceImpl();

    @Override
    public void login() {
        String id = checkId();
        String pw = checkPw();

        if (members.size() != 0) {
            for (int i = 0 ; i < members.size() ; i++ ) {
                if (members.get(i).getId().equals(id) && members.get(i).getPassword().equals(pw)) {
                    System.out.println();
                    System.out.println(escapeT(25) + "***환영합니다***" + escapeT(10));
                    System.out.println();
                    gameStartService.goHomeTown(member);
                } else {
                    System.out.println();
                    System.out.println(escapeT(25) + "아이디 또는 비밀번호가 맞지 않습니다." + escapeT(10));
                    System.out.println();
                }
            }
        } else {
            System.out.println();
            System.out.println(escapeT(22) + "회원이 존재하지 않습니다." + escapeT(10));
            System.out.println();
        }

    }

    @Override
    public void join() throws IOException, InterruptedException {
        member = new Member(
                checkId(),
                checkPw(),
                checkNick(),
                checkGender() == 1
        );
        members.add(member);
        login();
    }


    private String checkId() {
        sc = new Scanner(System.in);
        while (true) {
            System.out.println(escapeT(22) + "아이디를 입력해주세요.(5~9글자 및 영어와 숫자만 입력 가능)" + escapeT(10));
            System.out.print(escapeT(22) + "ID : ");
            String id = sc.nextLine();

            if (!id.matches("^[a-zA-Z0-9]{5,9}$")) {
                System.out.println();
                System.out.println(escapeT(22) + "\u001B[31m"  + "5~9글자 이내로 입력이 가능하며, 영어와 숫자만 입력 가능합니다."  + "\u001B[0m" + escapeT(10));
                System.out.println();
                continue;
            }

            return id;
        }
    }

    private String checkPw() {
        sc = new Scanner(System.in);
        while (true) {
            System.out.println(escapeT(22) + "비밀번호를 입력해주세요.(영어,숫자,특수문자가 포함되어야 하고 4글자 이상이어야 합니다.)" + escapeT(10));
            System.out.print(escapeT(22) + "PASSWORD : ");

            String password = sc.nextLine();

            if (!password.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{4,}$")) {
                System.out.println();
                System.out.println(escapeT(22) + "\u001B[31m"  + "영어,숫자,특수문자가 포함되어야 하고 4글자 이상이어야 합니다."  + "\u001B[0m" + escapeT(10));
                System.out.println();
                continue;
            }

            return password;
        }
    }

    private String checkNick() {
        sc = new Scanner(System.in);
        while (true) {
            System.out.println(escapeT(22) + "닉네임을 입력해주세요." + escapeT(10));
            System.out.print(escapeT(22) + "NICKNAME : ");

            String nickName = sc.nextLine();

//            if (!password.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{4,}$")) {
//                System.out.println();
//                System.out.println(escapeT(22) + "\u001B[31m"  + "영어,숫자,특수문자가 포함되어야 하고 4글자 이상이어야 합니다."  + "\u001B[0m" + escapeT(10));
//                System.out.println();
//                continue;
//            }

            return nickName;
        }
    }

    private int checkGender() {
        sc = new Scanner(System.in);
        while (true) {
            System.out.println(escapeT(22) + "성별을 선택해주세요." + escapeT(10));
            System.out.print(escapeT(22) + "1.남자 | 2.여자 :");
            int gender = 0;
            try {
                gender = sc.nextInt();
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(escapeT(22) + "\u001B[31m"  + "정수를 입력해주세요."  + "\u001B[0m" + escapeT(10));
                continue;
            }

            if (!String.valueOf(gender).matches("^[12]$")) {
                System.out.println();
                System.out.println(escapeT(22) + "\u001B[31m"  + "1 또는 2번을 선택해주세요."  + "\u001B[0m" + escapeT(10));
                System.out.println();
                continue;
            }

            return gender;
        }
    }
}
