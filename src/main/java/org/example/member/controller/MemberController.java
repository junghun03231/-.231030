package org.example.member.controller;

import org.example.container;
import org.example.member.entity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberController {
    List<Member> memberList = new ArrayList<>();

    public void init() {
        Member member1 = new Member("user", "1");
        memberList.add(member1);
    }

    public void join() {
        String userId;
        String password;
        String passwordconfirm;

        while (true) {
            System.out.print("아이디: ");
            userId = container.getSc().nextLine();
            break;
        }
        while (true) {
            System.out.print("비밀번호: ");
            password = container.getSc().nextLine();

            System.out.print("비밀번호 재확인: ");
            passwordconfirm = container.getSc().nextLine();

            if (!password.equals(passwordconfirm)) {
                System.out.println("비밀번호가 다릅니다. // 다시 입력해 주세요");
                continue;
            }
            break;
        }
        System.out.println("== 회원가입이 완료 되었습니다 ==");
        Member member = new Member(userId, password);
        memberList.add(member);
    }

    public void login() {
        if (container.getLoginMember() != null) {
            System.out.println("== 로그인 상태 입니다 ==");
            return;
        }

        boolean checkedUserId = false;
        Member member = null;

        System.out.print("아이디: ");
        String userId = container.getSc().nextLine();
        System.out.print("비밀번호: ");
        String password = container.getSc().nextLine();

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getUserId().equals(userId)) {
                member = memberList.get(i);
                checkedUserId = true;
                break;
            }
        }
        if (!checkedUserId) {
            System.out.println("해당 회원이 존재하지 않습니다.");
            return;
        }

        if (!member.getPassword().equals(password)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }
        container.setLoginMember(member);
        System.out.println("== 로그인이 완료되었습니다 ==\n" + container.getLoginMember().getUserId() + "님 환영합니다.");
    }

    public void logout() {
        if (container.getLoginMember() == null) {
            System.out.println("이미 로그아웃 상태입니다.");
            return;
        }
        container.setLoginMember(null);
        System.out.println("== 계정이 로그아웃 되었습니다 ==");
    }
}
