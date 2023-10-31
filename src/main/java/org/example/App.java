package org.example;

import article.controller.ArticleController;
import member.entity.Member;
import member.controller.MemberController;

import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    Member loginMember = null;

    void run() {
        ArticleController articleController = new ArticleController();
        MemberController memberController = new MemberController();
        SystemController systemController = new SystemController();

        while (true) {
            System.out.print("명령어: ");
            String command = sc.nextLine();

            switch (command) {
                case "종료":
                    systemController.exit();
                    return;

                case "회원가입":
                    memberController.join();
                    break;

                case "로그인":
                    memberController.login();
                    break;

                case "로그아웃":
                    memberController.logout();
                    break;

                case "등록":
                    articleController.write();
                    break;

                case "목록":
                    articleController.list();
                    break;

                case "삭제":
                    articleController.remove();
                    break;

                case "수정":
                    articleController.modify();
                    break;

            }
        }
    }
}
