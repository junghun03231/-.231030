package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    void run() {
        List<Member> memberList = new ArrayList<>();
        List<Article> articleList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Member loginMember = null;
        int lastId = 1;

        Member member1 = new Member("user", "1");
        memberList.add(member1);

        ArticleController articleController = new ArticleController();
        MemberController memberController = new MemberController();

        while (true) {
            System.out.print("명령어: ");
            String command = sc.nextLine();

            if (command.equals("종료")) {
                articleController.exit();
                break;

            } else if (command.equals("회원가입")) {
                memberController.join();

            } else if (command.equals("로그인")) {
                memberController.login();

            } else if (command.equals("로그아웃")) {
                memberController.logout();

            } else if (command.equals("등록")) {
                articleController.write();

            } else if (command.equals("목록")) {
                articleController.list();

            } else if (command.equals("삭제")) {
                articleController.remove();

            } else if (command.equals("수정")) {
                articleController.modify();

            }
        }

    }
}
