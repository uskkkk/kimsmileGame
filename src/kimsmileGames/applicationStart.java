package kimsmileGames;

import kimsmileGames.model.Member;
import kimsmileGames.service.GameStartService;
import kimsmileGames.service.MainService;
import kimsmileGames.service.MemberService;
import kimsmileGames.service.impl.GameStartServiceImpl;
import kimsmileGames.service.impl.MainServiceImpl;
import kimsmileGames.service.impl.MemberServiceImpl;

public class applicationStart {


    public static void main(String[] args) throws Exception{
        Member member = Member.getInstance();
        MainService mainService = new MainServiceImpl();
        GameStartService gameStartService = new GameStartServiceImpl();
        MemberService memberService = new MemberServiceImpl();


        mainService.showMain();
        Thread.sleep(1000);
        mainService.insertView();

        while (true) {
            try {
                int selectNum = mainService.selectMenuView();

                switch (selectNum) {
                    case 1:
                        memberService.login();
                        break;
                    case 2:
                        memberService.join();
                        break;
                    case 3:
                        System.out.println("3");
                        break;
                    case 4:
                        System.out.println("4");
                        break;
                    case 5:
                        System.out.println("5");
                        break;
                    default:
                        System.out.println("메뉴에 없는 번호입니다. 다시 입력해주세요.");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }

        }
    }
}
