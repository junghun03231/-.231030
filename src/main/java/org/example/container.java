package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.member.controller.MemberController;
import org.example.member.entity.Member;

import java.util.Scanner;

public class container {
    @Getter
    private static Scanner sc;
    @Setter
    @Getter
    private static Member loginMember;

    static void scan() {
        sc = new Scanner(System.in);
    }

}
