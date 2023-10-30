package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. 수정 시 제목 입력이 안됩니다
// 2. Member는 매개변수가 있고, Article은 매개변수 없는 이유
// 3. 리펙토링 부터 집중을 못따라 간거 같습니다


public class Main {
    public static void main(String[] args) {
        List<Member> memberList = new ArrayList<>();
        List<Article> articleList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Member loginMember = null;
        int lastId = 1;

        Member member1 = new Member("user", "1");
        memberList.add(member1);

        while (true) {
            System.out.print("명령어: ");
            String command = sc.nextLine();

            if (command.equals("종료")) {
                System.out.print("== 프로그램을 종료합니다 ==");
                break;

            } else if (command.equals("회원가입")) {
                String userId;
                String password;
                String passwordconfirm;

                while (true) {
                    System.out.print("아이디: ");
                    userId = sc.nextLine();
                    break;
                }
                while (true) {
                    System.out.print("비밀번호: ");
                    password = sc.nextLine();

                    System.out.print("비밀번호 재확인: ");
                    passwordconfirm = sc.nextLine();

                    if (!password.equals(passwordconfirm)) {
                        System.out.println("비밀번호가 다릅니다. // 다시 입력해 주세요");
                        continue;
                    }
                    break;
                }

                System.out.println("== 회원가입이 완료 되었습니다 ==");
                Member member = new Member(userId, password);
                memberList.add(member);

            } else if (command.equals("로그인")) {

                if (loginMember != null) {
                    System.out.println("== 로그인 상태 입니다 ==");
                    continue;
                }

                boolean checkedUserId = false;
                Member member = null;

                System.out.print("아이디: ");
                String userId = sc.nextLine();
                System.out.print("비밀번호: ");
                String password = sc.nextLine();

                for (int i = 0; i < memberList.size(); i++) {
                    if (memberList.get(i).getUserId().equals(userId)) {
                        member = memberList.get(i);
                        checkedUserId = true;
                        break;
                    }
                }
                if (checkedUserId == false) {
                    System.out.println("해당 회원이 존재하지 않습니다.");
                    continue;
                }

                if (member.getPassword().equals(password) == false) {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                    continue;
                }
                loginMember = member;
                System.out.println("== 로그인이 완료되었습니다 ==\n" + loginMember.getUserId() + "님 환영합니다.");

            } else if (command.equals("로그아웃")) {
                if (loginMember == null) {
                    System.out.println("이미 로그아웃 상태입니다.");
                    continue;
                }
                loginMember = null;
                System.out.println("== 계정이 로그아웃 되었습니다 ==");

            } else if (command.equals("등록")) {
                if (loginMember == null) {
                    System.out.println("== 비회원은 게시글 작성을 할 수 없습니다 ==");
                    continue;
                }
                System.out.print("제목: ");
                String title = sc.nextLine();
                System.out.print("내용: ");
                String body = sc.nextLine();

                System.out.println("== 게시글 작성이 완료되었습니다 ==");
                Article article = new Article(lastId, title, body, loginMember.getUserId());
                articleList.add(article);
                lastId++;

            } else if (command.equals("목록")) {
                if (articleList.size() == 0) {
                    System.out.println("작성된 게시글이 없습니다.");
                } else {
                    System.out.printf("번호 / 제목 / 내용 / 글 작성자 \n");
                    for (int i = 0; i < articleList.size(); i++) {
                        Article article = articleList.get(i);
                        System.out.printf("%d / %s / %s / %s \n", article.getId(), article.getTitle(), article.getBody(), article.getUserId());
                    }
                }
            } else if (command.equals("삭제")) {
                if (articleList.size() == 0) {
                    System.out.println("작성된 게시글이 없습니다.");
                } else {
                    int id = sc.nextInt();
                    System.out.print("삭제할 글 번호: ");
                    for (int i = 0; i < articleList.size(); i++) {
                        Article article = articleList.get(i);
                        if (article.getId() == id) {
                            articleList.remove(article);
                        }
                    }
                }
            } else if (command.equals("수정")) {

                for (Article article : articleList) {
                    System.out.printf("%d / %s / %s / %s \n", article.getId(), article.getTitle(), article.getBody(), article.getUserId());
                }
                System.out.print("수정할 글 번호: ");
                int modifyId = sc.nextInt();

                for (int i = 0; i < articleList.size(); i++) {
                    Article article = articleList.get(i);
                    if (article.getId() == modifyId) {

                        System.out.print("제목: \n");
                        String title = sc.nextLine();
                        article.setTitle(title);

                        System.out.print("내용:");
                        String body = sc.nextLine();
                        article.setBody(body);
                    }
                }
                System.out.println("== 게시글이 수정 되었습니다 ==");
            }
        }


    }
}
